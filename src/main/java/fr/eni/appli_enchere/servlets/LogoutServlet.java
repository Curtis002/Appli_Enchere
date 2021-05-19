package fr.eni.appli_enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "LogoutServlet", urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("passe par doGet LogoutServlet");
       HttpSession session = request.getSession();
        if (session != null) {
            System.out.println("passe par if LogoutServlet");
            session.removeAttribute("identifiant");
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
            rd.forward(request,response);
        }
    }
}