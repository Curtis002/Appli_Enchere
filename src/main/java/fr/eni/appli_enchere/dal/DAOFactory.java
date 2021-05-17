package fr.eni.appli_enchere.dal;

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
