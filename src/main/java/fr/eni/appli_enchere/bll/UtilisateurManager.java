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
	public 	Utilisateur registerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String mdp, int credit, boolean administrateur) throws DALException{
		return utilisateurDAO.registerUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, credit, administrateur);
	}
}
