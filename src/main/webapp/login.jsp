<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="session" var="isConnected" value="${sessionScope['isConnected']}" />
<c:set scope="session" var="hasErrors" value="${sessionScope['hasErrors']}" />
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
        <form action="/ConnectServlet" method="post">
            <div class="input">
                <label for="identifiant">
                    <c:if test="${hasErrors}">
                        <span class='error'>* </span>
                    </c:if>Username:
                </label>
                <input type="text" id="identifiant" name="identifiant" />
            </div>

            <div class="input">
                <label for="mdp">
                    <c:if test="${hasErrors}">
                        <span class='error'>* </span>
                    </c:if> Password:
                </label>
                <input type="password" id="mdp" name="mdp" />
            <div class="inputSubmit">
                <input type="submit" value="Connexion" />
            </div>
            </div>
        </form>
        <p id="links">
            Créer un compte
            <a href="register.jsp">here</a>.
        </p>
    </div>
</body>
</html>
