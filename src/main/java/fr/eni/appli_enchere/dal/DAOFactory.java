package fr.eni.appli_enchere.dal;

import fr.eni_ecole.appli_enchere.bll.UtilisateurDAO;


public abstract class DAOFactory {

	private static UtilisateurDAO utilisateurDAO;
	
	public static utilisateurDAO getUtilisateurDAO()
	{
		if(utilisateurDAO == null) {
			utilisateurDAO =  new UserDAOjdbclmpl();
		}
		return utilisateurDAO;
	}
	
}
