<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>
<nav>
	<span>ENI ENCHERES</span>  
	
	
	
	<span id="links">
		<a href="/login.jsp">Se connecter - S'inscrire</a>
	</span>
</nav>
<h2>Liste des enchères</h2>
<div>
	<div>
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
	<div>
		<button>Rechercher</button>
	</div>
	
</div>
<div>
	<div>
	<img src="img/meilleur-pc-gamer.jpg">
		<h4>PC Gamer pour travailler<a href ="ficheproduit.jsp"></a></h4>
		<span>Prix : 210 points</span>
		
		<span>Fin de l'enchère : 10/08/2018</span>
		
		<span>Vendeur :</span><a href ="fichevendeur.jsp"></a>
	</div>
	
	<div>
	<img src="img/Rocket_stove.jpg">
		<h4>PC Gamer pour travailler<a href ="ficheproduit.jsp"></a></h4>
		<span>Prix : 210 points</span>
		
		<span>Fin de l'enchère : 10/08/2018</span>
		
		<span>Vendeur :</span><a href ="fichevendeur.jsp"></a>
	</div>
</div>
</body>
</html>