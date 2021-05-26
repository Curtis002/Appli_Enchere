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
import java.util.List;

@WebServlet(name = "ListeEncheresServlet", urlPatterns = "/ListeEncheresServlet")
public class ListeEncheresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("passe dans doget ListeEncheresServlet");
        VenteManager venteManager = new VenteManager();
        try {
            List<ArticleVendu> listArticles = venteManager.selectAll();
            request.setAttribute("listArticles", listArticles);
            RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
            rd.forward(request, response);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
