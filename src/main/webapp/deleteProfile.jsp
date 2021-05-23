<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="style/register.css">
		<title>Suppression Profile</title>
	</head>
	<body>
		<h1>Êtes-vous certain de vouloir supprimer votre profil?</h1>
		
		<div class="container">
		 <form action="<%=request.getContextPath()%>/DeleteProfileServlet" method="post">
			<div class="form-row">
				<div class="inputSubmit col text-center ">
					<c:if test="${sessionScope.noUser != null}">
				   <input type="hidden" id="id" name="id"
				      value="<c:out value='${sessionScope.noUser}' />" />
				</c:if>
				<input class="btn-secondary my-2 py-2 " type="submit" value="Valider" />
				
				<a href="updateProfile.jsp"> <button class="btn-secondary my-2 py-2" type="button">Annuler</button> </a>
				</div>
			</div>
		 </form>
		</div>
	</body>
</html>