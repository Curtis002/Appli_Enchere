package fr.eni.appli_enchere.dal;



import fr.eni.appli_enchere.bo.ArticleVendu;

public interface VenteDAO {

	
	
	// Method nouvelle vente
	void ajouterVente(ArticleVendu articleVendu ) throws DALException;
	
	
	
}
