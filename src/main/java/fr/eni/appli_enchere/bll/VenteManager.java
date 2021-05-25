package fr.eni.appli_enchere.bll;



import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Categorie;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.VenteDAO;

import java.time.LocalDate;
import java.util.List;

public class VenteManager {

	private VenteDAO  venteDAO;
	
	public VenteManager() {
		this.venteDAO = DAOFactory.getArticleVenduDAO();
	}
	
	public void ajouterVente (ArticleVendu articleVendu ) throws DALException
	{
		System.out.println("passe par Manager.ajouterVente");
		venteDAO.ajouterVente(articleVendu);

	}

	public ArticleVendu addVente(String nom_article, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere, int prixInitial, int no_utilisateur, int no_categorie) throws DALException {
		ArticleVendu articleVendu = new ArticleVendu(nom_article, description, dateDebutEnchere, dateFinEnchere, prixInitial);
		articleVendu.setNomArticle(nom_article);
		articleVendu.setDescription(description);
		articleVendu.setDateDebutEncheres(dateDebutEnchere);
		articleVendu.setDateFinEncheres(dateFinEnchere);
		articleVendu.setMiseAPrix(prixInitial);

		Categorie categorie = new Categorie(no_categorie);
		articleVendu.getListeCategorie().add(categorie);

		Utilisateur utilisateur = new Utilisateur(no_utilisateur);
		articleVendu.getListeUtilisateur().add(utilisateur);

		this.venteDAO.ajouterVente(articleVendu);
		return articleVendu;
	}

//	public List<ArticleVendu> selectAll() throws DALException {
//		System.out.println("passe par manager selectall");
//		return venteDAO.selectAll();
//	}
}
