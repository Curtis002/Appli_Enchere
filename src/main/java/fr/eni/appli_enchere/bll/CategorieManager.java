package fr.eni.appli_enchere.bll;

import fr.eni.appli_enchere.bo.Categorie;
import fr.eni.appli_enchere.dal.CategorieDAO;
import fr.eni.appli_enchere.dal.DALException;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	
	
	public Categorie selectCategorieById(int id) throws DALException{
		return categorieDAO.selectCategorieById(id);
	}

}
