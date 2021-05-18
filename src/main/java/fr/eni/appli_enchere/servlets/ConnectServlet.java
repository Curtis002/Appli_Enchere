package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bo.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConnectServlet", urlPatterns = "/ConnectServlet")
public class ConnectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c:cookies) {
                if (c.getName().equals("identifiant")) {
                    request.setAttribute("identifiant", c.getValue());
                }
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String identifiant = request.getParameter("identifiant");
        String mdp = request.getParameter("mdp");
        ServletContext context = getServletContext();
        Utilisateur utilisateur = (Utilisateur)context.getAttribute(identifiant);

        if (utilisateur==null || !mdp.equals(utilisateur.getMot_de_passe())) {
            session.setAttribute("hasErrors", true);
            session.setAttribute("isConnected", false);
            response.sendRedirect("login.jsp");
        } else if (mdp.equals(utilisateur.getMot_de_passe())) {
            session.setAttribute("identifiant", identifiant);
            response.sendRedirect("listeEncheres.jsp");
        }
    }
}
