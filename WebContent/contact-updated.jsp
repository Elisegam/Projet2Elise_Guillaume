<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact1</title>
</head>
<body>
	<header id="header">
		<a href="index.html"><strong>Acceuil</strong></a>
	</header>
	<h1>Contact</h1>

	<table>
	<tr>
		<th>Civilité</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Rue</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Pays</th>
	</tr>

			<tr><td>${oldContact.civilite}</td>
			<td>${oldContact.nom}</td>
			<td>${oldContact.prenom}</td>
			<td>${oldContact.adresse.rue}</td>
			<td>${oldContact.adresse.ville}</td>
			<td>${oldContact.adresse.codePostal}</td>
			<td>${oldContact.adresse.pays}</td>
			</tr> 
	</table>
	<a href="contact-update.jsp">Modifier Contact</a>
</body>
</html>>