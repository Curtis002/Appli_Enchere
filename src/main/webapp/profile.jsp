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
	
		<h1>Mon Profile</h1>
		
		<form action="/Appli_Enchere/updateProfile.jsp" method="post">
			<div class="container">
				<div >
					<div>
						<label for="pseudo">Pseudo : </label> 
					</div>
					<div>
						<label for="nom">Nom :  </label>
					</div>
					<div>
						<label for="prenom">Prénom :  </label>
					</div>
					<div>
						<label for="mail">Email :  </label>
					</div>
					<div>
						<label for="telephone">Téléphone :  </label>
					</div>
					<div>
						<label for="rue">Rue :  </label>
					</div>
					<div>
						<label for="codePostale">Code postal :  </label>
					</div>
					<div>
						<label for="ville">Ville :  </label>
					</div>
					<div>
						<input class="btn-secondary my-2 py-2 mx-auto" type="submit" value="Modifier" />
					</div>
				</div>	
			</div>
		</form>
		
	</body>
</html>
