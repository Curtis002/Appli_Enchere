package fr.eni.appli_enchere.bo;

import java.util.Date;

public class Enchere {
	private Date date;
	private int montantEnchere;
	
	private ArticleVendu noArticle;
	private Utilisateur no_utilisateur;
	
	//Constructor
	public Enchere(Date date, int montantEnchere) {
		super();
		this.date = date;
		this.montantEnchere = montantEnchere;
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
		return "Enchere [no_utilisateur=" + no_utilisateur + ", noArticle=" + noArticle + ", date=" + date
				+ ", montantEnchere=" + montantEnchere + "]";
	}
	
}
