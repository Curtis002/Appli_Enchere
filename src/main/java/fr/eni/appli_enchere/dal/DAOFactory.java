package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.dal.UtilisateurDAO;


public abstract class DAOFactory {

	private static UtilisateurDAO utilisateurDAO;
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		if(utilisateurDAO == null) {
			utilisateurDAO =  new UtilisateurDAOjdbcImpl();
		}
		return utilisateurDAO;
	}
	
}
