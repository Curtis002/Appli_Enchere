package fr.eni.appli_enchere.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Enchere implements Comparable<Enchere>{
	private Date date;
	private int montantEnchere;
	private int no_enchere;
	
	private int noArticle;
	private int no_utilisateur;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	private List<Utilisateur> listUtilisateur = new ArrayList<>();
	private List<ArticleVendu> listArticle = new ArrayList<>();
	
	//Constructor
	public Enchere(Date date,int montantEnchere) {
		super();
		this.date = date;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(int no_enchere,Date date, int montantEnchere,int articleVendu,  int utilisateur) {
		this.no_enchere = no_enchere;
		this.date = date;
		this.montantEnchere = montantEnchere;
		this.noArticle = articleVendu;
		this.no_utilisateur = utilisateur;
	}

	public int getNo_enchere() {
		return no_enchere;
	}

	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public List<ArticleVendu> getListArticle() {
		return listArticle;
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
		return " " + montantEnchere + " ";
	}

	/**
	 * Compares this object with the specified object for order.  Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 *
	 * <p>The implementor must ensure
	 * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
	 * for all {@code x} and {@code y}.  (This
	 * implies that {@code x.compareTo(y)} must throw an exception iff
	 * {@code y.compareTo(x)} throws an exception.)
	 *
	 * <p>The implementor must also ensure that the relation is transitive:
	 * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
	 * {@code x.compareTo(z) > 0}.
	 *
	 * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
	 * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
	 * all {@code z}.
	 *
	 * <p>It is strongly recommended, but <i>not</i> strictly required that
	 * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
	 * class that implements the {@code Comparable} interface and violates
	 * this condition should clearly indicate this fact.  The recommended
	 * language is "Note: this class has a natural ordering that is
	 * inconsistent with equals."
	 *
	 * <p>In the foregoing description, the notation
	 * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
	 * <i>signum</i> function, which is defined to return one of {@code -1},
	 * {@code 0}, or {@code 1} according to whether the value of
	 * <i>expression</i> is negative, zero, or positive, respectively.
	 *
	 * @param o the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 * @throws NullPointerException if the specified object is null
	 * @throws ClassCastException   if the specified object's type prevents it
	 *                              from being compared to this object.
	 */
	@Override
	public int compareTo(Enchere o) {
		if (this.getMontantEnchere() > o.getMontantEnchere()) {
			return 1;
		} else if (this.getMontantEnchere() < o.getMontantEnchere()) {
			return -1;
		}
		return 0;
	}
}
