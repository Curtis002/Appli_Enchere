package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        String pseudoUtilisateur = request.getParameter("pseudo");

        try {
            Utilisateur unUtilisateur = utilisateurManager.selectPseudo(pseudoUtilisateur);
            request.setAttribute("unUtilisateur", unUtilisateur);
        } catch (DALException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/profilAutreUtilisateur.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
