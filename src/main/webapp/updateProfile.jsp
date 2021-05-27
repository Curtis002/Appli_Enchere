<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="style/updateProfil.css">
<title>Modification de mon Profile</title>
</head>
	
<body>
<jsp:include page="headerConnecte.jsp"/>
		<h1>Modifier mon profil</h1>

		 <form action="<%=request.getContextPath() %>/UpdateProfileServlet" method="post">
			<div class="container">
			<div class="form-row">
				<c:if test="${sessionScope.noUser != null}">
					<input type="hidden" id="id" name="id"
						value="<c:out value='${sessionScope.noUser}' />" />
				</c:if>
				<div class="input col">
					<label for="pseudo">Pseudo :</label> <input class="form-control"
						type="text" id="pseudo" name="pseudo"
						value="${sessionScope.pseudo}" required />
					<c:if test="${not empty requestScope.errorPseudoDejaUtilise}">
						<div class="text-danger">Ce pseudo est invalide ou déjà utilisé.</div>
					</c:if>
				</div>
				<div class="input col">
					<label for="nom">Nom :</label> <input class="form-control"
						type="text" id="nom" name="nom" value="${sessionScope.nom}"
						required />
				</div>
			</div>
			<div class="form-row">
				<div class="input col">
					<label for="prenom">Prénom :</label> <input class="form-control"
						type="text" id="prenom" name="prenom"
						value="${sessionScope.prenom}" required />
				</div>
				<div class="input col">
					<label for="mail">Email :</label> <input class="form-control"
						type="text" id="mail" name="mail" value="${sessionScope.email}"
						required />
					<c:if test="${not empty requestScope.errorEmailDejaUtilise}">
						<div class="text-danger">Cet email est invalide ou déjà utilisé.</div>
					</c:if>
				</div>
			</div>
			<div class="form-row">		
				<div class="input col">
					<label for="telephone">Téléphone :</label> <input
						class="form-control" type="text" id="telephone" name="telephone"
						value="${sessionScope.telephone}" required />
					<c:if test="${not empty requestScope.errorTel}">
						<div class="text-danger">Renseigner un téléphone valide.</div>
					</c:if>
				</div>
				<div class="input col">
					<label for="rue">Rue :</label> <input class="form-control"
						type="text" id="rue" name="rue" value="${sessionScope.rue}"
						required />
				</div>
			</div>
			<div class="form-row">
				<div class="input col">
					<label for="ville">Ville :</label> <input class="form-control"
						type="text" id="ville" name="ville" value="${sessionScope.ville}"
						required />
				</div>
				<div class="input col">
					<label for="codePostale">Code postal :</label> <input
						class="form-control" type="text" id="codePostale"
						name="codePostale" value="${sessionScope.code_postal}" required />
					<c:if test="${not empty requestScope.errorcp}">
						<div class="text-danger">Renseigner un code postal valide.</div>
					</c:if>
				</div>
			</div>
			<div class="form-row">
				<div class="input col">
					<label for="mdp">Ancien Mot de passe :</label> <input
						class="form-control" type="password" id="mdp" name="mdp" required />
					<c:if test="${not empty requestScope.errorMdp}">
						<div class="text-danger">Le mot de passe renseigné n'est pas bon.</div>
					</c:if>
				</div>
				<div class="container">
				
					<%-- <input class="" id="how-other" name="how" type="checkbox">
					<label for="how-other" class="how-other side-label">Cliquez pour changer votre
						mot de passe ?</label>
						<c:if test="${not empty requestScope.errorNewMdp}">
						<!--  Show the error div with message -->
						 <div class="text-danger">Nouveau Mot de passe et Confirmation non identiques..</div>
					 </c:if>
			
					<div class="form-row how-other-disclosure">
						<div class="input col">
							<label for="mdp how-other-explain">Nouveau Mot de passe :</label> <input
								class="form-control" type="password" id="mdpNew how-other-explain" name="mdpNew"
								/>
						</div> --%>
						
    				<input id="how-other" name="how" type="checkbox">
   					 <label for="how-other" class="side-label">Cliquez pour changer votre
						mot de passe ?</label>
						<c:if test="${not empty requestScope.errorNewMdp}">
						<!--  Show the error div with message -->
						 <div class="text-danger">Nouveau Mot de passe et Confirmation non identiques..</div>
					 </c:if>
     			
    				<div class="how-other-disclosure">
    				
      			
					<div class="form-row">
					
      					<div class="input col">
							<label for="mdp how-other-explain">Nouveau Mot de passe :</label> 
							<input class="form-control" type="password" id="mdpNew" name="mdpNew"/>
						</div>
					
						<div class="input col">
							<label for="confirmMdp how-other-explain" >Confirmez votre
								nouveau mot de passe</label> 
							<input class="form-control" type="password" id="confirmMdp" name="confirmMdp" />
							<c:if test="${not empty requestScope.errorNewMdp}">
								<!--  Show the error div with message -->
						 		<div class="text-danger">Nouveau Mot de passe et Confirmation non identiques.</div>
					 		</c:if>
						</div>
					</div>
						
						
						
    				</div>
					</div>
					
					
					<div  class="form-row ">
						<div class="inputSubmit col text-center ">
							<input class="btn-secondary my-2 py-2 " type="submit"
								value="Modifier" />

							<a href="deleteProfile.jsp">
							<button class="btn-secondary my-2 py-2 " type="button"> 
								Supprimer</button> </a>
						</div>
					</div>
				</div>
			</div>
			 </div>
		</form>

</body>
</html>