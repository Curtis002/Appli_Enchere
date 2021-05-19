<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		 <form action="/Appli_Enchere/RegisterServlet" method="post">
		
            	<div class="input">
	                <label for="pseudo">Pseudo :</label>
	                <input type="text" id="pseudo" name="pseudo"/>
	              <c:if test="${not empty requestScope.errorPseudo}">
                    <div>Ce pseudo est invalide / ou nonexistant.</div>
                </c:if>
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
	                 <c:if test="${not empty requestScope.errorEmail}">
                     <div>Renseigner un email valide / ou existant.</div>
                </c:if>
	            </div>
	            <div class="input">
	                <label for="telephone">Téléphone :</label>
	                <input type="text" id="telephone" name="telephone" required/>
					<c:if test="${not empty requestScope.errorTel}">
						<div>Renseigner un téléphone valide.</div>
					</c:if>
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
					<c:if test="${not empty requestScope.errorcp}">
						<div>Renseigner un code postal valide.</div>
					</c:if>
	            </div>
	            <div class="input">
	                <label for="mdp">Mot de passe :</label>
               		<input type="password" id="mdp" name="mdp" required/>
	            </div>
	           	<div class="input">
	                <label for="confirmMdp">Confirmation :</label>
               		<input type="password" id="confirmMdp" name="confirmMdp" required/>
	            </div>
					 <c:if test="${not empty requestScope.error}">
						 Show the error div with message
						 <div>Mots de passe non identiques.</div>
					 </c:if>
            	<div class="inputSubmit">
                	<input type="submit" value="Créer" />
                	<a href ="login.jsp"> <button type="button"> Annuler </button> </a> 
            	</div>
            	</form>            
	          </div>
	   
	       
  </body>
</html>