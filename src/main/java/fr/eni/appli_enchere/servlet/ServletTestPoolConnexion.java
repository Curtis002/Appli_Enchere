package fr.eni.appli_enchere.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		try {
			Context context;
	        DataSource dataSource = null;
	        try {
	            context = new InitialContext();
	            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
	        } catch (NamingException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Impossible d'accéder à la base de données!!");
	        }
	        
	        Connection cnx = dataSource.getConnection();
	        //cnx.close();
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte")+".");
			cnx.close();//connexion remise dans le pool
		} catch (SQLException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Une erreur est survenue lors de l'utilisation de la base de donnée : " + e.getMessage());
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
