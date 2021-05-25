package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.dal.DALException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListeEncheresServlet", value = "/ListeEncheresServlet")
public class ListeEncheresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("passe dans doget ListeEncheresServlet");
        VenteManager venteManager = new VenteManager();
        try {
            request.setAttribute("listeEncheres", venteManager.selectAll());
        } catch (DALException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
