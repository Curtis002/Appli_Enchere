<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="style/register.css">
	    <title>Enchères</title>
	</head>
	<body>
		<jsp:include page="headerConnecte.jsp"/>
		<h1>Détails du produit</h1>

		<div class="container">
			<div>
				<img class="col-3" src="img/meilleur-pc-gamer.jpg" alt="">
			</div>
			<div >
				<form action="<%=request.getContextPath() %>/EncherirServlet" method="post">
					<input type="hidden" id="numArticleVente" name="numArticleVente" value="${requestScope.articleVendu.noArticle}">
					<input type="hidden" id="nomArticle" name="nomArticle" value="${requestScope.articleVendu.nomArticle}">
				<div>
					<p>Produit : <c:out value="${requestScope.articleVendu.nomArticle}" /></p>
				</div>
				<div>
					<p>Description : <c:out value="${requestScope.articleVendu.description}" /></p>
				</div>
				<div>
					<p>Catégorie : <c:out value="${requestScope.articleVendu.categorie.libelle}" /></p>
				</div>
				<div>
					<p>Meilleur offre : </p>
				</div>
				<div>
					<p>Mise à prix : <c:out value="${requestScope.articleVendu.miseAPrix}" /> points</p>
				</div>
				<div>
					<p>Fin de l'enchère : <c:out value="${requestScope.articleVendu.dateFinEncheres}" /></p>
				</div>
				<div>
					<p>Retrait : <c:out value="${requestScope.articleVendu.retrait.rue}" /><span> </span> <c:out value="${requestScope.articleVendu.retrait.ville}" /><span> </span><c:out value="${requestScope.articleVendu.retrait.codePostal}" /></p>
				</div>
				<div>
					<p>Vendeur : <c:out value="${requestScope.articleVendu.utilisateur.pseudo}" /></p>
				</div>
					<div>
						<p>Ma proposition : <input class="col-3" id="proposition-enchere" type="number" name="proposition-enchere" required> </p>
					</div>
					<div>
						<p><input class="btn-secondary my-2 py-2 " type="submit" value="Enchérir" /></p>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>