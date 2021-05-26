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
        HttpSession session = request.getSession();

        if (session != null) {
            session.removeAttribute("pseudo");
            session.removeAttribute("nom");
            session.removeAttribute("prenom");
            session.removeAttribute("email");
            session.removeAttribute("telephone");
            session.removeAttribute("rue");
            session.removeAttribute("code_postal");
            session.removeAttribute("ville");
            session.removeAttribute("mot_de_passe");
            session.removeAttribute("credit");
            session.invalidate();
        }
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request,response);
        }

    }




