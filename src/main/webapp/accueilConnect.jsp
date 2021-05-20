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
<body class="container">
<h1>Accueil connecté</h1>
	<nav class="navbar">
	<div>
	  <span>ENI-ENCHERES</span>
	</div>
	<div class=""> 
	<ul class="nav justify-content-end">
		<li class="nav-item" id="links"><a class="nav-link" href="Enchères.jsp">Enchères</a></li>
		<li class="nav-item" id="links"><a class="nav-link" href="article.jsp">Vendre un article</a></li>
		<li class="nav-item" id="links"><a class="nav-link" href="profile.jsp">Mon profil</a></li>
		<li class="nav-item " id="links"><a class="nav-link" href="<%=request.getContextPath() %>/LogoutServlet">Déconnexion</a></li>
	</ul>
	</div>
	</nav>
<h2 class="text-center">Liste des enchères</h2>
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
		
		
	<div class="form-check-inline my-3">
		<ul class="form-check ">
	        <input class="form-check-input" type="radio" onClick="kput.disabled = true;" name="radio" id="radio1" value="o1">
	        <label class="form-check-label" for="radio1">Achats</label>
	     
	     <li class="form-check">
	        <input class="form-check-input" type="checkbox" value="c1" id="kput">
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
	  <ul class="form-check ">
		     <input class="form-check-input" type="radio" name="radio" id="radio2" value="o2">
		     <label class="form-check-label" for="radio2">Mes ventes</label> 
		  
	    <li class="form-check">
	        <input class="form-check-input" type="checkbox" value="c1" id="kput">
	        <label class="form-check-label" id="kput" for="ck1">mes ventes en cours</label>
	    </li>
      	<li class="form-check">
	        <input class="form-check-input" type="checkbox" value="c2" id="kput">
	        <label class="form-check-label" id="kput" for="ck2">ventes non débutées</label>
       	</li>
       	<li class="form-check">
	        <input class="form-check-input" type="checkbox" value="c2" id="kput">
	        <label class="form-check-label" id="kput" for="ck2">ventes terminées</label>
      	</li>
     </ul>
     <div>
		<button class="form-check btn-lg mb-2 py-3 ml-5">Rechercher</button>
	</div>
    </div>
    
    
	
   </div>
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