package fr.eni.appli_enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.appli_enchere.bo.Utilisateur;



	
	public class UtilisateurDAOjdbcImpl implements UtilisateurDAO {
		  
		private static final String GETUSER="SELECT no_utilisateur, pseudo, prenom, nom, pseudo,email,rue,telephone,code_postal,ville,mot_de_passe,credit FROM UTILISATEURS where email=? and mot_de_passe=?;";
		private static final String GETPSEUDO="SELECT * FROM UTILISATEURS where pseudo=?;";
		private static final String GETEMAIL="SELECT * FROM UTILISATEURS where email=?;";
		private static final String GETPRENOM="SELECT prenom FROM UTILISATEURS where prenom=?;";
		
		// nouvel utilisateur
		private static final String REGISTERUTILISATEUR="INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		
		private ConnectionProvider ConnectionProvider;


		public Utilisateur selectUtilisateur( String email, String password) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = null;
			
			
			//check nom du provider
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
			}finally{

				//check nom du provider
				//ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			System.out.println("passe par SelectUtilisateur dans Impl");
			return utilisateur;
		}


		//CHECK PSEUDO EMAIL
		public Utilisateur selectCheckUtilisateur( String email, String pseudo) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = null;
			
			
			//check nom du provider
			try{
				cnx=ConnectionProvider.getConnection();
				stmt = cnx.prepareStatement(GETUSER);
				stmt.setString(1, email);
				stmt.setString(2, pseudo);
				rs=stmt.executeQuery();
				if (rs.next()){
					utilisateur = new Utilisateur();
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setEmail(rs.getString("email"));
					
				}
			}catch (SQLException e){
				throw new DALException("probleme methode selectCheckUtilisateur()",e);
			}finally{

				//check nom du provider
				//ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			System.out.println("passe par selectCheckUtilisateur dans Impl");
			return utilisateur;
		}
		
		public Utilisateur selectPseudo(String pseudo) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = new Utilisateur();
			
			//check nom du provider
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
			} //finally{
				
				//check nom du provider
				//ConnexionProvider.seDeconnecter(stmt, cnx);
			//}
			System.out.println("passe par SelectPseudo dans Impl");
			return utilisateur;
		}

		@Override
		public Utilisateur selectEmail(String pseudo) throws DALException {
			Connection cnx=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Utilisateur utilisateur = new Utilisateur();

			//check nom du provider
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
			} //finally{

			//check nom du provider
			//ConnexionProvider.seDeconnecter(stmt, cnx);
			//}
			System.out.println("passe par SelectEmail dans Impl");
			return utilisateur;
		}

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
			}finally{

				//check nom du provider
				//ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			System.out.println("passe par registerUtilisateur dans Impl");
		}
	
}
