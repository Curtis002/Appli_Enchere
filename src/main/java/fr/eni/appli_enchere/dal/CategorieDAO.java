package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.bo.Categorie;

public interface CategorieDAO {
	
	Categorie selectCategorieById(int id) throws DALException;

}
