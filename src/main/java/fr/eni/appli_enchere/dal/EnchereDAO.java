package fr.eni.appli_enchere.dal;

import java.util.List;

import fr.eni.appli_enchere.bo.Enchere;

public interface EnchereDAO {

    void ajouterEnchere(Enchere enchere) throws DALException;
    
    
    List<Enchere> AfficherAllEncheres( ) throws DALException;
}
