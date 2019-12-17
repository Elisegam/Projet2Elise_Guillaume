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

		<tr>
			<td>${contact.civilite}</td>
			<td>${contact.nom}</td>
			<td>${contact.prenom}</td>
			<td>${contact.adresse.rue}</td>
			<td>${contact.adresse.ville}</td>
			<td>${contact.adresse.codePostal}</td>
			<td>${contact.adresse.pays}</td>
		</tr>
	</table>
	<a href="contact-update.jsp">Modifier Contact</a>
</body>
</html>