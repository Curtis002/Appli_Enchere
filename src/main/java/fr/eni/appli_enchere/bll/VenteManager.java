package fr.eni.appli_enchere.bll;



import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.VenteDAO;

public class VenteManager {

	private static VenteDAO  venteDAO;
	
	public VenteManager() {
		this.venteDAO = DAOFactory.getArticleVenduDAO();
	}
	
	public void ajouterVente (ArticleVendu articleVendu ) throws DALException
	{
		System.out.println("passe par Manager.ajouterVente");
		venteDAO.ajouterVente(articleVendu);
		
		
	
	}

	
}
