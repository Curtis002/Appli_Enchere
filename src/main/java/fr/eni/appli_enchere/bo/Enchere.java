package fr.eni.appli_enchere.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Enchere {
	private Date date;
	private int montantEnchere;
	private int no_enchere;
	
//	private int noArticle;
//	private int no_utilisateur;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	private List<Utilisateur> listUtilisateur = new ArrayList<>();
	private List<ArticleVendu> listArticle = new ArrayList<>();
	
	//Constructor
	public Enchere(Date date,int montantEnchere) {
		super();
		this.date = date;
		this.montantEnchere = montantEnchere;
	}


	public int getNo_enchere() {
		return no_enchere;
	}

	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public List<ArticleVendu> getListArticle() {
		return listArticle;
	}

	//Getter and Setter
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [date=" + date
				+ ", montantEnchere=" + montantEnchere + "]";
	}
	
}
