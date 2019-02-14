<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link rel="stylesheet" href="ressource/css/users.css">
</head>
<body>
	<h1>Users</h1>
	<a href="usersajouter">ajouter un utilisateur</a>
	<div id="conteneur">
		<c:forEach items="${users }" var="user">

			<div class="block_user">
				<div class="nom">${user.nom } ${user.prenom }</div>
				<div>
				<a href="users_info?id=${user.id }">
					<img src="${user.photo }">
					</a>
				</div>
				<div class="description">
					${user.phone }<br /> ${user.email }<br /> ${user.adresse }<br />
					${user.numero }
				</div>
			</div>

		</c:forEach>

	</div>
</body>
</html>