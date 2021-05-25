package fr.eni.appli_enchere.dal;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import fr.eni.appli_enchere.bo.Retrait;

public class RetraitDAOjdbcImpl implements RetraitDAO {

	private static final String AJOUTER_ADRESSE="INSERT INTO RETRAIT (rue, codepostal, ville, no_article ) VALUES (?, ?, ?, ?);";
	
	
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
			throw new DALException("probleme methode ajouter ajoutadrsse retrait()",e);
		}
			
			
		
	}

	
	
}
