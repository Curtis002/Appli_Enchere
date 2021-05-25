package fr.eni.appli_enchere.bo;

import java.util.ArrayList;
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

	public Categorie(int noCategorie) {
		this.noCategorie = noCategorie;
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



	public void setNoArticle(List<ArticleVendu> noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", getNoCategorie()="
				+ getNoCategorie() + ", getLibelle()=" + getLibelle() + "]";
	}
}
