package fr.eni.appli_enchere.servlets;

import fr.eni.appli_enchere.bll.UtilisateurManager;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codepostal = request.getParameter("codePostale");
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
        String mdpConf = request.getParameter("confirmMdp");
        System.out.println("pseudo : " + pseudo);
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur = null;
        RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(pseudo);
        
        List<String> allPseudo = null;
		try {
			allPseudo = utilisateurManager.selectAllPseudo();
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<String> allEmail = null;
		try {
			allEmail = utilisateurManager.selectAllEmail();
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
       
        
        
        if (!matcher.matches() || allPseudo.contains(pseudo)) {
            request.setAttribute("errorPseudo", "Veuillez renseigner un pseudo valide");
            System.out.println("passe pseudo");
//            rd.forward(request, response);
        } else if (!email.contains("@")|| allEmail.contains(email)) {
            request.setAttribute("errorEmail", "Veuillez renseigner un email valide");
            System.out.println("passe email");
//          rd.forward(request, response);
        } else if (telephone.length() != 10) {
            request.setAttribute("errorTel", "Veuillez renseigner un téléphone valide");
            System.out.println("passe tel");
//          rd.forward(request, response);
        } else if (codepostal.length() != 5) {
            request.setAttribute("errorcp", "Veuillez renseigner un code postal valide");
            System.out.println("passe cp");
        }
            rd.forward(request, response);

        if (mdp.equals(mdpConf)) {
            System.out.println("passe après tous les if servlet register");
            utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, mdp, 0, false);
            System.out.println(utilisateur);
            try {
                utilisateurManager.registerUtilisateur(utilisateur);
                response.sendRedirect("profile.jsp");
            } catch (DALException e) {
                e.printStackTrace();
            }
        }
    }
}
