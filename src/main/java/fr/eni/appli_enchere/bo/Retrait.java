package fr.eni.appli_enchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Retrait {
	private String rue;
	private String codePostal;
	private String ville;
	
	public ArticleVendu articleVendu;
	
	private List<ArticleVendu> listeArticleVendu = new ArrayList<>();
	


	
	
	//Constructor
	
	public Retrait() {
		
	}

	/**
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	//Getter and Setter
	
	public List<ArticleVendu> getListeArticleVendu() {
		return listeArticleVendu;
	}


	public void setListeArticleVendu(List<ArticleVendu> listeArticleVendu) {
		this.listeArticleVendu = listeArticleVendu;
	}
	
	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", getRue()=" + getRue()
				+ ", getCodePostal()=" + getCodePostal() + ", getVille()=" + getVille() + "]";
	}
}
