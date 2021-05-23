package fr.eni.appli_enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.UtilisateurDAO;

/**
 * Servlet implementation class DeleteProfileServlet
 */
@WebServlet(name = "DeleteProfileServlet", value = "/DeleteProfileServlet")
public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 UtilisateurManager utilisateurManager = new UtilisateurManager();
		// Utilisateur utilisateur;
		System.out.println("Passe par le do post!");
		//int id = Integer.parseInt(request.getParameter("id"));
		
		int id = Integer.parseInt(request.getParameter("id"));
   
		System.out.println(id);

		
		try {
			Utilisateur utilisateur = new Utilisateur(id);
			utilisateurManager.deleteUtilisateur(utilisateur);
			System.out.println("Passe par delete servlet!");
			session.invalidate();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/accueil.jsp");
			dispatcher.forward(request, response);
		} catch (DALException e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
			dispatcher.forward(request, response);
			
		}
	}


	private Utilisateur getNo_utilisateur() {
		// TODO Auto-generated method stub
		return null;
	}


	private Utilisateur getPseudo() {
		// TODO Auto-generated method stub
		return null;
	}

}
