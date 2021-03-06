package fr.eni.appli_enchere.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendu {
	
	

	private Integer no_article;
	private String nom_article;
	private String description;
	private LocalDate date_debut_encheres;
	private LocalDate date_fin_encheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;
	
	private String imgLink;
	
	public Utilisateur utilisateur = new Utilisateur();
	public Categorie categorie;
	public Retrait retrait;
	private Retrait LieuRetrait;
	private Utilisateur achete;
	private Utilisateur vend;
	
	private List<Enchere> concerne = new ArrayList<>();
	private List<Categorie> listeCategorie = new ArrayList<>();
	private List<Utilisateur> listeUtilisateur = new ArrayList<>();
	
	//constructeurs
	
	public ArticleVendu() {
    }
	
	
	public ArticleVendu(Integer noArticle) {

		super();
		this.no_article = noArticle;
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
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> concerne,
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
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> concerne,
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
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> concerne,
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
	 * @param no_utilisateur
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, int no_utilisateur) {
		super();
		this.no_article = noArticle;
		this.nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.utilisateur.setNo_utilisateur(no_utilisateur);
	}
	
	/**
	 * @param no_article
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param miseAPrix
	 * @param utilisateur
	 * @param categorie
	 */
	public ArticleVendu(Integer no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int miseAPrix, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.miseAPrix = miseAPrix;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}


	public ArticleVendu(int no_article,String nom_article, String description, LocalDate date_fin_encheres, int miseAPrix, int prixVente, Utilisateur utilisateur, Categorie categorie, Retrait retrait) {
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_fin_encheres = date_fin_encheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.retrait = retrait;
	}

	public ArticleVendu(String nomArticle, String description, int no_categorie, LocalDate dateDebutEncheres,
						LocalDate dateFinEncheres, int miseAPrix) {
		this.nom_article = nomArticle;
		this.description = description;
		this.categorie.noCategorie = no_categorie;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		
	
	}

	public ArticleVendu(String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres, int miseAPrix) {
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.miseAPrix = miseAPrix;
	}

	public ArticleVendu(int no_article, String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres, int prix_initial, int prix_vente, Utilisateur utilisateur, Categorie categorie) {
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.miseAPrix = prix_initial;
		this.prixVente = prix_vente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}


	public int getUtilisateurVente() {
		return utilisateur.getNo_utilisateur();
	}


// getters et setters

	public List<Enchere> getConcerne() {
		return concerne;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public List<Utilisateur> getListeUtilisateur() {
		return listeUtilisateur;
	}

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

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
	public LocalDate getDateDebutEncheres() {
		return date_debut_encheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.date_debut_encheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return date_fin_encheres;
	}
	public void setDateFinEncheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
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


	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
		
	}

	

	
}
