package fr.eni.appli_enchere.bo;

public class Categorie {
	private int noCategorie;
	private String libelle;
	
	private ArticleVendu noArticle;
	
	//Constructor
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
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
