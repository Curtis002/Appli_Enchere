<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="style/register.css">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
	<title>Register</title>
</head>
	<body>
		<h1>Page de création de compte</h1>
		
		<div class="container">
		 <form action="<%=request.getContextPath() %>/RegisterServlet" method="post">
			<div class="form-row">
            	<div class="input col">
	                <label for="pseudo">Pseudo :</label>
	                <input class="form-control" type="text" id="pseudo" name="pseudo" required/>
	            	<c:if test="${not empty requestScope.errorPseudo}">
                    <div>Ce pseudo est invalide / ou nonexistant.</div>
                	</c:if>
	            </div>
	            <div class="input col">
	                <label for="nom">Nom :</label>
	                <input class="form-control" type="text" id="nom" name="nom" required/>
	            </div>
	        </div>
	        <div class="form-row">   
	            <div class="input col">
	                <label for="prenom">Prénom :</label>
	                <input class="form-control" type="text" id="prenom" name="prenom" required/>
	            </div>
	            <div class="input col">
	                <label for="mail">Email :</label>
	                <input class="form-control" type="text" id="mail" name="mail" required/>
	                 <c:if test="${not empty requestScope.errorEmail}">
                     <div>Renseigner un email valide / ou existant.</div>
                </c:if>
	            </div>
	        </div>
	        <div class="form-row">      
	            <div class="input col">
	                <label for="telephone">Téléphone :</label>
	                <input class="form-control" type="text" id="telephone" name="telephone" required/>
					<c:if test="${not empty requestScope.errorTel}">
						<div>Renseigner un téléphone valide.</div>
					</c:if>
	            </div>
	            <div class="input col">
	                <label for="rue">Rue :</label>
	                <input class="form-control" type="text" id="rue" name="rue" required/>
	            </div>
	         </div>
	         <div class="form-row"> 
	            <div class="input col">
	                <label for="ville">Ville :</label>
	                <input class="form-control" type="text" id="ville" name="ville" required/>
	            </div>
	            <div class="input col">
	                <label for="codePostale">Code postal :</label>
	                <input class="form-control" type="text" id="codePostale" name="codePostale" required/>
					<c:if test="${not empty requestScope.errorcp}">
						<div>Renseigner un code postal valide.</div>
					</c:if>
	            </div>
	         </div>
	         <div class="form-row"> 
	            <div class="input col">
	                <label for="mdp">Mot de passe:</label>
               		<input class="form-control" type="password" id="mdp" name="mdp" required/>
	            </div>
	           	<div class="input col">
	                <label for="confirmMdp">Confirmation:</label>
               		<input class="form-control" type="password" id="confirmMdp" name="confirmMdp" required/>
	            
					 <c:if test="${not empty requestScope.errormdp}">
						 <div>Mots de passe non identiques.</div>
					 </c:if>
				</div>
			</div>
			<div class="form-row">
            	<div class="inputSubmit col">
                	<input class="btn-secondary my-2 py-2 mx-auto" type="submit" value="Créer" />
                	<a href ="login.jsp">  </a> 
            	</div>
            	<div class="col">
            	<button  class="btn-secondary my-2 py-2 mx-auto" type="button"> Annuler </button>
            	<a href ="Accueil.jsp">  </a>
            	</div>  
	        </div>
	   	</form>
	   </div>
	   
	       
  </body>
</html>