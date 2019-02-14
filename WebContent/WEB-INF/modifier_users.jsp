<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier</title>
<link rel="stylesheet" href="ressource/css/modifier_users.css">
</head>
<body>
<h1>Modifier</h1>

<form action="modifier-users" method="post" >
<fieldset>
<legend>Vos Coordonnées</legend>


<input type="text" id="id" name="id" value="${users.id }" class="info" hidden="hidden" ><br><br>
<label for="nom">nom :</label>
<input type="text" id="nom" name="nom" value="${users.nom }" class="info"><br><br>

<label for="prenom">prenom :</label>
<input type="text" id="prenom" name="prenom" value="${users.prenom }" class="info"><br><br>

<label for="numero">numero :</label>
<input type="text" id="numero" name="numero" value="${users.numero }" class="info"><br><br>

<label for="phone">phone :</label>
<input type="text" id="phone" name="phone" value="${users.phone }" class="info"><br><br>

<label for="email">email :</label>
<input type="text" id="email" name="email" value="${users.email }" class="info"><br><br>

<label for="adresse">adresse :</label>
<input type="text" id="adresse" name="adresse" value="${users.adresse }" class="info"><br><br>

<label for="photo">photo :</label>
<input type="text" id="photo" name="photo"  value="${users.photo }" class="info"><br><br>

<input type="submit" value="envoye" class="dim_block4">
<input type="reset" value="Annuler" class="dim_block4">

</fieldset>
</form>

<a href="http://localhost:8080/utilisateur-db/users-servlet">retour</a>

</body>
</html>