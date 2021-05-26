package fr.eni.appli_enchere.dal;

public abstract class DAOFactory {

	//private static UtilisateurDAO utilisateurDAO;
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOjdbcImpl();
	}
	
	public static VenteDAO getArticleVenduDAO()
	{
		return new VenteDAOjdbcImpl();
	}
	public static RetraitDAO getRetraitDAO()
	{
		return new RetraitDAOjdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOjdbcImpl();
	}
	
}
