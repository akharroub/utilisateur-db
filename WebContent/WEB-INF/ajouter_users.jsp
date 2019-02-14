<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="ressource/css/ajouter_users.css">
<title>ajouter</title>
</head>
<body>
<h1>ajouter users</h1>
<form action="usersajouter" method="post" >
<fieldset>
<legend>Vos Coordonnées</legend>

<label for="nom">nom</label>
<input type="text" id="nom" name="nom" class="info"><br><br>

<label for="prenom">prenom :</label>
<input type="text" id="prenom" name="prenom" class="info"><br><br>

<label for="numero">numero :</label>
<input type="text" id="numero" name="numero" class="info"><br><br>

<label for="phone">phone :</label>
<input type="text" id="phone" name="phone" class="info"><br><br>

<label for="email">email :</label>
<input type="text" id="email" name="email" class="info"><br><br>

<label for="adresse">adresse :</label>
<input type="text" id="adresse" name="adresse" class="info"><br><br>

<label for="photo">photo :</label>
<input type="text" id="photo" name="photo" class="info"><br><br>

<input type="submit" value="envoye" class="dim_block4">
<input type="reset" value="Annuler" class="dim_block4">

</fieldset>
</form>

<a href="http://localhost:8080/utilisateur-db/users-servlet">retour</a>
</body>
</html>