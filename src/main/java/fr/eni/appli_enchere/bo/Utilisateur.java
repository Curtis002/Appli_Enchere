package fr.eni.appli_enchere.bo;

import java.util.List;

public class Utilisateur {
	// D�claration des attributs
    private Integer no_utilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String rue;
    private String code_postal;
    private String ville;
    private String mot_de_passe;
    private Integer credit;
    private boolean administrateur;

    private List<ArticleVendu> acheteArticles;
    private List<ArticleVendu> venteArticles;
    private List<Enchere> utilisateurEncherit;

    // Constructeurs
    public Utilisateur() {
    }

    public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, Integer credit, boolean administrateur) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.mot_de_passe = mot_de_passe;
        this.credit = credit;
        this.administrateur = administrateur;
    }

    public Utilisateur(Integer no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, Integer credit, boolean administrateur) {
        this.no_utilisateur = no_utilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.mot_de_passe = mot_de_passe;
        this.credit = credit;
        this.administrateur = administrateur;
    }

    public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, String code_postal, String ville, String mot_de_passe, Integer credit, boolean administrateur) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.mot_de_passe = mot_de_passe;
        this.credit = credit;
        this.administrateur = administrateur;
    }

    public Utilisateur(String pseudo, String mot_de_passe) {
        this.pseudo = pseudo;
        this.mot_de_passe = mot_de_passe;
    }

    public Utilisateur(String pseudo) {
        this.pseudo = pseudo;
    }

    // D�finition des Getters et Setters
    public Integer getNo_utilisateur() {
        return no_utilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRue() {
        return rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public String getVille() {
        return ville;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public Integer getCredit() {
        return credit;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public List<ArticleVendu> getAcheteArticles() {
        return acheteArticles;
    }

    public List<ArticleVendu> getVenteArticles() {
        return venteArticles;
    }

    public List<Enchere> getUtilisateurEncherit() {
        return utilisateurEncherit;
    }

    // Setters
    public void setNo_utilisateur(Integer no_utilisateur) {
        this.no_utilisateur = no_utilisateur;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    // M�thodes
    @Override
    public String toString() {
        return "Utilisateur ["
                + "pseudo= " + this.pseudo
                + ", nom= " + this.nom
                + ", prenom= " + this.prenom
                + ", email= " + this.email
                + ", rue= " + this.rue
                + ", code postal= " + this.code_postal
                + ", ville= " + this.ville
                + ", mot de passe= " + this.mot_de_passe
                + ", credit= " + this.credit
                + ", admin= " + this.administrateur
                ;
    }
}
