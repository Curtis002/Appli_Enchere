package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Categorie;
import fr.eni.appli_enchere.bo.Retrait;
import fr.eni.appli_enchere.bo.Utilisateur;

public class VenteDAOjdbcImpl implements VenteDAO {

	
	public Categorie categorie;
	private static final String AJOUTER_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES  ( ?, ?, ?, ?, ?, ?, ?);";
	private static final String LISTER_ENCHERES_EN_COURS="SELECT * FROM ARTICLES_VENDUS";
	private static final String ENCHERESBYKW="SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE ?";
	private static final String ENCHERESBYCATEGORIE="SELECT * FROM ARTICLES_VENDUS WHERE no_categorie LIKE ?";
	private static final String GETENCHERE="SELECT * FROM ARTICLES_VENDUS where nom_article=?";
	
	private ConnectionProvider ConnectionProvider;
	
	@Override
	public void ajouterVente(ArticleVendu articleVendu) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		System.out.println("Passe par VenteDAOJdbcImpl dans ajouterVenteUtilisateur");
		
		
		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(AJOUTER_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articleVendu.getNomArticle());
			stmt.setString(2, articleVendu.getDescription());
			stmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
			stmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
			stmt.setInt(5, articleVendu.getMiseAPrix());
			stmt.setInt(6,articleVendu.getListeUtilisateur().get(0).getNo_utilisateur());
			stmt.setInt(7,articleVendu.getListeCategorie().get(0).getNoCategorie());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()){
				System.out.println("RENTRE DANS IF ATTRIBUER UN NO ARTICLE AV INTEGER");
				articleVendu.setNoArticle(rs.getInt(1));
				
		
			}
		
		} catch (SQLException e) {
			throw new DALException("probleme methode ajouter ajoutVente()",e);

		}
		
	}

	public List<ArticleVendu> selectEncheresByCategorie(int noCategorie) throws DALException {
		List<ArticleVendu> listeEncheres = new ArrayList<>();
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Utilisateur utilisateurVente = null;
		ArticleVendu articleVendu = null;
		Categorie categorie = new Categorie();

		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(ENCHERESBYCATEGORIE);
			stmt.setInt(1, noCategorie);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebut = LocalDate.parse(rs.getString("date_debut_encheres"));
				LocalDate dateFin = LocalDate.parse(rs.getString("date_fin_encheres"));
				int miseAPrix = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");

				utilisateurVente = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("no_utilisateur"));
				System.out.println(utilisateurVente);
				categorie = new Categorie(rs.getInt("no_categorie"));

				articleVendu = new ArticleVendu(no_article,nom_article,description,dateDebut,dateFin,miseAPrix,prixVente,utilisateurVente,categorie);

				System.out.println(articleVendu);
				listeEncheres.add(articleVendu);
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return listeEncheres;
	}

	public List<ArticleVendu> selectEncheresByKw(String kw) throws DALException {
		List<ArticleVendu> listeEncheres = new ArrayList<>();
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Utilisateur utilisateurVente = null;
		ArticleVendu articleVendu = null;
		Categorie categorie = new Categorie();

		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(ENCHERESBYKW);
			stmt.setString(1, "%" + kw + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebut = LocalDate.parse(rs.getString("date_debut_encheres"));
				LocalDate dateFin = LocalDate.parse(rs.getString("date_fin_encheres"));
				int miseAPrix = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");

				utilisateurVente = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("no_utilisateur"));
				System.out.println(utilisateurVente);
				categorie = new Categorie(rs.getInt("no_categorie"));

				articleVendu = new ArticleVendu(no_article,nom_article,description,dateDebut,dateFin,miseAPrix,prixVente,utilisateurVente,categorie);

				System.out.println(articleVendu);
				listeEncheres.add(articleVendu);
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return listeEncheres;
	}

	public List<ArticleVendu> selectAll() throws DALException {
		List<ArticleVendu> listeEncheres = new ArrayList<>();
		Utilisateur utilisateurVente = null;
		ArticleVendu articleVendu = null;
		Categorie categorie = new Categorie();
		Connection cnx=null;
		PreparedStatement stmt=null;
		System.out.println("Passe par VenteDAOJdbcImpl dans selectAll");

		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(LISTER_ENCHERES_EN_COURS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebut = LocalDate.parse(rs.getString("date_debut_encheres"));
				LocalDate dateFin = LocalDate.parse(rs.getString("date_fin_encheres"));
				int miseAPrix = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");

				utilisateurVente = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("no_utilisateur"));
				System.out.println(utilisateurVente);
				categorie = new Categorie(rs.getInt("no_categorie"));

				articleVendu = new ArticleVendu(no_article,nom_article,description,dateDebut,dateFin,miseAPrix,prixVente,utilisateurVente,categorie);

				System.out.println(articleVendu);
				listeEncheres.add(articleVendu);

				// récupérer liste de tous les utilisateurs de la bdd
				// boucler sur cette liste pour récupérer l'utilisateur qui a le même id que noUtilisateur
				// créer un utilisateur avec les informations récupérées
				// ajouter dans Article Vendu l'utilisateur

				System.out.println("passe par selectAll dans venteDAOjdbcImpl");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listeEncheres;
	}
	
	public ArticleVendu selectEnchere(String nomArticle) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArticleVendu articleVendu = null;
		System.out.println("Passe par le Enchere DAO JDBC");

		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETENCHERE);
			stmt.setString(1, nomArticle);
			rs=stmt.executeQuery();
			//System.out.println("Article  = " + nomArticle);
			if (rs.next()){
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateFin = LocalDate.parse(rs.getString("date_fin_encheres"));
				int miseAPrix = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");

				Utilisateur utilisateurVente = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("no_utilisateur"));
				Categorie categorie = DAOFactory.getCategorieDAO().selectCategorieById(rs.getInt("no_categorie"));
				Retrait retrait = DAOFactory.getRetraitDAO().selectRetraitById(rs.getInt("no_article"));
				System.out.println("numero article récupéré pour retrait : "+rs.getInt("no_article"));
				System.out.println(retrait);

				articleVendu = new ArticleVendu(no_article,nom_article,description,dateFin,miseAPrix,prixVente,utilisateurVente,categorie,retrait);


//				articleVendu.setNomArticle(rs.getString("nom_article"));
//				System.out.println("Article  = " + nomArticle);
//				articleVendu.setDescription(rs.getString("description"));
//
//				Categorie categorie = DAOFactory.getCategorieDAO().selectCategorieById(rs.getInt("no_categorie"));
//				System.out.println(categorie);
//				articleVendu.setCategorie(categorie);
//
//				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
//				articleVendu.setDateFinEncheres(LocalDate.parse(rs.getString("date_fin_encheres")));
//
//				System.out.println("no_article = " + rs.getInt("no_article"));
//				Retrait retrait = DAOFactory.getRetraitDAO().selectRetraitById(rs.getInt("no_article"));
//				System.out.println(retrait);
//				articleVendu.setRetrait(retrait);

				System.out.println("Article vendu = " + articleVendu);
			}
		}catch (SQLException e){
			throw new DALException("probleme methode selectEncher()",e);
		}
		return articleVendu;
	}
}
