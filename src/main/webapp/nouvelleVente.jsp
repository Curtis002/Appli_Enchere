<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Nouvelle vente</title>
<script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="60" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
</head>
<body class="container">
	 <div class="row">
	 		<p class="col-2 ">ENI-ENCHERES</p>
	 		<p class="col-10 text-center">Nouvelle vente</p>
	</div>
	<div class="row">
	
	<img class="col-3" src="img/meilleur-pc-gamer.jpg" alt="">
	
	
	<form class="col-9 " method="post" action="<%=request.getContextPath() %>/VenteArticleServlet" enctype="multipart/form-data">
		
		<div  class="form-group row">
			<label  class="col-2" for="nomArticle">Article : </label> 
			<div class="col">
				<input class="col-10 form-control"type="text" id="nom_article" name="nom_article"value="${getNom_article}" />
			</div>
		</div>
		
	<div  class="form-group row">
		<label class="col-2" for="description">Description : </label> 
		<div class="col">
			<textarea class="form-control col-10" type="text" id="description" name="description"value="${getArticle.description}"></textarea>
		</div>
	</div>
	<div  class="form-group row">
	<label class="col-4" for="categorie">Catégorie : </label> 
		<select class="col-6"  name="categorie" id="categorie-select">
			<option name="categorie" value="">Choisissez une categorie</option>
			<option name="categorie" value="1">Informatique</option>
			<option name="categorie" value="2">Ameublement</option>
			<option name="categorie" value="3">Vêtement</option>
			<option name="categorie" value="4">Sports & Loisirs</option>
		</select>
	</div>
	<div  class="form-group row">
		<label class="col-4" for="categorie">Photo de l'article : </label> 
		<input class="col-6 form-control-file"  type="file"  id="fichier" type="file" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
        <input type="submit" value="Upload" /> <br/> 
	</div>
	
	
	
	
	<div  class="form-group row">
		<label class="col-4" for="categorie">Mise à prix : </label> 
		<input class="col-6" type="number" name="howmuch">
	</div>
	<div  class="form-group row">
		<label class="col-4" for="categorie">Début de l'enchères : </label> 
		<input class="col-6" type="date" name="anniversaire">
	</div>
	<div  class="form-group row">
		<label class="col-4" for="categorie">Fin de l'enchères : </label> 
		<input class="col-6" type="date" name="anniversaire">
	</div>
	<div>
		<h3>Lieu de Retrait</h3>
		<div  class="form-group row">
			<label class="col-4" for="rue">Rue : </label> 
			<input class="col-6 form-control"
								type="text" id=rue name="rue"
								value="${getUtilisateur.rue}" />
		</div>
	<div  class="form-group row">
	<label class="col-4" for="codepostal">Code postal : </label> 
	<input class="col-6 form-control"
						type="text" id=codepostal name="codepostal"
						value="${getUtilisateur.codepostal}" />
	</div>
	<div  class="form-group row">
	<label class="col-4" for="ville">Ville : </label> 
	<input class="col-6 form-control"
						type="text" id=ville name="ville"
						value="${getUtilisateur.ville}" />
	</div>
	
	
	
	</div>
	<div  class="form-row ">
			<div class="inputSubmit col text-center ">
				<input class="btn-secondary my-2 py-2 " type="submit"
								value="Enregistrer" />

				<button class="btn-secondary my-2 py-2 " type="button">
								Annuler</button>
			</div>
	</div>
	</form>
	</div>
	
</body>
</html>