package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur selectUtilisateur( String email, String password) throws DALException;
	Utilisateur selectPseudo( String pseudo) throws DALException;
	Utilisateur selectEmail( String pseudo) throws DALException;
	Utilisateur selectPrenom( String prenom) throws DALException;
}
