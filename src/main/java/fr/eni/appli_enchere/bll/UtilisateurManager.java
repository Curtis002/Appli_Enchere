package fr.eni.appli_enchere.bll;

import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.UtilisateurDAO;



public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public 	Utilisateur selectUtilisateur( String email, String password) throws DALException{
		return utilisateurDAO.selectUtilisateur(email, password);
	}
	public Utilisateur selectPseudo(String pseudo) throws DALException{
		return this.utilisateurDAO.selectPseudo(pseudo);
	}
	public Utilisateur selectEmail(String pseudo) throws DALException{
		return this.utilisateurDAO.selectEmail(pseudo);
	}
	public  Utilisateur selectPrenom( String prenom) throws DALException{
		return utilisateurDAO.selectPrenom(prenom);
	}
	// nouvel utilisateur
	public void registerUtilisateur(Utilisateur utilisateur) throws DALException{
		System.out.println("passe par Manager registerUtilisateur");
		utilisateurDAO.registerUtilisateur(utilisateur);
	}
	
	//check pseudo email
	public Utilisateur selectCheckUtilisateur( String email, String pseudo) throws DALException{
		System.out.println("passe par Manager selectCheckUtilisateur");
		return utilisateurDAO.selectUtilisateur(email, pseudo);
	}
	
	
}
