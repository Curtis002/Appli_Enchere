package fr.eni.appli_enchere.dal;

import java.util.List;

import fr.eni.appli_enchere.bo.Utilisateur;

import java.util.List;


public interface UtilisateurDAO {

	Utilisateur selectUtilisateur( String email, String password) throws DALException;
	Utilisateur selectPseudo( String pseudo) throws DALException;
	Utilisateur selectEmail( String pseudo) throws DALException;
	Utilisateur selectPrenom( String prenom) throws DALException;

	// nouvel utilisateur
	void registerUtilisateur(Utilisateur utilisateur) throws DALException;
	// Mise à jour utilisateur
	void updateUtilisateur(Utilisateur utilisateur) throws DALException;
	// Suppression utilisateur
	void deleteUtilisateur(Utilisateur utilisateur) throws DALException;

	//check pseudo 
	List<String> selectAllPseudo() throws DALException;
	//check email 
	List<String> selectAllEmail() throws DALException;

}
