package fr.eni.appli_enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.appli_enchere.bll.EnchereManager;
import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Enchere;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;

/**
 * Servlet implementation class AfficherEnchereServlet
 */
@WebServlet(name = "AfficherEnchereServlet", urlPatterns = "/AfficherEnchereServlet")
public class AfficherEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/afficherEnchere.jsp");

        EnchereManager enchereManager = new EnchereManager();
		Enchere selectAllEncheres = null;

		int numeroArticle = Integer.parseInt(request.getParameter("num_article"));
		System.out.println("---------- num article recup "+numeroArticle);

        try {
        	selectAllEncheres = enchereManager.AfficherAllEncheres(numeroArticle);
            System.out.println("---selectAllEncheres--   :   " + selectAllEncheres);

        } catch (DALException e1) {
            e1.printStackTrace();
        }

    	//int montant_enchere = Integer.valueOf(request.getParameter("montant_enchere"));
    	//System.out.println("montant_enchere" + montant_enchere);

    	request.setAttribute("montant_enchere", selectAllEncheres);

        VenteManager venteManager = new VenteManager();
	    String nomArticle = request.getParameter("nom_article");
	    System.out.println("nom article = " + nomArticle);

	     try {
	         ArticleVendu articleVendu = venteManager.selectEnchere(nomArticle);
	         request.setAttribute("articleVendu", articleVendu);

	     } catch (DALException e) {
	         e.printStackTrace();
	     }
	     rd.forward(request,response);
 }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
