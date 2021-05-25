package fr.eni.appli_enchere.bo;

import java.util.List;

public class Categorie {
	public int noCategorie;
	private String libelle;
	
	private List<ArticleVendu> noArticle;
	
	//Constructor
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	

	public Categorie() {
		// TODO Auto-generated constructor stub
	}


	//Getter and Setter
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", getNoCategorie()="
				+ getNoCategorie() + ", getLibelle()=" + getLibelle() + "]";
	}
}
