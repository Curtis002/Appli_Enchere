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
	<nav class="nav">
	<span class="nav nav-item">ENI-ENCHERES</span>  
	</nav>
	<nav class="container">
	<ul class="nav justify-content-end">
		<li class="nav-item" id="links"><a class="nav-link" href="Enchères.jsp">Enchères</a></li>
		<li class="nav-item" id="links"><a class="nav-link" href="article.jsp">Vendre un article</a></li>
		<li class="nav-item" id="links"><a class="nav-link" href="profil.jsp">Mon profil</a></li>
		<li class="nav-item" id="links"><a class="nav-link" href="/Appli_Enchere/LogoutServlet">Déconnexion</a></li>
	</ul>
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
		
	<div class="form-check-inline">
		<ul class="form-check ">
	        <input class="form-check-input" type="radio" name="radio" id="radio1" value="o1">
	        <label class="form-check-label" for="radio1">Achats</label>
	     
	     <li class="form-check">
	        <input class="form-check-input" type="checkbox" value="c1" id="ck1">
	        <label class="form-check-label" for="ck1">enchères ouvertes</label>
      	</li>
      	<li class="form-check ">
	        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
	        <label class="form-check-label" for="ck2">mes enchères en cours</label>
     	 </li>
      	<li class="form-check ">
	        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
	        <label class="form-check-label" for="ck2">mes enchères remportées</label>
      	</li> 
      	
      </ul>
      <div class="form-check-inline">
	      <ul class="form-check ">
		     <input class="form-check-input" type="radio" name="radio" id="radio2" value="o2">
		     <label class="form-check-label" for="radio2">Mes ventes</label> 
		  
	      <li class="form-check">
	        <input class="form-check-input" type="checkbox" value="c1" id="ck1">
	        <label class="form-check-label" for="ck1">mes ventes en cours</label>
	      </li>
      	<li class="form-check">
        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
        <label class="form-check-label" for="ck2">ventes non débutées</label>
       </li>
       <li class="form-check">
        <input class="form-check-input" type="checkbox" value="c2" id="ck2">
        <label class="form-check-label" for="ck2">ventes terminées</label>
      </li>
     </ul>
    </div>
    	<div>
			<button class="btn-lg mb-2">Rechercher</button>
		</div>
   </div>
<div class="row align-items-start custom-line">
	<div class="col">
		<img src="img/meilleur-pc-gamer.jpg" alt="image" height="100" width="100">
		<div>
			<h4>PC Gamer pour travailler<a href ="ficheproduit.jsp"></a></h4>
			<span>Prix : 210 points</span>
			
			<span>Fin de l'enchère : 10/08/2018</span>
			
			<span>Vendeur :</span><a href ="fichevendeur.jsp">jojo44</a>
		</div>
	</div>
	
	<div class="col">
		<img src="img/Rocket_stove.jpg" alt="image" height="100" width="100">
		<div>
			<h4>Rocket stove pour riz<a href ="ficheproduit.jsp"></a></h4>
			<span>Prix : 210 points</span>
			
			<span>Fin de l'enchère : 10/08/2018</span>
			
			<span>Vendeur :</span><a href ="fichevendeur.jsp">Jiji56</a>
			
		
		</div>
	</div>
  </div>  

</body>
</html>