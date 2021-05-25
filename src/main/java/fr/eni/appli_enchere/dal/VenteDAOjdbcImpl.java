package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Categorie;

public class VenteDAOjdbcImpl implements VenteDAO {

	
	public Categorie categorie;
	private static final String AJOUTER_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article, description,no_categorie, date_debut_encheres, date_fin_encheres, prix_initial, no_Utilisateur ) VALUES  ( ?, ?, ?, ?, ?, ?, ? );";
	
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
			stmt.setInt(3, articleVendu.categorie.getNoCategorie());
			stmt.setDate(4, Date.valueOf(articleVendu.getDateDebutEncheres()));
			stmt.setDate(5, Date.valueOf(articleVendu.getDateFinEncheres()));
			stmt.setInt(6, articleVendu.getMiseAPrix());
			stmt.setInt(7,articleVendu.utilisateur.getNo_utilisateur());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()){
				System.out.println("RENTRE DANS IF ATTRIBUER UN NO ARTICLE AV INTEGER");
				articleVendu.setNoArticle(rs.getInt(1));
			}
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			throw new DALException("probleme methode ajouter ajoutVente()",e);

		}
		
	}
	
	

}
