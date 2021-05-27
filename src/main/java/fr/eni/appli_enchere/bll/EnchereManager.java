package fr.eni.appli_enchere.bll;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Enchere;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.EnchereDAO;

import java.util.Date;
import java.util.List;

public class EnchereManager {
    private EnchereDAO enchereDAO;

    public EnchereManager() {this.enchereDAO = DAOFactory.getEnchereDAO();}


    public Enchere addEnchere(Date date,int propEnchere, int numArticleVente, int utilisateurConnecte) throws DALException {
        Enchere enchere = new Enchere(date,propEnchere);
        enchere.setDate(date);
        enchere.setMontantEnchere(propEnchere);

        ArticleVendu article = new ArticleVendu(numArticleVente);
        System.out.println("article dans EnchereManager= "+article);
        enchere.getListArticle().add(article);

        System.out.println("utilisateur connecté dans enchereManager= "+utilisateurConnecte);
        Utilisateur utilisateur = new Utilisateur(utilisateurConnecte);
        System.out.println("utilisateur dans EnchereManager= "+utilisateur);
        enchere.getListUtilisateur().add(utilisateur);

        System.out.println("enchere= "+enchere);
        this.enchereDAO.ajouterEnchere(enchere);
        return enchere;
    }
    
    public List<Enchere> AfficherAllEncheres ( ) throws DALException {
		System.out.println("---passe par manager select all ENCHERES--");

         return enchereDAO.AfficherAllEncheres();
    	
    }

}
