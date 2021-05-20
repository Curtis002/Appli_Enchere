package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;

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
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("ConnectedUser");

        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codepostal = request.getParameter("codePostale");
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
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
        } else if (!email.contains("@")|| allEmail.contains(email)) {
            request.setAttribute("errorEmail", "Veuillez renseigner un email valide");
        } else if (telephone.length() != 10) {
            request.setAttribute("errorTel", "Veuillez renseigner un téléphone valide");
        } else if (codepostal.length() != 5) {
            request.setAttribute("errorcp", "Veuillez renseigner un code postal valide");
        }

        utilisateur.setPseudo(pseudo);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setRue(rue);
        utilisateur.setCode_postal(codepostal);
        utilisateur.setVille(ville);

        if (mdp.equals(utilisateur.getMot_de_passe()) && mdpNew.equals(confirmMdp)) {
            utilisateur.setMot_de_passe(mdpNew);
        }
            try {
                utilisateurManager.updateUtilisateur(utilisateur);
                session.setAttribute("ConnectedUser", utilisateur);
                RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
                rd.forward(request,response);

            } catch (DALException e) {
                e.printStackTrace();
            }
        }
    }

