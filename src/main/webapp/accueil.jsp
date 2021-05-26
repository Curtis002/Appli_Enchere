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
            <a href="accueil.jsp" class="nav-link" style="color: black"><h1 class="spec-h1">ENI-ENCHERES</h1></a>
        </div>
	<ul class="nav justify-content-end">
		<li class="nav-item" id="links"><a class="nav-link" href="ConnectServlet">Se connecter - S'inscrire</a></li>
	</ul>
	</nav>
<h2 class="text-center">Liste des enchères</h2>
<div class="container row m-3">
	<div class="col" >
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
		<button class="form-check btn-lg mb-2 py-3 ml-5">Rechercher</button>
	</div>
	
</div>

<div class="row">
<%--	<c:when test="${requestScope.listeEncheres.size()>0}">--%>
		<ul class="list-group col-12">
			<c:forEach var="c" items="${requestScope.listeEncheres}">
				<li class="list-group-item d-flex justify-content-between align-items-center">${c.nomArticle}</li>
			</c:forEach>
		</ul>
<%--	</c:when>--%>
<%--	<c:otherwise>--%>
<%--	<p>Pas d'enchère actuellement.<p>--%>
<%--	</c:otherwise>--%>
</div>

<div class="border-primary row align-items-start custom-line  mx-1 my-4 ">
	<div class="col row mx-2 py-2 ml-1 border mt-2 rounded border-secondary">
		<img class="rounded p-2 mx-1" src="img/meilleur-pc-gamer.jpg" alt="image" height="150px" width="150px">
		<div class="col flex-col ">
			<h4><a href ="ficheproduit.jsp">PC Gamer pour travailler</a></h4>
			<span class="row mx-1">Prix : 210 points</span>
			
			<span class="row mx-1 my-1">Fin de l'enchère : 10/08/2018</span>
			
			<span class="row mx-1 ">Vendeur : <a href ="fichevendeur.jsp"> jojo44</a></span>
		</div>
	</div>
	
	<div class="col row mx-2 py-2 ml-1 border mt-2 rounded border-secondary">
		<img class="rounded p-2 mx-1" src="img/Rocket_stove.jpg" alt="image" height="150px" width="150px">
		<div class="col flex-col">
			<h4 class=""><a href ="ficheproduit.jsp">Rocket stove pour riz</a></h4>
			<span class="row mx-1" >Prix : <a> 210 points</a></span>
			
			<span class="row mx-1 my-1" >Fin de l'enchère : <a> 10/08/2018</a></span>
			
			<span class="row mx-1">Vendeur : <a href ="fichevendeur.jsp"> Jiji56</a></span>
			
		
		</div>
	</div>
  </div>  
</body>
</html>