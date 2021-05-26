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

        VenteManager venteManager = new VenteManager();
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("Filtrer")) {
                String kw = request.getParameter("kw");
                try {
                    List<ArticleVendu> listArticles = venteManager.selectEncheresByKw(kw);
                    request.setAttribute("listArticles", listArticles);
                    RequestDispatcher rd;
                    if (request.getSession().getAttribute("pseudo") != null) {
                        rd = request.getRequestDispatcher("/accueilConnect.jsp");
                    } else {
                        rd = request.getRequestDispatcher("/accueil.jsp");
                    }
                    rd.forward(request, response);

                } catch (DALException e) {
                    e.printStackTrace();
                }
            } else if (action.equals("Rechercher")) {
                int noCategorie = Integer.parseInt(request.getParameter("categorie"));
                List<ArticleVendu> listArticles = null;
                try {
                    if (noCategorie == 0) {
                        listArticles = venteManager.selectAll();
                        request.setAttribute("listArticles", listArticles);
                    } else {
                        listArticles = venteManager.selectEncheresByCategorie(noCategorie);
                        request.setAttribute("listArticles", listArticles);
                    }
                    RequestDispatcher rd;
                    if (request.getSession().getAttribute("pseudo") != null) {
                        rd = request.getRequestDispatcher("/accueilConnect.jsp");
                    } else {
                        rd = request.getRequestDispatcher("/accueil.jsp");
                    }
                    rd.forward(request, response);
                } catch (DALException e) {
                    e.printStackTrace();
                }
            }
        } else {
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
}
