package fr.eni.appli_enchere.bo;

import java.util.Date;

public class Enchere {
	private int no_utilisateur;
	private Integer noArticle;
	private Date date;
	private int montantEnchere;
	
	//Constructor
	public Enchere(int no_utilisateur, Integer noArticle, Date date, int montantEnchere) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.noArticle = noArticle;
		this.date = date;
		this.montantEnchere = montantEnchere;
	}

	//Getter and Setter
	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

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
