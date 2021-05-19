package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.bo.Utilisateur;

import java.util.List;


public interface UtilisateurDAO {

	Utilisateur selectUtilisateur( String email, String password) throws DALException;
	Utilisateur selectPseudo( String pseudo) throws DALException;
	Utilisateur selectEmail( String pseudo) throws DALException;
	Utilisateur selectPrenom( String prenom) throws DALException;

	// nouvel utilisateur
	void registerUtilisateur(Utilisateur utilisateur) throws DALException;
	
	//check pseudo email
	Utilisateur selectCheckUtilisateur( String email, String pseudo) throws DALException;

}
