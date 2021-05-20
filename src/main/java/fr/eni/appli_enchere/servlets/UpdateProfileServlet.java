package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.UtilisateurDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "UpdateProfileServlet", value = "/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur userbdd = new Utilisateur();

        int id = Integer.parseInt(request.getParameter("id"));
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codepostal = request.getParameter("codePostale");
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
        System.out.println("print de mdp " + mdp);
        System.out.println("print userbdd mdp " + userbdd.getMot_de_passe());
        String mdpNew = request.getParameter("mdpNew");
        String confirmMdp = request.getParameter("confirmMdp");

        UtilisateurManager utilisateurManager = new UtilisateurManager();

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(pseudo);

        List<String> allPseudo = null;
        try {
            allPseudo = utilisateurManager.selectAllPseudo();
        } catch (DALException e1) {
            e1.printStackTrace();
        }

        List<String> allEmail = null;
        try {
            allEmail = utilisateurManager.selectAllEmail();
        } catch (DALException e1) {
            e1.printStackTrace();
        }

        if (!matcher.matches() || allPseudo.contains(pseudo)) {
            request.setAttribute("errorPseudo", "Veuillez renseigner un pseudo valide");
        } else if (!email.contains("@") || allEmail.contains(email)) {
            request.setAttribute("errorEmail", "Veuillez renseigner un email valide");
        } else if (telephone.length() != 10) {
            request.setAttribute("errorTel", "Veuillez renseigner un téléphone valide");
        } else if (codepostal.length() != 5) {
            request.setAttribute("errorcp", "Veuillez renseigner un code postal valide");
        }

        if (mdpNew.equals(confirmMdp) && ((mdpNew.equals("") && confirmMdp.equals("")))) {
            Utilisateur utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codepostal, ville, mdpNew);
            try {
                System.out.println("passe par premier if");
                utilisateurManager.updateUtilisateur(utilisateur);
                session.setAttribute("pseudo", pseudo);
                session.setAttribute("nom", nom);
                session.setAttribute("prenom", prenom);
                session.setAttribute("email", email);
                session.setAttribute("telephone", telephone);
                session.setAttribute("rue", rue);
                session.setAttribute("ville", ville);
                session.setAttribute("code_postal", codepostal);
                session.setAttribute("mot_de_passe", mdpNew);
                response.sendRedirect("profile.jsp");
            } catch (DALException e) {
                e.printStackTrace();
            }
        } else {
            Utilisateur utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codepostal, ville,mdp);
            try {
                System.out.println("passe par deuxieme if");
                utilisateurManager.updateUtilisateur(utilisateur);
                session.setAttribute("pseudo", pseudo);
                session.setAttribute("nom", nom);
                session.setAttribute("prenom", prenom);
                session.setAttribute("email", email);
                session.setAttribute("telephone", telephone);
                session.setAttribute("rue", rue);
                session.setAttribute("ville", ville);
                session.setAttribute("code_postal", codepostal);
                session.setAttribute("mot_de_passe", mdp);
                response.sendRedirect("profile.jsp");
            } catch (DALException e) {
                e.printStackTrace();
            }
        }
    }
}


