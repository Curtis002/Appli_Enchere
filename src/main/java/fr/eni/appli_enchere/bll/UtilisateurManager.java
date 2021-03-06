package fr.eni.appli_enchere.bll;

import java.util.List;

import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.DALException;
import fr.eni.appli_enchere.dal.DAOFactory;
import fr.eni.appli_enchere.dal.UtilisateurDAO;

import java.util.List;


public class UtilisateurManager {

	private static UtilisateurDAO utilisateurDAO;
	
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public 	Utilisateur selectUtilisateur( String email, String password) throws DALException{
		return utilisateurDAO.selectUtilisateur(email, password);
	}
	public Utilisateur selectPseudo(String pseudo) throws DALException{
		return this.utilisateurDAO.selectPseudo(pseudo);
	}
	public Utilisateur selectEmail(String pseudo) throws DALException{
		return this.utilisateurDAO.selectEmail(pseudo);
	}
	public  Utilisateur selectPrenom( String prenom) throws DALException{
		return utilisateurDAO.selectPrenom(prenom);
	}
	// nouvel utilisateur
	public void registerUtilisateur(Utilisateur utilisateur) throws DALException{
		System.out.println("passe par Manager registerUtilisateur");
		utilisateurDAO.registerUtilisateur(utilisateur);
	}
	
	public List<String> selectAllPseudo() throws DALException {
		System.out.println("passe par Manager selectAllPseudo");
		return utilisateurDAO.selectAllPseudo();
		
	}
	
	public List<String> selectAllEmail() throws DALException {
		System.out.println("passe par Manager selectAllEmail");
		return utilisateurDAO.selectAllEmail();
	}

	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		System.out.println("passe par Manager updateUtilisateur");
		utilisateurDAO.updateUtilisateur(utilisateur);
	}

	public void deleteUtilisateur(Utilisateur utilisateur) throws DALException {
		System.out.println("passe par Manager deleteUtilisateur");
		utilisateurDAO.deleteUtilisateur(utilisateur);
		
	}

	public Utilisateur selectUtilisateurById(int id) throws DALException {
		return utilisateurDAO.selectUtilisateurById(id);
	}

}
