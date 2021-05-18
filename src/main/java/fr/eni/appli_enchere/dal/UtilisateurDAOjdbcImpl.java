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
		private static final String REGISTERUTILISATEUR="INSERT INTO UTILISATEURS (pseudo, prenom, nom, pseudo,email,rue,telephone,code_postal,ville,mot_de_passe,credit, administrateur)"+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
		
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
		public Utilisateur registerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
				String rue, String codePostal, String ville, String mdp, int credit, boolean administrateur)
				throws DALException {
			
			Connection cnx=null;
			PreparedStatement stmt=null;
			Utilisateur utilisateur=null;
			
			
			//check nom du provider
			try{
				
				utilisateur = new Utilisateur();
			
				cnx=ConnectionProvider.getConnection();
				
				stmt = cnx.prepareStatement(REGISTERUTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, pseudo);
				stmt.setString(2, nom);
				stmt.setString(3, prenom);
				stmt.setString(4, email);
				stmt.setString(5, telephone);
				stmt.setString(6, rue);
				stmt.setString(7, codePostal);
				stmt.setString(8, ville);
				stmt.setString(9, mdp);
				stmt.setInt(10, credit);
				stmt.setBoolean(11, administrateur);
				
				int nbRows = stmt.executeUpdate();
				if( nbRows == 1){
					ResultSet rs = stmt.getGeneratedKeys();
					if(rs.next()){
						utilisateur.setNo_utilisateur(rs.getInt(1));
					}
				}
			}catch(SQLException e){
				throw new DALException("probleme methode ajouter utilisateur()",e);
			}finally{

				//check nom du provider
				//ConnexionProvider.seDeconnecter(stmt, cnx);
			}
			System.out.println("passe par registerUtilisateur dans Impl");
			return utilisateur;
		}
	
}
