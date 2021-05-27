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
        HttpSession session = request.getSession();

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

        if (matcher.matches()) {
            session.setAttribute("pseudo", pseudo);
        } else {
            request.setAttribute("errorPseudo", "Veuillez renseigner un pseudo valide");
            rd.forward(request, response);
        }

        if (email.contains("@")) {
                session.setAttribute("email", email);
        } else {
            request.setAttribute("errorEmail", "Veuillez renseigner un email valide");
            rd.forward(request, response);
        }

        if (telephone.length() == 10) {
            session.setAttribute("telephone", telephone);
        } else {
            request.setAttribute("errorTel", "Veuillez renseigner un téléphone valide");
            rd.forward(request, response);
        }

        if (codepostal.length() == 5) {
            session.setAttribute("code_postal", codepostal);
        } else {
            request.setAttribute("errorcp", "Veuillez renseigner un code postal valide");
            rd.forward(request, response);
        }

        if (mdp.equals(mdpConf)) {
            if (!allPseudo.contains(pseudo)) {
                if (!allEmail.contains(email)) {
                    session.setAttribute("nom", nom);
                    session.setAttribute("prenom", prenom);
                    session.setAttribute("rue", rue);
                    session.setAttribute("ville", ville);
                    utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, mdp, 0, false);
                    System.out.println(utilisateur);
                    try {
                        utilisateurManager.registerUtilisateur(utilisateur);
                        request.setAttribute("validation", "compte validé");
                        response.sendRedirect("profile.jsp");
                    } catch (DALException e) {
                        e.printStackTrace();
                    }
                } else {
                    request.setAttribute("errorEmail", "Veuillez renseigner un mot de passe valide");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("errorPseudo", "Veuillez renseigner un mot de passe valide");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("errormdp", "Veuillez renseigner un mot de passe valide");
            rd.forward(request, response);
        }
    }
}
