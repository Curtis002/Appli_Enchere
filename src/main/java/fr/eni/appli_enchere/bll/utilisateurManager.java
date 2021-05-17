package fr.eni.appli_enchere.bll;



import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Utilisateur;


public class utilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	
	public UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUserDAO();
	}
	
	public 	Utilisateur selectUtilisateur( String email, String password) throws DALException{
		return utilisateurDAO.selectUser(email, password);

	};
	public  Utilisateur selectPseudo( String pseudo) throws DALException{
		return utilisateurDAO.selectPseudo(pseudo);
	};
	public  Utilisateur selectPrenom( String prenom) throws DALException{
		return utilisateurDAO.selectPrenom(prenom);
	};
}
