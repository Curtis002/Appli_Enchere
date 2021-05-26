<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Caro
  Date: 18/05/2021
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="style/register.css">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Se connecter</title>
</head>
<body>
    <h1 class="spec-h1 mt-5">ENI-Enchères</h1>
    <div class="container-login">
        <form action="<%=request.getContextPath() %>/ConnectServlet" method="post">
            <div class="row mb-3">
                <label for="pseudo" class="col-sm-5 col-form-label">Identifiant :</label>
                <div class="col-sm-7">
                <input type="text" id="pseudo" name="pseudo" class="form-control" />
                </div>
            </div>

            <div class="row mb-3">
                <label for="mdp" class="col-sm-5 col-form-label">Mot de passe :</label>
                <div class="col-sm-7">
                <input type="password" id="mdp" name="mdp" class="form-control"/>
                </div>
            </div>
                <c:if test="${not empty requestScope.error}">
                    <!-- Show the error div with message-->
                    <div class="erreur-id">Mot de passe ou identifiant invalide</div>
                </c:if>
            <button type="submit" value="Connexion" class="btn btn-primary">Connexion</button>
        </form>
    </div>
    <div class="create-account">
        <p>
            Pas encore membre ?
            <a href="register.jsp" class="underlined"> Créer un compte</a>
        </p>
    </div>
</body>
</html>
