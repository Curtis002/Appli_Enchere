package fr.eni.appli_enchere.dal;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.appli_enchere.bo.Categorie;
import fr.eni.appli_enchere.bo.Retrait;

public class RetraitDAOjdbcImpl implements RetraitDAO {

	private static final String AJOUTER_ADRESSE="INSERT INTO RETRAITS ( rue, code_postal, ville, no_article ) VALUES (?, ?, ?, ?);";
	private static final String GETRETRAIT = "SELECT * FROM RETRAITS where no_article=?;";
	
	@Override
	public void AjouterAdresse(Retrait retrait) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		System.out.println("Passe par RetraitDAOJdbcImpl dans ajouteradresseretrait BDD");
		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(AJOUTER_ADRESSE);
		
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());	
			stmt.setInt(4, retrait.getListeArticleVendu().get(0).getNoArticle());
	
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("probleme methode ajouter ajout adresse retrait()",e);
		}
	}
		
		public Retrait selectRetraitById(int id) throws DALException {
			   Connection cnx = null;
			   PreparedStatement stmt = null;
			   ResultSet rs = null;
			   Retrait retrait = null;
			   
			   try {
			      cnx = ConnectionProvider.getConnection();
			      stmt = cnx.prepareStatement(GETRETRAIT);
			      stmt.setInt(1, id);
			      rs = stmt.executeQuery();
			      if (rs.next()) {
			      	retrait = new Retrait(rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"));
//			    	  retrait.setRue(rs.getString("rue"));
//			    	  retrait.setCodePostal(rs.getString("code_postal"));
//			    	  retrait.setVille(rs.getString("ville"));
			      }
			   } catch (SQLException throwables) {
			      throwables.printStackTrace();
			   }
			   
			   System.out.println("Retrait = " + retrait);
			   return retrait;
			}
	
		
}

