package fr.eni.appli_enchere.bo;

import java.util.Date;
import java.util.List;

public class ArticleVendu {
	private Integer no_article;
	private String nom_article;
	private String description;
	private Date date_debut_encheres;
	private Date date_fin_encheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;
	
	private String imgLink;
	
	public Utilisateur utilisateur;
	public Categorie categorie;
	public Retrait retrait;
	private Retrait LieuRetrait;
	private Utilisateur achete;
	private Utilisateur vend;
	
	private List<Enchere> concerne;
	
	
	
	//constructeurs
	
	public ArticleVendu() {
    }
	
	
	public ArticleVendu(ArticleVendu articleVendu) {
    }
	
	
	
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param concerne
	 * @param categorie
	 * @param lieuRetrait
	 * @param achete
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> concerne,
			Categorie categorie, Retrait lieuRetrait, Utilisateur achete) {
		super();
		this.no_article = noArticle;
		this.nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.concerne = concerne;
		this.categorie = categorie;
		LieuRetrait = lieuRetrait;
		this.achete = achete;
	}
	
	
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param concerne
	 * @param categorie
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> concerne,
			Categorie categorie) {
		super();
		this.no_article = noArticle;
		this.nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.concerne = concerne;
		this.categorie = categorie;
	}

	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param concerne
	 * @param categorie
	 * @param achete
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> concerne,
			Categorie categorie, Utilisateur achete) {
		super();
		this.no_article = noArticle;
		this.nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.concerne = concerne;
		this.categorie = categorie;
		this.achete = achete;
	}

	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente) {
		super();
		this.no_article = noArticle;
		this.nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	
	
	
	
	// getters et setters
	
	public Integer getNoArticle() {
		return no_article;
	}
	public void setNoArticle(Integer noArticle) {
		this.no_article = noArticle;
	}
	public String getNomArticle() {
		return nom_article;
	}
	public void setNomArticle(String nomArticle) {
		this.nom_article = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return date_debut_encheres;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.date_debut_encheres = dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return date_fin_encheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.date_fin_encheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public int getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	// to string 
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + no_article + ", nomArticle=" + nom_article + ", description=" + description
				+ ", dateDebutEncheres=" + date_debut_encheres + ", dateFinEncheres=" + date_fin_encheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	

	
}
