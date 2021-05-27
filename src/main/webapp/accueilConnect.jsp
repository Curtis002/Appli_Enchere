<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="style/accueilConnect.css">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Accueil online</title>
</head>
<body>
<jsp:include page="headerConnecte.jsp"/>

<h2 class="text-center">Liste des enchères</h2>
<div class="container">
    <div>
        <div>
            <form action="ListeEncheresServlet" method="get">
                <label for="site-search">Filtres :</label>
                <input type="text" id="site-search" name="kw">
                <input type="submit" value="Filtrer" name="action" class="mr-3">

                <label for="categorie-select">Categorie :</label>
                <select name="categorie" id="categorie-select">
                    <option value="0">Tout</option>
                    <option value="1">Informatique</option>
                    <option value="2">Ameublement</option>
                    <option value="3">Vêtement</option>
                    <option value="4">Sports&Loisirs</option>
                </select>
                <input type="submit" value="Rechercher" name="action" class="mr-5">
                <input type="submit" value="Réinitialiser" name="initialiser">
            </form>
        </div>


        <div class="form-check-inline my-3">
            <ul class="form-check ">
                <input class="form-check-input" type="radio" name="radio" id="radio-achats" value="achats">
                <label class="form-check-label" for="radio-achats">Achats</label>

                <li class="form-check">
                    <input class="form-check-input" type="checkbox" value="encheres-ouvertes" id="radio-encheres-ouvertes" name="enchere">
                    <label class="form-check-label" for="radio-encheres-ouvertes">enchères ouvertes</label>
                </li>
                <li class="form-check ">
                    <input class="form-check-input" type="checkbox" value="encheres-en-cours" id="radio-encheres-en-cours" name="enchere">
                    <label class="form-check-label" for="radio-encheres-en-cours">mes enchères en cours</label>
                </li>
                <li class="form-check ">
                    <input class="form-check-input" type="checkbox" value="encheres-remportees" id="radio-encheres-remportees" name="enchere">
                    <label class="form-check-label" for="radio-encheres-remportees">mes enchères remportées</label>
                </li>
            </ul>
            <ul class="form-check ">
                <input class="form-check-input" type="radio" name="radio" id="radio-ventes" value="ventes">
                <label class="form-check-label" for="radio-ventes">Mes ventes</label>

                <li class="form-check">
                    <input class="form-check-input" type="checkbox" value="ventes-en-cours" id="radio-ventes-en-cours" name="vente">
                    <label class="form-check-label" for="radio-ventes-en-cours">mes ventes en cours</label>
                </li>
                <li class="form-check">
                    <input class="form-check-input" type="checkbox" value="ventes-non-debutees" id="radio-ventes-debutees" name="vente">
                    <label class="form-check-label" for="radio-ventes-debutees">ventes non débutées</label>
                </li>
                <li class="form-check">
                    <input class="form-check-input" type="checkbox" value="ventes-terminees" id="radio-ventes-terminees" name="vente">
                    <label class="form-check-label" for="radio-ventes-terminees">ventes terminées</label>
                </li>
            </ul>
            <div>
                <button class="form-check btn-lg mb-2 py-3 ml-5">Rechercher</button>
            </div>
        </div>
    </div>
</div>

<div class="row d-flex justify-content-around">
    <c:forEach var="vente" items="${requestScope.listArticles}">
        <div class="card col-5 border-secondary mb-3 ">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/AfficherEnchereServlet?nom_article=${vente.nomArticle}" title="nom_article">${vente.nomArticle}</a> </h5>
                <p class="card-text">Prix : ${vente.miseAPrix} points</p>
                <p class="card-text">Fin de l'enchère : ${vente.dateFinEncheres}</p>
                <p class="card-text">Vendeur : <a
                        href="${pageContext.request.contextPath}/UserServlet?pseudo=${vente.utilisateur.pseudo}"
                        title="pseudo">${vente.utilisateur.pseudo}</a></p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>