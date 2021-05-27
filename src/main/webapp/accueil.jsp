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
    <div class="mb-3">
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