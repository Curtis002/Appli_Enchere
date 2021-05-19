package fr.eni.appli_enchere.dal;

import java.util.List;

import fr.eni.appli_enchere.bo.Utilisateur;


public interface UtilisateurDAO {

	Utilisateur selectUtilisateur( String email, String password) throws DALException;
	Utilisateur selectPseudo( String pseudo) throws DALException;
	Utilisateur selectEmail( String pseudo) throws DALException;
	Utilisateur selectPrenom( String prenom) throws DALException;
	
	// nouvel utilisateur
	void registerUtilisateur(Utilisateur utilisateur) throws DALException;
	
	//check pseudo email
	Utilisateur selectCheckUtilisateur( String email, String pseudo) throws DALException;

	//check pseudo 
	public List<String> selectAllPseudo() throws DALException;
	//check email 
	public List<String> selectAllEmail() throws DALException;
}
