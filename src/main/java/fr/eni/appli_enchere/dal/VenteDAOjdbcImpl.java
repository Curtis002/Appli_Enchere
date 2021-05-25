package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.appli_enchere.bo.ArticleVendu;

public class VenteDAOjdbcImpl implements VenteDAO {

	private static final String AJOUTER_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article, description,no_categorie, date_debut_encheres, date_fin_encheres, prix_initial, no_Utilisateur ) VALUES  ( ?, ?, ?, ?, ?, ?, ? );";
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
			stmt.setInt(3, 1 );//articleVendu.categorie.setLibelle("description")
			stmt.setDate(4, (java.sql.Date) articleVendu.getDateDebutEncheres());
			stmt.setDate(5, (java.sql.Date) articleVendu.getDateFinEncheres());
			stmt.setInt(6, articleVendu.getMiseAPrix());
		
			stmt.setInt(7,2);
			//stmt.setString(8, "src/ ");
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()){
				articleVendu.setNoArticle(rs.getInt(1));
				System.out.println("RENTRE DANS IF ATTRIBUER UN NO ARTICLE AV INTEGER");
			}
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ArticleVendu> selectAll() throws DALException {
		List<ArticleVendu> listeEncheres = new ArrayList<>();
		Connection cnx=null;
		PreparedStatement stmt=null;
		System.out.println("Passe par VenteDAOJdbcImpl dans selectAll");

		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(LISTER_ENCHERES_EN_COURS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listeEncheres.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie")));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listeEncheres;
	}
}
