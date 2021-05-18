package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.UtilisateurDAO;


	
	public class UtilisateurDAOjdbcImpl implements UtilisateurDAO {
		  
		private static final String GETUSER="SELECT no_utilisateur, pseudo, prenom, nom, pseudo,email,rue,telephone,code_postal,ville,mot_de_passe,credit FROM UTILISATEURS where email=? and mot_de_passe=?;";

		private static final String GETPSEUDO="SELECT pseudo FROM UTILISATEURS where pseudo=?;";
		private static final String GETPRENOM="SELECT prenom FROM UTILISATEURS where prenom=?;";
		private ConnectionProvider ConnexionProvider;


		public Utilisateur selectUtilisateur( String email, String password) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = null;
			
			
			//check nom du provider
			try{
				cnx=ConnexionProvider.getConnection();
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
			}finally{

				//check nom du provider
				ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			return utilisateur;
		}


		public Utilisateur selectPseudo( String pseudo) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = null;
			
			//check nom du provider
			try{
				cnx=ConnexionProvider.getConnection();
				stmt = cnx.prepareStatement(GETPSEUDO);
				stmt.setString(1, pseudo);
				rs=stmt.executeQuery();
				if (rs.next()){
					utilisateur = new Utilisateur();
					utilisateur.setPrenom(rs.getString("pseudo"));
				}
			}catch (SQLException e){
				throw new DALException("probleme methode selectPseudo()",e);
			}finally{
				
				//check nom du provider
				ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			return utilisateur;
		}

		public Utilisateur selectPrenom( String prenom) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = null;
			
			//check nom du provider
			try{
				cnx=ConnexionProvider.getConnection();
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
				ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			return utilisateur;
		}
	
}
