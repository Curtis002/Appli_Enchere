package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.bo.Retrait;

public interface RetraitDAO {

	
	void AjouterAdresse (Retrait retrait) throws DALException;
	
	Retrait selectRetraitById(int id) throws DALException;
}
