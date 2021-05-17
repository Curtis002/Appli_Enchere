package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	public 	Utilisateur selectUtilisateur( String email, String password) throws DALException;
	public  Utilisateur selectPseudo( String pseudo) throws DALException;
	public  Utilisateur selectPrenom( String prenom) throws DALException;
	
}
