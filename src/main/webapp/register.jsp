<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="style/register.css">
	<title>Register</title>
</head>
	<body>
		<h1>Page de création de compte</h1>
		
		<div class="container">
		 <form action="/appli_enchere/RegisterServlet" method="post">
		
            	<div class="input">
	                <label for="pseudo">Pseudo :</label>
	                <input type="text" id="pseudo" name="pseudo" required/>
	              <!--    <c:if test="${not empty requestScope.error}">
                   Show the error div with message
                    <div>Ce pseudo est déjà utilisé.</div>
                </c:if> -->
	            </div>
	            <div class="input">
	                <label for="nom">Nom :</label>
	                <input type="text" id="nom" name="nom" required/>
	            </div>
	            <div class="input">
	                <label for="prenom">Prénom :</label>
	                <input type="text" id="prenom" name="prenom" required/>
	            </div>
	            <div class="input">
	                <label for="mail">Email :</label>
	                <input type="text" id="mail" name="mail" required/>
	              <!--   <c:if test="${not empty requestScope.error}"> 
                     Show the error div with message
                     <div>Cette email est déjà utilisé.</div> 
                </c:if>   -->
	            </div>
	            <div class="input">
	                <label for="telephone">Téléphone :</label>
	                <input type="text" id="telephone" name="telephone" required/>
	            </div>
	            <div class="input">
	                <label for="rue">Rue :</label>
	                <input type="text" id="rue" name="rue" required/>
	            </div>
	            <div class="input">
	                <label for="ville">Ville :</label>
	                <input type="text" id="ville" name="ville" required/>
	            </div>
	            <div class="input">
	                <label for="codePostale">Code postal :</label>
	                <input type="text" id="codePostale" name="codePostale" required/>
	            </div>
	            <div class="input">
	                <label for="mdp">Mot de passe :</label>
               		<input type="password" id="mdp" name="mdp" required/>
	            </div>
	           	<div class="input">
	                <label for="confirmMdp">Confirmation :</label>
               		<input type="password" id="confirmMdp" name="confirmMdp" required/>
	            </div>
            	<div class="inputSubmit">
                	<input type="submit" value="Créer" />
                	<a href ="login.jsp"> <button type="button"> Annuler </button> </a> 
            	</div>
            	</form>            
	          </div>
	   
	       
  </body>
</html>