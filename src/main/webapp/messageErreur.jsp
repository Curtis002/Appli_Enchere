<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	request.setAttribute("title", "Erreur");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message Erreur</title>
</head>
<body>
<div class="infos titled centered">
	<p class="title">Une erreure est survenue</p>

	<table>
		<tr>
			<td><p>Une erreur s'est produite :</p></td>
			<td><p><b>${e.getMessage() }</b></p></td>
		</tr>

		<tr>
			<td><p>Cause de l'erreur : </p></td>
			<td><p>${e.getCause() }</p></td>
		</tr>

		<tr>
			<td><p>Détail : </p></td>
			<td><p>${e.getStackTrace()[0].getClassName() } - ${e.getStackTrace()[0].getMethodName() } - ${e.getStackTrace()[0].getLineNumber() }</p></td>
		</tr>
	</table>
	<p>${e.getLocalizedMessage()}</p>
</div>
</body>
</html>