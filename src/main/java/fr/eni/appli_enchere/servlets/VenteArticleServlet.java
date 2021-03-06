package fr.eni.appli_enchere.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.appli_enchere.bll.RetraitManager;

import fr.eni.appli_enchere.bll.VenteManager;
import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Retrait;

import fr.eni.appli_enchere.dal.DALException;


@WebServlet("/VenteArticleServlet")
public class VenteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SERVLET VENTE ARTICLE passe dans DO GET");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			System.out.println("SERVLET VENTE ARTICLE passe dans DO POST");

			System.out.println("----------------------------------");

			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			int no_categorie = Integer.parseInt(request.getParameter("categorie"));
			String dateDebut = request.getParameter("dateDebutEncheres");
			LocalDate dateDebutEncheres = LocalDate.parse(dateDebut);
			String dateFin = request.getParameter("dateFinEncheres");
			LocalDate dateFinEncheres = LocalDate.parse(dateFin);
			int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));

			String rue = request.getParameter("rue");
			String codepostal = request.getParameter("codepostal");
			String ville = request.getParameter("ville");
			// String prixdevente = request.getParameter("prixdevente");
			// String imgLink = request.getParameter("imgLink");
			int utilisateurConnecte = (int) request.getSession().getAttribute("noUser");
			System.out.println("utilisateurConnecte est : " + utilisateurConnecte);

			RequestDispatcher rd = request.getRequestDispatcher("/nouvelleVente.jsp");

			if (nomArticle.trim().length() != 0) {
				System.out.println("nomArticle : je ne suis pas vide");
				session.setAttribute("nomArticle", nomArticle);
			} else {
				System.out.println("c'est vide alors message");
				request.setAttribute("errornArticle", "Veuillez renseigner un nom d'article");
				//rd.forward(request, response);
			}
			System.out.println("----------------------------------");

			if (description.trim().length() != 0) {
				System.out.println("description : je ne suis pas vide");
				session.setAttribute("description", description);
			} else {
				System.out.println("c'est vide alors message");
				request.setAttribute("errorDescription", "Veuillez renseigner une description");
				//rd.forward(request, response);
			}
			System.out.println("----------------------------------");

			if (miseAPrix != 0) {
				System.out.println("miseAPrix : je ne suis pas 0");
				session.setAttribute("miseAPrix", miseAPrix);
			} else {
				System.out.println("c'est vide alors message");
				request.setAttribute("errorMiseAPrix", "Veuillez renseigner une mise ?? prix");
				//rd.forward(request, response);
			}
			
			System.out.println("-----------check date debut---------------");
			
			LocalDate ojd = LocalDate.now();
			
			int checkJourDebut = dateDebutEncheres.compareTo(ojd);
			System.out.println("checkJourDebut est de : --"+ checkJourDebut);
			
			if (checkJourDebut >= 0 ) {
				System.out.println("Date1 est bien aujourdhui ou apres  === OK");
			}else {
				System.out.println("LA DATE EST AVANT AUJOURDHUI");
				request.setAttribute("errordateDebutEncheres",
						"Veuillez renseigner une date de d??but d'encheres valide");
				//rd.forward(request, response);
			}
			
			System.out.println("-----------check date debut / fin-------------");

			int result = dateDebutEncheres.compareTo(dateFinEncheres);
			System.out.println("result: " + result);

			if (result < 0 && (result != 0)) {
				System.out.println("Date1 is before Date2  === OK");
			} else if (result > 0) {
				System.out.println("Date1 is after Date2");
				request.setAttribute("errordateDebutEncheres",
						"Veuillez renseigner une date de d??but d'encheres valide");
				request.setAttribute("errordateFinEncheres", "Veuillez renseigner une date de fin d'encheres valide");
			} else if (result == 0) {
				System.out.println("Date1 is equal to Date2");
				request.setAttribute("errordateDebutEncheres",
						"Veuillez renseigner une date de d??but d'encheres valide");
				request.setAttribute("errordateFinEncheres", "Veuillez renseigner une date de fin d'encheres valide");
			} else {
				System.out.println("How to get here?");
			}
			System.out.println("----------------------------------");

			if (rue.trim().length() != 0) {
				System.out.println("rue : je suis PAS VIDE");
				session.setAttribute("rue", rue);
			} else {
				System.out.println("c'est vide alors message");
				request.setAttribute("errorRue", "Veuillez renseigner un nom de rue valide");
				//rd.forward(request, response);
			}
			System.out.println("----------------------------------");

			if (codepostal.length() == 5) {
				System.out.println("codepostal : je suis BIEN 5");
				session.setAttribute("codepostal", codepostal);
			} else {
				System.out.println("c'est pas 5 alors message");
				request.setAttribute("errorcp", "Veuillez renseigner un code postal valide");
				//rd.forward(request, response);
			}
			System.out.println("----------------------------------");

			if (ville.trim().length() != 0) {
				System.out.println("ville : je ne suis vide");
				session.setAttribute("ville", ville);
			} else {
				System.out.println("c'est vide alors message");
				request.setAttribute("errorVille", "Veuillez renseigner un nom de ville");
				//rd.forward(request, response);
			}
			System.out.println("--------   FIN   ----------------");

			System.out.println("--------  PASSAGE DE DONNES  ----------------");

			if (nomArticle.trim().length() != 0) {
				if (description.trim().length() != 0) {
					if (miseAPrix != 0) {
						if (checkJourDebut >= 0 ) {
							if (result < 0 && (result != 0)) {
								if (rue.trim().length() != 0) {
									if (codepostal.length() == 5) {
										if (ville.trim().length() != 0) {
										System.out.println("JE RENTRE BIEN PR RENTRER LES DONNEES");
										// System.out.println(nomArticle.trim()); //nomArticle = nomArticle.trim();
										// System.out.println(nomArticle);

										VenteManager venteManager = new VenteManager();
										ArticleVendu articleVendu;
										System.out.println(nomArticle + " - " + description + " - " + dateDebutEncheres
												+ " - " + dateFinEncheres + " - " + miseAPrix + " - "
												+ utilisateurConnecte + " -  " + no_categorie);
										articleVendu = venteManager.addVente(nomArticle, description, dateDebutEncheres,
												dateFinEncheres, miseAPrix, utilisateurConnecte, no_categorie);
										request.setAttribute("nouvelleVente", articleVendu);

										Integer no_article = (Integer) (articleVendu.getNoArticle());
										System.out.println("no_article  dans servlet  :" + no_article);

										RetraitManager retraitManager = new RetraitManager();
										Retrait retrait;
										retrait = retraitManager.addAdresse(rue, codepostal, ville, no_article);
										System.out.println(" voir l adresse de retrait :  " + retrait);
										request.setAttribute("ajoutadresse", retrait);

										request.getRequestDispatcher("/nouvelleVente.jsp").forward(request, response);
									} else {
										System.out.println("VILLE - c'est vide alors message");
										System.out.println("ce n'est pas pass?? en BDD");
										request.setAttribute("errorVille", "Veuillez renseigner un nom de ville");
										rd.forward(request, response);
									}

								} else {
									System.out.println("CODE POSTAL - c'est pas 5 alors message");
									request.setAttribute("errorcp", "Veuillez renseigner un code postal valide");
									rd.forward(request, response);
								}

							} else {
								System.out.println("RUE - c'est vide alors message");
								request.setAttribute("errorRue", "Veuillez renseigner un nom de rue valide");
								rd.forward(request, response);
							}

						} else if (result > 0) {
							System.out.println("Date1 is after Date2");
							request.setAttribute("errordateDebutEncheres",
									"Veuillez renseigner une date de d??but d'encheres valide");
							request.setAttribute("errordateFinEncheres",
									"Veuillez renseigner une date de fin d'encheres valide");
							rd.forward(request, response);
							
						
						} else if (result == 0) {
							System.out.println("Date1 is equal to Date2");
							request.setAttribute("errordateDebutEncheres",
									"Veuillez renseigner une date de d??but d'encheres valide");
							request.setAttribute("errordateFinEncheres",
									"Veuillez renseigner une date de fin d'encheres valide");
							rd.forward(request, response);
						} else {
							System.out.println("cas bizarre DATE");
							System.out.println("How to get here?");
						}
						}else {
							System.out.println("LA DATE EST AVANT AUJOURDHUI");
							request.setAttribute("errordateDebutEncheres",
									"Veuillez renseigner une date de d??but d'encheres valide");
							rd.forward(request, response);
						}

					} else {
						System.out.println("MiseAPrix - c'est vide alors message");
						request.setAttribute("errorMiseAPrix", "Veuillez renseigner une mise ?? prix");
						rd.forward(request, response);
					}
				} else {
					System.out.println("description - c'est vide alors message");
					request.setAttribute("errorDescription", "Veuillez renseigner une description");
					rd.forward(request, response);
				}

			} else {
				System.out.println("nom d'article - c'est vide alors message");
				request.setAttribute("errornArticle", "Veuillez renseigner un nom d'article");
				rd.forward(request, response);
			}


		} catch (DALException e) {

			e.printStackTrace();
			System.out.println("probleme dans la servlet vente article");
		}

	}

}
