<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Caro
  Date: 18/05/2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="style/register.css">
    <title>Profile</title>
</head>
	<body>
	<jsp:include page="headerConnecte.jsp"/>
		<h1>Mon profil</h1>
		
		<form action="<%=request.getContextPath() %>/updateProfile.jsp" method="post">
			<div class="container">
				<div >
					<div>
						<p>Pseudo : <c:out value="${sessionScope.pseudo}" /></p>
					</div>
					<div>
						<p>Nom : <c:out value="${sessionScope.nom}" /></p>
					</div>
					<div>
						<p>Prénom : <c:out value="${sessionScope.prenom}" /></p>
					</div>
					<div>
						<p>Email : <c:out value="${sessionScope.email}" /></p>
					</div>
					<div>
						<p>Téléphone : <c:out value="${sessionScope.telephone}" /></p>
					</div>
					<div>
						<p>Rue : <c:out value="${sessionScope.rue}" /></p>
					</div>
					<div>
						<p>Code postal : <c:out value="${sessionScope.code_postal}" /></p>
					</div>
					<div>
						<p>Ville : <c:out value="${sessionScope.ville}" /></p>
					</div>
					<div>
						<input class="btn-secondary my-2 py-2 mx-auto" type="submit" value="Modifier" />
					</div>
				</div>	
			</div>
		</form>
		
	</body>
</html>
