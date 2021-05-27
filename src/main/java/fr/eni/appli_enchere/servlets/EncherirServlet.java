package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.EnchereManager;
import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Enchere;
import fr.eni.appli_enchere.dal.DALException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "EncherirServlet", urlPatterns = "/EncherirServlet")
public class EncherirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("passe par doget Encherir servlet après enchere");
        String nomArticle = request.getParameter("nom_article");
        System.out.println("nom article = " + nomArticle);
        RequestDispatcher rd = request.getRequestDispatcher("/afficherEnchere.jsp");
        rd.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int propEnchere = Integer.parseInt(request.getParameter("proposition-enchere"));
        System.out.println("proposition enchère récupérée depuis jsp : "+propEnchere);
        Timestamp date = new Timestamp(System.currentTimeMillis());
        System.out.println("date générée !" + date);
        int utilisateurConnecte = (int) request.getSession().getAttribute("noUser");
        System.out.println("utilisateur connecté : "+utilisateurConnecte);
        int numArticleVente = Integer.parseInt(request.getParameter("numArticleVente"));
        System.out.println("numero article récupéré : "+numArticleVente);
        String nomArticle = request.getParameter("nomArticle");

        EnchereManager enchereManager = new EnchereManager();
        Enchere enchere;

        if (propEnchere != 0) {
            System.out.println("passe par if propenchere");
            try {
                enchere = enchereManager.addEnchere(date,propEnchere,numArticleVente,utilisateurConnecte);
                System.out.println("enchere = " +enchere);
                request.setAttribute("encherir",enchere);
                response.sendRedirect("AfficherEnchereServlet?nom_article="+nomArticle);

            } catch (DALException e) {
                e.printStackTrace();
            }

        }
    }
}
