package fr.eni.appli_enchere.bll;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Categorie;
import fr.eni.appli_enchere.bo.Retrait;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.RetraitDAO;

public class RetraitManager {

	private static RetraitDAO retraitDAO;
	
	
	public RetraitManager() {
		
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}

	void AjouterAdresse (Retrait retrait) throws DALException{
		System.out.println("passe par Manager registerUtilisateur");
		retraitDAO.AjouterAdresse(retrait);
		
	}

	public Retrait addAdresse(String rue, String codepostal, String ville, int noArticle ) throws DALException{
	Retrait retrait = new Retrait( rue,  codepostal,  ville);
	retrait.setRue(rue);
	retrait.setCodePostal(codepostal);
	retrait.setVille(ville);
	
	
	ArticleVendu articleVendu = new ArticleVendu(noArticle);
	retrait.getListeArticleVendu().add(articleVendu);
	
	this.retraitDAO.AjouterAdresse(retrait);
	return retrait;
	}
}