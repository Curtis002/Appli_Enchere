package fr.eni.appli_enchere.dal;

import fr.eni.appli_enchere.bo.Enchere;

import java.sql.*;

public class EnchereDAOjdbcImpl implements EnchereDAO {

    private static final String INSERTENCHERE = "INSERT INTO ENCHERES (date_enchere,montant_enchere,no_article,no_utilisateur) VALUES (?,?,?,?);";

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
}
