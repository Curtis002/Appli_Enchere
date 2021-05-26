<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Accueil</title>
</head>
<body class="container">
<nav class="navbar">
    <div>
        <a href="<%=request.getContextPath()%>" class="nav-link" style="color: black"><h1 class="spec-h1">ENI-ENCHERES</h1></a>
    </div>
    <ul class="nav justify-content-end">
        <li class="nav-item" id="links"><a class="nav-link" href="ConnectServlet">Se connecter - S'inscrire</a></li>
    </ul>
</nav>
<h2 class="text-center">Liste des enchères</h2>
<div class="container row m-3">
    <div class="col">
        <div>
            <label for="site-search">Filtres :</label>
            <input type="search" id="site-search" name="q"
                   aria-label="Search through site content">
        </div>
        <div>
            <label for="categorie-select">Categorie :</label>
            <select name="categorie" id="categorie-select">
                <option value="">Choisissez une categorie</option>
                <option value="Informatique">Informatique</option>
                <option value="cat">Ameublement</option>
                <option value="hamster">Vêtement</option>
                <option value="parrot">Sports&Loisirs</option>
            </select>
        </div>
    </div>

    <div class="col">
        <button class="form-check btn-lg mb-5 py-3 ml-5">Rechercher</button>
    </div>

</div>

<div class="row d-flex justify-content-around">
    <c:forEach var="vente" items="${requestScope.listArticles}">
        <div class="card col-5 border-secondary mb-3 ">
            <div class="card-body">
                <h5 class="card-title">${vente.nomArticle}</h5>
                <p class="card-text">Prix : ${vente.miseAPrix} points</p>
                <p class="card-text">Fin de l'enchère : ${vente.dateFinEncheres}</p>
                <p class="card-text">Vendeur : ${vente.utilisateur.pseudo}</p>
                <div class="d-flex justify-content-center">
                    <a href="ConnectServlet" class="btn btn-outline-primary">Découvrir la vente</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>