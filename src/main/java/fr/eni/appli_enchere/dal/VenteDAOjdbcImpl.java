package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Categorie;

public class VenteDAOjdbcImpl implements VenteDAO {

	
	public Categorie categorie;
	private static final String AJOUTER_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES  ( ?, ?, ?, ?, ?, ?, ?);";

	private static final String LISTER_ENCHERES_EN_COURS="SELECT * FROM ARTICLES_VENDUS";

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
	
//	public List<ArticleVendu> selectAll() throws DALException {
//		List<ArticleVendu> listeEncheres = new ArrayList<>();
//		Connection cnx=null;
//		PreparedStatement stmt=null;
//		System.out.println("Passe par VenteDAOJdbcImpl dans selectAll");
//
//		try {
//			cnx=ConnectionProvider.getConnection();
//			stmt = cnx.prepareStatement(LISTER_ENCHERES_EN_COURS);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				listeEncheres.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie")));
//			}
//		} catch (SQLException throwables) {
//			throwables.printStackTrace();
//		}
//		return listeEncheres;
//	}
}
