<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<link rel="stylesheet" href="ressource/css/user_info.css">
</head>
<body>
<h1 id="uti">Info Utilisateur</h1>
<div class="nom">${user.nom } ${user.prenom }</div>
<div>
<img src="${user.photo }">
</div>
<div class="info">
${user.email }<br>
${user.phone }<br>
${user.adresse }<br>
${user.numero }<br>

<a href="usersupprimer?id=${user.id}"><button type="button">Supprimer</button></a>
<a href="modifier-users?id=${user.id}"><button type="button">Modifier</button></a>

</div>

<a href="http://localhost:8080/utilisateur-db/users-servlet">retour</a>

</body>
</html>