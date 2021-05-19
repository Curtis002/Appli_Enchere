<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Accueil online</title>
</head>
<body>
<h1>Accueil connecté</h1>
<nav>
	<span>ENI ENCHERES</span>  
	<a href=""></a>
	<span id="links">
		<a href="Enchères.jsp">Enchères</a>
	</span>
	<span id="links">
		<a href="article.jsp">Vendre un article</a>
	</span>
	<span id="links">
		<a href="profil.jsp">Mon profil</a>
	</span>
	<span id="links">
		<a href="/appli_enchere/LogoutServlet">Déconnexion</a>
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
	<div class="form-row">
		<div class="form-check form-check-inline">
	        <input class="form-check-input" type="radio" name="radio" id="radio1" value="o1">
	        <label class="form-check-label" for="radio1">Achats</label>
	     </div>
	     <div class="form-check">
	        <input class="form-check-input" type="checkbox" value="c1" id="ck1">
	        <label class="form-check-label" for="ck1">enchères ouvertes</label>
      	</div>
      	<div class="form-check">
	        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
	        <label class="form-check-label" for="ck2">mes enchères en cours</label>
     	 </div>
      	<div class="form-check">
	        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
	        <label class="form-check-label" for="ck2">mes enchères remportées</label>
      	</div> 
      </div>
      <div class="form-row">
	      <div class="form-check form-check-inline">
		     <input class="form-check-input" type="radio" name="radio" id="radio2" value="o2">
		     <label class="form-check-label" for="radio2">Mes ventes</label> 
		  </div>
	      <div class="form-check">
	        <input class="form-check-input" type="checkbox" value="c1" id="ck1">
	        <label class="form-check-label" for="ck1">mes ventes en cours</label>
	      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
        <label class="form-check-label" for="ck2">ventes non débutées</label>
       </div>
       <div class="form-check">
        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
        <label class="form-check-label" for="ck2">ventes terminées</label>
      </div>
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