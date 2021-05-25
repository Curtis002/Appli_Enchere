package fr.eni.appli_enchere.dal;



import fr.eni.appli_enchere.bo.ArticleVendu;

import java.util.List;

public interface VenteDAO {

	
	
	// Method nouvelle vente
	void ajouterVente(ArticleVendu articleVendu ) throws DALException;
	
	// Method lister enchères en cours
	//List<ArticleVendu> selectAll() throws DALException;
	
}
