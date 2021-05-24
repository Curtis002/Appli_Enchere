package fr.eni.appli_enchere.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Categorie;
import fr.eni.appli_enchere.dal.DALException;

/**
 * Servlet implementation class VenteArticleServlet
 */
@WebServlet("/VenteArticleServlet")
public class VenteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private VenteManager venteManager;
       private Categorie categorie;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SERVLET VENTE ARTICLE passe dans DO GET");

	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
	 */
	/**
	 *
	 */
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession();
			System.out.println("SERVLET VENTE ARTICLE passe dans DO POST");

			String nomArticle = request.getParameter("nom_article");
			String description = request.getParameter("description");
			//String categorie = request.getParameter("categorie");
			String dateDebutEncheres = request.getParameter("dateDebutEncheres");
			String dateFinEncheres = request.getParameter("dateFinEncheres");
			//String miseAPrix = request.getParameter("miseAPrix");
			//String prixdevente = request.getParameter("prixdevente");
			//String imgLink = request.getParameter("imgLink");
			
			
			VenteManager venteManager = new VenteManager();
			ArticleVendu articleVendu = null;
	        RequestDispatcher rd = request.getRequestDispatcher("/nouvelleVente.jsp");

			
				
				session.setAttribute("nom_article", nomArticle);
				System.out.println("nom_article"+ nomArticle);
				session.setAttribute("description", description);
				//session.setAttribute("categorie", categorie);
				session.setAttribute("dateDebutEncheres", dateDebutEncheres);
				session.setAttribute("dateFinEncheres", dateFinEncheres);
				//session.setAttribute("miseAPrix", miseAPrix);
				//session.setAttribute("prixdevente", prixdevente);
				//session.setAttribute("imgLink", imgLink);
				

				articleVendu = new ArticleVendu(articleVendu);
				System.out.println("articleVendu" + articleVendu);
				venteManager.ajouterVente(articleVendu);
				
				request.setAttribute("validation", "annonce validé");
                response.sendRedirect("nouvelleVente.jsp");

			} catch (DALException e) {

				e.printStackTrace();
				System.out.println("probleme dans la servlet vente article");
			}
			
			
			
			}
		  
	

}
