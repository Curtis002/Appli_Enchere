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
    <title>Se connecter</title>
</head>
<body>
    <div class="container">
        <form action="/appli_enchere/ConnectServlet" method="post">
            <div class="input">
                <label for="pseudo">Pseudo :</label>
                <input type="text" id="pseudo" name="pseudo" />
            </div>

            <div class="input">
                <label for="mdp">Mot de passe :</label>
                <input type="password" id="mdp" name="mdp" />
                <div>
                <c:if test="${not empty requestScope.error}">
                    <!-- Show the error div with message-->
                    <div>Mot de passe ou identifiant invalide</div>
                </c:if>
                </div>
            <div class="inputSubmit">
                <input type="submit" value="Connexion" />
            </div>
            </div>
        </form>
        <p id="links">
            Créer un compte
            <a href="register.jsp">ici</a>.
        </p>
    </div>
</body>
</html>
