package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConnectServlet", urlPatterns = "/ConnectServlet")
public class ConnectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c:cookies) {
                if (c.getName().equals("identifiant")) {
                    request.setAttribute("identifiant", c.getValue());
                }
            }
        }
        System.out.println("passe dans doGet");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("passe par servlet ConnectServlet doPost");
        String pseudo = request.getParameter("pseudo");
        String mot_de_passe = request.getParameter("mdp");
        System.out.println("pseudo récupéré du formulaire: " + pseudo);
        System.out.println("mot de passe récupéré du formulaire: " + mot_de_passe);

        UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur;
        try {
            utilisateur = utilisateurManager.selectPseudo(pseudo);
            if (utilisateur != null && mot_de_passe.equals(utilisateur.getMot_de_passe())) {
                System.out.println("passe par premier if");
                session.setAttribute("ConnectedUser", pseudo);
                response.sendRedirect("listeEncheres.jsp");
            } else {
                System.out.println("passe par deuxième if");
                session.setAttribute("erreur", "erreur mot de passe");
                response.sendRedirect("login.jsp");
            }
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
