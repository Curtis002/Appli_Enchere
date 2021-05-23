package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.appli_enchere.bo.Utilisateur;

public class UtilisateurDAOjdbcImpl implements UtilisateurDAO {

	private static final String GETUSER="SELECT no_utilisateur, pseudo, prenom, nom, pseudo,email,rue,telephone,code_postal,ville,mot_de_passe,credit FROM UTILISATEURS where email=? and mot_de_passe=?;";
	private static final String GETPSEUDO="SELECT * FROM UTILISATEURS where pseudo=?;";
	private static final String GETALLPSEUDO="SELECT pseudo FROM UTILISATEURS ";
	private static final String GETALLEMAIL="SELECT email FROM UTILISATEURS ";
	private static final String GETEMAIL="SELECT * FROM UTILISATEURS where email=?;";
	private static final String GETPRENOM="SELECT prenom FROM UTILISATEURS where prenom=?;";
	private static final String REGISTERUTILISATEUR="INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String UPDATEUTILISATEUR="UPDATE UTILISATEURS SET pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=? WHERE no_utilisateur=?";
	private static final String DELETEUTILISATEUR="DELETE FROM UTILISATEURS where no_utilisateur=?";
	
	private ConnectionProvider ConnectionProvider;

	/**
	 * Sélectionner un utilisateur particulier
	 * @param email
	 * @param password
	 * @return
	 * @throws DALException
	 */
	public Utilisateur selectUtilisateur( String email, String password) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Utilisateur utilisateur = null;

		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETUSER);
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			if (rs.next()){
				utilisateur = new Utilisateur();
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
			}
		}catch (SQLException e){
			throw new DALException("probleme methode lister()",e);
		}
		return utilisateur;
	}

	/**
	 * Sélectionner tous les pseudos de la base de données pour retourner une liste
	 * @return
	 * @throws DALException
	 */
	public List<String> selectAllPseudo() throws DALException{
		List<String> listePseudo = new ArrayList<>();
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETALLPSEUDO);
			rs=stmt.executeQuery();
			while (rs.next()){
				listePseudo.add(rs.getString("pseudo"));

			}
		}catch (SQLException e){
			throw new DALException("probleme methode selectAllPseudo()",e);
		}
		return listePseudo;
	}

	/**
	 * Sélectionner tous les emails de la base de données pour retourner une liste
	 * @return
	 * @throws DALException
	 */
	public List<String> selectAllEmail() throws DALException{
		List<String> listeEmail = new ArrayList<>();
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETALLEMAIL);
			rs=stmt.executeQuery();
			while (rs.next()){
				listeEmail.add(rs.getString("email"));

			}
		}catch (SQLException e){
			throw new DALException("probleme methode selectAllEmail()",e);
		}
		return listeEmail;
	}

	/**
	 * Sélectionner un utilisateur en particulier avec son pseudo en paramètre
	 * @param pseudo
	 * @return
	 * @throws DALException
	 */
	public Utilisateur selectPseudo(String pseudo) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Utilisateur utilisateur = new Utilisateur();

		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETPSEUDO);
			stmt.setString(1, pseudo);
			rs=stmt.executeQuery();
			if (rs.next()){
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				System.out.println(utilisateur);
			}
		}catch (SQLException e){
			throw new DALException("probleme methode selectPseudo()",e);
		}
		return utilisateur;
	}

	/**
	 * Sélectionner l'email d'un utilisateur par rapport à son pseudo
	 * @param pseudo
	 * @return
	 * @throws DALException
	 */
	@Override
	public Utilisateur selectEmail(String pseudo) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Utilisateur utilisateur = new Utilisateur();

		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETEMAIL);
			stmt.setString(1, pseudo);
			rs=stmt.executeQuery();
			if (rs.next()){
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				System.out.println(utilisateur);
			}
		}catch (SQLException e){
			throw new DALException("probleme methode selectEmail()",e);
		}
		return utilisateur;
	}

	/**
	 * Sélectionner le prénom d'un utilisateur
	 * @param prenom
	 * @return
	 * @throws DALException
	 */
	public Utilisateur selectPrenom( String prenom) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Utilisateur utilisateur = null;

		//check nom du provider
		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(GETPRENOM);
			stmt.setString(1, prenom);
			rs=stmt.executeQuery();
			if (rs.next()){
				utilisateur = new Utilisateur();
				utilisateur.setPrenom(rs.getString("prenom"));
			}
		}catch (SQLException e){
			throw new DALException("probleme methode selectPrenom()",e);
		}finally{

			//check nom du provider
			//ConnexionProvider.seDeconnecter(stmt, cnx);
		}
		System.out.println("passe par SelectPrenom dans Impl");
		return utilisateur;
	}

	/**
	 * Permet d'enregistrer un utilisateur en base de donnée
	 * @param utilisateur
	 * @throws DALException
	 */
	@Override
	public void registerUtilisateur(Utilisateur utilisateur) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		System.out.println("Passe par UtilisateurDAOJdbcImpl dans registerUtilisateur");
		//check nom du provider
		try{
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(REGISTERUTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.isAdministrateur());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			if(rs.next()){
				utilisateur.setNo_utilisateur(rs.getInt(1));
			}
			rs.close();
			stmt.close();
		}catch(SQLException e){
			throw new DALException("probleme methode ajouter utilisateur()",e);
		}
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		try {
			cnx=ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(UPDATEUTILISATEUR);
			stmt.setString(1,utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10,utilisateur.getNo_utilisateur());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("probleme methode update utilisateur()",e);
		}
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) throws DALException {
		Connection cnx=null;
		PreparedStatement stmt=null;
		System.out.println("Passe avant le try ");
	
		try {
			cnx=ConnectionProvider.getConnection();
			//utilisateur = new Utilisateur(); 
			stmt = cnx.prepareStatement(DELETEUTILISATEUR);
			stmt.setInt(1,utilisateur.getNo_utilisateur());
//			stmt.setString(1,"");
//			stmt.setString(3, utilisateur.getNom());
//			stmt.setString(4, utilisateur.getPrenom());
//			stmt.setString(5, utilisateur.getEmail());
//			stmt.setString(6, utilisateur.getTelephone());
//			stmt.setString(7, utilisateur.getRue());
//			stmt.setString(8, utilisateur.getCode_postal());
//			stmt.setString(9, utilisateur.getVille());
//			stmt.setString(10, utilisateur.getMot_de_passe());
//			stmt.setInt(11, utilisateur.getCredit());
			stmt.executeUpdate();
			System.out.println("Passe dans le try ");

		} catch (SQLException e) {
			throw new DALException("probleme methode suppression utilisateur()",e);
		}
	}


}
