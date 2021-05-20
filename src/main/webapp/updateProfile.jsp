<%@ page import="fr.eni.appli_enchere.bo.Utilisateur" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
<%--		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
		<link rel="stylesheet" href="style/register.css">
		<title>Insert title here</title>
	</head>
	
	<body>
	<%  Utilisateur utilisateur = (Utilisateur) session.getAttribute("ConnectedUser"); %>
		<h1>Modification de mon Profile</h1>
		
		<div class="container">
		 <form action="<%=request.getContextPath() %>/UpdateProfileServlet" method="post">
			<div class="form-row">
				<c:if test="${sessionScope.noUser != null}">
					<input type="hidden" id="id" name="id" value="<c:out value='${sessionScope.noUser}' />" />
				</c:if>
				<div class="input col">
	                <label for="pseudo">Pseudo :</label>
	                <input class="form-control" type="text" id="pseudo" name="pseudo" value="${sessionScope.pseudo}" required/>
	            	<c:if test="${not empty requestScope.errorPseudo}">
                    <div>Ce pseudo est invalide / ou nonexistant.</div>
                	</c:if>
	            </div>
	            <div class="input col">
	                <label for="nom">Nom :</label>
	                <input class="form-control" type="text" id="nom" name="nom" value="${sessionScope.nom}" required/>
	            </div>
	        </div>
	        <div class="form-row">   
	            <div class="input col">
	                <label for="prenom">Prénom :</label>
	                <input class="form-control" type="text" id="prenom" name="prenom" value="${sessionScope.prenom}" required/>
	            </div>
	            <div class="input col">
	                <label for="mail">Email :</label>
	                <input class="form-control" type="text" id="mail" name="mail" value="${sessionScope.email}" required/>
	                 <c:if test="${not empty requestScope.errorEmail}">
                     <div>Renseigner un email valide / ou existant.</div>
                </c:if>
	            </div>
	        </div>
	        <div class="form-row">      
	            <div class="input col">
	                <label for="telephone">Téléphone :</label>
	                <input class="form-control" type="text" id="telephone" name="telephone" value="${sessionScope.telephone}" required/>
					<c:if test="${not empty requestScope.errorTel}">
						<div>Renseigner un téléphone valide.</div>
					</c:if>
	            </div>
	            <div class="input col">
	                <label for="rue">Rue :</label>
	                <input class="form-control" type="text" id="rue" name="rue" value="${sessionScope.rue}" required/>
	            </div>
	         </div>
	         <div class="form-row"> 
	            <div class="input col">
	                <label for="ville">Ville :</label>
	                <input class="form-control" type="text" id="ville" name="ville" value="${sessionScope.ville}" required/>
	            </div>
	            <div class="input col">
	                <label for="codePostale">Code postal :</label>
	                <input class="form-control" type="text" id="codePostale" name="codePostale" value="${sessionScope.code_postal}" required/>
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
	                <label for="mdpNew">Nouveau mot de passe :</label>
               		<input class="form-control" type="password" id="mdpNew" name="mdpNew"/>
	            </div>
	           	<div class="input col">
	                <label for="confirmMdp">Confirmation mot de passe:</label>
               		<input class="form-control" type="password" id="confirmMdp" name="confirmMdp"/>
	            
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
			  </div>
	   		</form>
		</div>
		
		
	</body>
</html>