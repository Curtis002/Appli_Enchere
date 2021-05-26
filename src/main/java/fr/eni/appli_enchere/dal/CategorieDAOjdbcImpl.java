package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.appli_enchere.bo.Categorie;

public class CategorieDAOjdbcImpl implements CategorieDAO{
	
	private static final String GETCATEGORIEBYID = "SELECT libelle FROM CATEGORIES where no_categorie=?;";



	
	public Categorie selectCategorieById(int id) throws DALException {
		   Connection cnx = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   Categorie categorie = new Categorie();
		   
		   try {
		      cnx = ConnectionProvider.getConnection();
		      stmt = cnx.prepareStatement(GETCATEGORIEBYID);
		      stmt.setInt(1, id);
		      rs = stmt.executeQuery();
		      if (rs.next()) {
		    	  categorie.setLibelle(rs.getString("libelle"));
		      }
		   } catch (SQLException throwables) {
		      throwables.printStackTrace();
		   }
		   return categorie;
		}

}
