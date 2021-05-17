package fr.eni.appli_enchere.bll;

import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.UtilisateurDAO;


public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	
	public UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public 	Utilisateur selectUtilisateur( String email, String password) throws DALException{
		return utilisateurDAO.selectUtilisateur(email, password);

	};
	public  Utilisateur selectPseudo( String pseudo) throws DALException{
		return utilisateurDAO.selectPseudo(pseudo);
	};
	public  Utilisateur selectPrenom( String prenom) throws DALException{
		return utilisateurDAO.selectPrenom(prenom);
	};
}
