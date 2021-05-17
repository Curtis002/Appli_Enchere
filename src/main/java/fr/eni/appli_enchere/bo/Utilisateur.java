package fr.eni.appli_enchere.bo;

public class Utilisateur {
	// Déclaration des attributs
    private int no_utilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String rue;
    private String code_postal;
    private String ville;
    private String mot_de_passe;
    private int credit;
    private boolean administrateur;

    // Constructeurs
    public Utilisateur() {
    }

    public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
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

    public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
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

    public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
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

    // Définition des Getters et Setters
    public int getNo_utilisateur() {
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

    public int getCredit() {
        return credit;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    // Setters
    public void setNo_utilisateur(int no_utilisateur) {
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

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    // Méthodes
    @Override
    public String toString() {
        return "Utilisateur ["
                + "pseudo= " + this.pseudo
                + "nom= " + this.nom
                + "prenom= " + this.prenom
                + "email= " + this.email
                + "rue= " + this.rue
                + "code postal= " + this.code_postal
                + "ville= " + this.ville
                + "mot de passe= " + this.mot_de_passe
                + "credit= " + this.credit
                + "admin= " + this.administrateur
                ;
    }
}
