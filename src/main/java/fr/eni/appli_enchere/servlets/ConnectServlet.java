package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ConnectServlet", urlPatterns = "/ConnectServlet")
public class ConnectServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("identifiant")) {
                    request.setAttribute("identifiant", c.getValue());
                }
            }
        }
        VenteManager venteManager = new VenteManager();

        List<ArticleVendu> listArticles = null;
        try {
            listArticles = venteManager.selectAll();
            request.setAttribute("listArticles", listArticles);
        } catch (DALException e) {
            e.printStackTrace();
        }

        if (request.getSession().getAttribute("pseudo") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/accueilConnect.jsp");
            rd.forward(request, response);

        } else if (request.getSession().getAttribute("pseudo") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VenteManager venteManager = new VenteManager();
        System.out.println("passe par servlet ConnectServlet doPost");
        String pseudo = request.getParameter("pseudo");
        String mot_de_passe = request.getParameter("mdp");
        System.out.println("pseudo récupéré du formulaire: " + pseudo);
        System.out.println("mot de passe récupéré du formulaire: " + mot_de_passe);

        UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur;
        try {
            if (pseudo.contains("@")) {
                utilisateur = utilisateurManager.selectEmail(pseudo);
            } else {
                utilisateur = utilisateurManager.selectPseudo(pseudo);
            }
            if (utilisateur != null && mot_de_passe.equals(utilisateur.getMot_de_passe())) {
                System.out.println("passe par premier if");
                session.setAttribute("id", utilisateur.getNo_utilisateur());
                session.setAttribute("pseudo", pseudo);
                session.setAttribute("noUser", utilisateur.getNo_utilisateur());
                session.setAttribute("nom", utilisateur.getNom());
                session.setAttribute("prenom", utilisateur.getPrenom());
                session.setAttribute("email", utilisateur.getEmail());
                session.setAttribute("telephone", utilisateur.getTelephone());
                session.setAttribute("rue", utilisateur.getRue());
                session.setAttribute("code_postal", utilisateur.getCode_postal());
                session.setAttribute("ville", utilisateur.getVille());
                session.setAttribute("mot_de_passe", utilisateur.getMot_de_passe());
                session.setAttribute("credit", utilisateur.getCredit());

                List<ArticleVendu> listArticles = null;
                listArticles = venteManager.selectAll();
                request.setAttribute("listArticles", listArticles);

                RequestDispatcher rd = request.getRequestDispatcher("/accueilConnect.jsp");
                rd.forward(request, response);

            } else if (utilisateur == null || !mot_de_passe.equals(utilisateur.getMot_de_passe())) {
                System.out.println("passe par deuxième if");
                request.setAttribute("error", "Erreur mot de passe");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
