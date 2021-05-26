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
            /* Cette fonction permet d'afficher une vignette pour chaque image s�lectionn�e */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img class="col-12" height="300" width="300" src="' + event.target.result + '" />';
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
	
	<div class="col-4" id="list"></div>

	<form class="col-8 " method="post"  enctype="multipart/form-data" action="<%=request.getContextPath() %>/VenteArticleServlet" >
		
		<div  class="form-group row">
			<label  class="col-2" for="nomArticle">Article : </label> 
			<div class="col">
				<input class="col-10 form-control"type="text" id="nomArticle" name="nomArticle" required/>
			</div>
		</div>
		
	<div  class="form-group row">
		<label class="col-2" for="description">Description : </label> 
		<div class="col">
			<textarea class="form-control col-10" type="text" id="description" name="description"required></textarea>
		</div>
	</div>
	<div  class="form-group row">
	<label class="col-4" for="categorie">Cat�gorie : </label> 
		<select class="col-6"  name="categorie" id="categorie">
			<option name="0" value="">Choisissez une categorie</option>
			<option name="1" value="1">Informatique</option>
			<option name="2" value="2">Ameublement</option>
			<option name="3" value="3">V�tement</option>
			<option name="4" value="4">Sports & Loisirs</option>
		</select>
	</div>
	
	<div  class="form-group row">
		<!-- <label class="col-4" for="photoArticle" >Photo de l'article : </label> 
		<input class="col-6 form-control-file"  type="file"  id="photoArticle" type="file" name="multiPartServlet" accept="img/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
        <input type="submit" value="Upload" /> <br/>  -->
	
		<div method="post" action="UploadImageServlet" enctype="multipart/form-data">
			Photo de l'article :            
			<input type="file" name="photo" size="150"
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
            <input type="submit" value="Upload" /> <br/>  
        
            
        </div>
	
	</div>
	
	
	
	
	<div  class="form-group row">
		<label class="col-4" for="miseAPrix">Mise � prix : </label> 
		<input class="col-6" id="miseAPrix" type="number" name="miseAPrix" required>
	</div>
	<div  class="form-group row">
		<label class="col-4" for="dateDebutEncheres">D�but de l'ench�res : </label> 
		<input class="col-6" id="dateDebutEncheres" type="date" name="dateDebutEncheres" required>
	</div>
	<div  class="form-group row">
		<label class="col-4" for="dateFinEncheres">Fin de l'ench�res : </label> 
		<input class="col-6" id="dateFinEncheres" type="date" name="dateFinEncheres" required>
	</div>
	<div>
		<h3>Lieu de Retrait</h3>
		<div  class="form-group row">
			<label class="col-4" for="rue">Rue : </label> 
			<input class="col-6 form-control"
								type="text" id=rue name="rue"
								value="${sessionScope.rue}" required/>
		</div>
	<div  class="form-group row">
	<label class="col-4" for="codepostal">Code postal : </label> 
	<input class="col-6 form-control"
						type="text" id=codepostal name="codepostal"
						value="${sessionScope.code_postal}" required/>
	</div>
	<div  class="form-group row">
	<label class="col-4" for="ville">Ville : </label> 
	<input class="col-6 form-control"
						type="text" id=ville name="ville"
						value="${sessionScope.ville}" required/>
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