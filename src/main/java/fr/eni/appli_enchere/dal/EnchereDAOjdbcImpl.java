package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Enchere;
import fr.eni.appli_enchere.bo.Utilisateur;

public class EnchereDAOjdbcImpl implements EnchereDAO {

    private static final String INSERTENCHERE = "INSERT INTO ENCHERES (date_enchere,montant_enchere,no_article,no_utilisateur) VALUES (?,?,?,?);";
	private static final String GET_LIST_ENCHERE="SELECT * FROM ENCHERES";

    @Override
    public void ajouterEnchere(Enchere enchere) throws DALException {
        Connection cnx = null;
        PreparedStatement stmt = null;
        System.out.println("Passe par EnchereDAOJdbcImpl dans addEnchere");
        //check nom du provider
        try {
            cnx = ConnectionProvider.getConnection();
            stmt = cnx.prepareStatement(INSERTENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setTimestamp(1, (Timestamp) enchere.getDate());
            stmt.setInt(2, enchere.getMontantEnchere());
            stmt.setInt(3,enchere.getListArticle().get(0).getNoArticle());
            stmt.setInt(4,enchere.getListUtilisateur().get(0).getNo_utilisateur());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                enchere.setNo_enchere(rs.getInt(1));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new DALException("probleme methode addEnchere dans EnchereDAOjdbcImpl", e);
        }
    }

	public List<Enchere> AfficherAllEncheres() throws DALException {
		List<Enchere> listeDesEncheres = new ArrayList<>();
		Connection cnx = null;
		PreparedStatement stmt = null;
		Utilisateur utilisateurNum = null;
		ArticleVendu num = null;
		Enchere enchere = null;
		System.out.println("Passe par Enchere DAOJdbcImpl dans selectAll Enchere");

		
		
				try {
					cnx=ConnectionProvider.getConnection();
					stmt = cnx.prepareStatement(GET_LIST_ENCHERE);
					ResultSet rs = stmt.executeQuery();

					
					while  (rs.next()) {
						int no_enchere = rs.getInt("no_enchere");
						System.out.println("------no_enchere est : " + no_enchere);
						Timestamp date_enchere = Timestamp.valueOf(rs.getString("date_enchere"));
						System.out.println("------date_enchere est : " + date_enchere);

						int montant_enchere = rs.getInt("montant_enchere");	
						System.out.println("------montant_enchere est : " + montant_enchere);

						int no_article = rs.getInt("no_article");	
						System.out.println("------no_article est : " + no_article);

						int no_utilisateur = rs.getInt("no_utilisateur");	
						System.out.println("------no_utilisateur est : " + no_utilisateur);

						
						//utilisateurNum = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("no_utilisateur"));
						//System.out.println(utilisateurNum);
						
						//articleVendu = new ArticleVendu()
						
						enchere = new Enchere(no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur);
						
						listeDesEncheres.add(enchere);
						
					
					System.out.println("c'est mon enchere   :   "+ enchere);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		return listeDesEncheres;
	
	}
	
}  
