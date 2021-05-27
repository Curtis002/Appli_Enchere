package fr.eni.appli_enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
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
		System.out.println("passe dans doget AfficherEncheresServlet");

		VenteManager venteManager = new VenteManager();
	    String nomArticle = request.getParameter("nom_article");
	    System.out.println("nom article = " + nomArticle);
	     try {
	         ArticleVendu articleVendu = venteManager.selectEnchere(nomArticle);
	         request.setAttribute("articleVendu", articleVendu);
	        
	     } catch (DALException e) {
	         e.printStackTrace();
	     }
	     RequestDispatcher rd = request.getRequestDispatcher("/afficherEnchere.jsp");
	     rd.forward(request,response);

 }
}
