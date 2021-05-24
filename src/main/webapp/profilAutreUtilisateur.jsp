<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Caro
  Date: 24/05/2021
  Time: 10:01
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
<h1>Profil membre</h1>

<%--<form action="<%=request.getContextPath() %>/updateProfile.jsp" method="post">--%>
    <div class="container">
        <div >
            <div>
                <p>Pseudo : <c:out value="${requestScope.unUtilisateur.pseudo}" /></p>
            </div>
            <div>
                <p>Nom : <c:out value="${requestScope.unUtilisateur.nom}" /></p>
            </div>
            <div>
                <p>Prénom : <c:out value="${requestScope.unUtilisateur.prenom}" /></p>
            </div>
            <div>
                <p>Email : <c:out value="${requestScope.unUtilisateur.email}" /></p>
            </div>
            <div>
                <p>Téléphone : <c:out value="${requestScope.unUtilisateur.telephone}" /></p>
            </div>
            <div>
                <p>Rue : <c:out value="${requestScope.unUtilisateur.rue}" /></p>
            </div>
            <div>
                <p>Code postal : <c:out value="${requestScope.unUtilisateur.code_postal}" /></p>
            </div>
            <div>
                <p>Ville : <c:out value="${requestScope.unUtilisateur.ville}" /></p>
            </div>
        </div>
    </div>
</form>

</body>
</html>
