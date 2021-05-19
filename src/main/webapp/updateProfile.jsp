<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="style/register.css">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<h1>Modification de mon Profile</h1>
		
		<div class="container">
		 <form action="/Appli_Enchere/ServletUpdateProfile" method="post">
			<div class="form-row">
            	<div class="input col">
	                <label for="pseudo">Pseudo :</label>
	                <input class="form-control" type="text" id="pseudo" name="pseudo" value="${getPseudo}" required/>
	            	<c:if test="${not empty requestScope.errorPseudo}">
                    <div>Ce pseudo est invalide / ou nonexistant.</div>
                	</c:if>
	            </div>
	            <div class="input col">
	                <label for="nom">Nom :</label>
	                <input class="form-control" type="text" id="nom" name="nom" value="${getNom}" required/>
	            </div>
	        </div>
	        <div class="form-row">   
	            <div class="input col">
	                <label for="prenom">Prénom :</label>
	                <input class="form-control" type="text" id="prenom" name="prenom" value="${getPrenom}" required/>
	            </div>
	            <div class="input col">
	                <label for="mail">Email :</label>
	                <input class="form-control" type="text" id="mail" name="mail" value="${getEmail}" required/>
	                 <c:if test="${not empty requestScope.errorEmail}">
                     <div>Renseigner un email valide / ou existant.</div>
                </c:if>
	            </div>
	        </div>
	        <div class="form-row">      
	            <div class="input col">
	                <label for="telephone">Téléphone :</label>
	                <input class="form-control" type="text" id="telephone" name="telephone" value="${getTelephone}" required/>
					<c:if test="${not empty requestScope.errorTel}">
						<div>Renseigner un téléphone valide.</div>
					</c:if>
	            </div>
	            <div class="input col">
	                <label for="rue">Rue :</label>
	                <input class="form-control" type="text" id="rue" name="rue" value="${getRue}" required/>
	            </div>
	         </div>
	         <div class="form-row"> 
	            <div class="input col">
	                <label for="ville">Ville :</label>
	                <input class="form-control" type="text" id="ville" name="ville" value="${getVille}" required/>
	            </div>
	            <div class="input col">
	                <label for="codePostale">Code postal :</label>
	                <input class="form-control" type="text" id="codePostale" name="codePostale" value="${getCodePostale}" required/>
					<c:if test="${not empty requestScope.errorcp}">
						<div>Renseigner un code postal valide.</div>
					</c:if>
	            </div>
	         </div>
	          <div class="form-row"> 
	            <div class="input col">
	                <label for="mdp">Ancien Mot de passe :</label>
               		<input class="form-control" type="password" id="mdp" name="mdp" required/>
	            </div>
	         <div class="form-row"> 
	            <div class="input col">
	                <label for="mdp">Nouveau mot de passe :</label>
               		<input class="form-control" type="password" id="mdp" name="mdp" required/>
	            </div>
	           	<div class="input col">
	                <label for="confirmMdp">Confirmation mot de passe:</label>
               		<input class="form-control" type="password" id="confirmMdp" name="confirmMdp" required/>
	            
					 <c:if test="${not empty requestScope.error}">
						<!--  Show the error div with message -->
						 <div>Mots de passe non identiques.</div>
					 </c:if>
				</div>
			</div>
			<div class="form-row">
            	<div class="inputSubmit col">
                	<input class="btn-secondary my-2 py-2 mx-auto" type="submit" value="Modifier" />
            	</div>
            	<div class="col">
            	<button  class="btn-secondary my-2 py-2 mx-auto" type="button"> Supprimer </button>
            	</div>
            	            
	          
	        </div>
	   		</form>
	       
		
		
	</body>
</html>