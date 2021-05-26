<%--
  Created by IntelliJ IDEA.
  User: Caro
  Date: 21/05/2021
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/header.css">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Eni-Enchères</title>
</head>
<body>
    <nav class="navbar">
        <div>
            <a class="nav-link" href="<%=request.getContextPath()%>/ConnectServlet" style="color: black"><h1 class="spec-h1">ENI-ENCHERES</h1></a>
        </div>
        <div class="btn-group" role="group" >
        	<input class="btn btn-primary sm-2" type="button" value = "Rafraîchir" onclick="history.go(0)" /> 
        	<input class="btn btn-primary sm-2" type="button" value = "Retour" onclick="history.go(-1)" />
        </div>
        <div class="header">
            <ul class="nav justify-content-end">
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/ConnectServlet">Enchères</a></li>
                <li class="nav-item"><a class="nav-link" href="nouvelleVente.jsp">Vendre un article</a></li>
                <li class="nav-item"><a class="nav-link" href="profile.jsp">Mon profil</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/LogoutServlet">Déconnexion</a></li>
            </ul>
        </div>
    </nav>
</body>
</html>
