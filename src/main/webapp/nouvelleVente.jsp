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
                        span.innerHTML = '<img class="col-12" height="300" width="300" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
</head>
<body>
	<jsp:include page="headerConnecte.jsp"/>
<div class="container">
	<div class="row">
	
	<div class="col-4" id="list"></div>

	<form class="col-8 " method="post"   action="<%=request.getContextPath() %>/VenteArticleServlet" >
		
		<div  class="form-group row">
			<label  class="col-2" for="nomArticle">Article : </label> 
			<div class="col">
				<input class="col-10 form-control"type="text" id="nomArticle" name="nomArticle" required/>
			 	<c:if test="${not empty requestScope.errornArticle}">
                <div class="text-danger">Veuillez renseigner un nom d'article</div>
                </c:if>
			</div>
		</div>
		
	<div  class="form-group row">
		<label class="col-2" for="description">Description : </label> 
		<div class="col">
			<textarea class="form-control col-10" type="text" id="description" name="description" required></textarea>
			<c:if test="${not empty requestScope.errorDescription}">
                <div class="text-danger">Veuillez renseigner une description</div>
                </c:if>
		</div>
	</div>
	<div  class="form-group row">
	<label class="col-4" for="categorie">Catégorie : </label> 
		<select class="col-6"  name="categorie" id="categorie" required>
			<option name="0" value="">Choisissez une categorie</option>
			<option name="1" value="1">Informatique</option>
			<option name="2" value="2">Ameublement</option>
			<option name="3" value="3">Vêtement</option>
			<option name="4" value="4">Sports & Loisirs</option>
		</select>
	</div>
	
	<div  class="form-group row">
		<!-- <label class="col-4" for="photoArticle" >Photo de l'article : </label> 
		<input class="col-6 form-control-file"  type="file"  id="photoArticle" type="file" name="multiPartServlet" accept="img/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
        <input type="submit" value="Upload" /> <br/>  -->
	
		
			<label class="col-4" for="photoArticle" >Photo de l'article : </label>          
			<input class="col-6 form-control-file" type="file" name="photo" size="150"
                   onchange="readFilesAndDisplayPreview(this.files);" required/> <br/>
            <input type="submit" value="Upload" /> <br/>  
        
            
   
	
	</div>
	
	
	
	
	<div  class="form-group row">
		<label class="col-4" for="miseAPrix">Mise à prix : </label> 
		<input class="col-6" id="miseAPrix" type="number" name="miseAPrix" required>
		<c:if test="${not empty requestScope.errorMiseAPrix}">
                <div class="text-danger">Veuillez renseigner une mise à prix</div>
        </c:if>
	</div>
	<div  class="form-group row">
		<label class="col-4" for="dateDebutEncheres">Début de l'enchères : </label> 
		<input class="col-6" id="dateDebutEncheres" type="date" name="dateDebutEncheres" required>
		<c:if test="${not empty requestScope.errordateDebutEncheres}">
                <div class="text-danger">Veuillez renseigner une date de début d'encheres valide</div>
        </c:if>
	</div>
	<div  class="form-group row">
		<label class="col-4" for="dateFinEncheres">Fin de l'enchères : </label> 
		<input class="col-6" id="dateFinEncheres" type="date" name="dateFinEncheres" required>
		<c:if test="${not empty requestScope.errordateFinEncheres}">
                <div class="text-danger">Veuillez renseigner une date de fin d'encheres valide</div>
        </c:if>
	</div>
	<div>
		<h3>Lieu de Retrait</h3>
		<div  class="form-group row">
			<label class="col-4" for="rue">Rue : </label> 
			<input class="col-6 form-control"
								type="text" id=rue name="rue"
								value="${sessionScope.rue}" required/>
		<c:if test="${not empty requestScope.errorRue}">
                <div class="text-danger">Veuillez renseigner un nom de rue valide</div>
        </c:if>
		</div>
	<div  class="form-group row">
		<label class="col-4" for="codepostal">Code postal : </label> 
		<input class="col-6 form-control"
							type="text" id=codepostal name="codepostal"
							value="${sessionScope.code_postal}" required/>
		<c:if test="${not empty requestScope.errorcp}">
	    	<div class="text-danger">Veuillez renseigner un code postal valide</div>
	    </c:if>
	</div>
	<div  class="form-group row">
		<label class="col-4" for="ville">Ville : </label> 
		<input class="col-6 form-control"
							type="text" id=ville name="ville"
							value="${sessionScope.ville}" required/>
		<c:if test="${not empty requestScope.errorVille}">
	    	<div class="text-danger">Veuillez renseigner un nom de ville</div>
	    </c:if>
	
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
</div>
</body>
</html>