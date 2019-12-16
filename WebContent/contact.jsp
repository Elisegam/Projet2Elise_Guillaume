<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact1</title>
</head>
<body>
	<h1>Contact</h1>

	<table>
	<tr>
	<th>Civilité</th>
	<th>Nom</th>
	<th>Prénom</th>
	</tr>

			<tr>
				<td>${newContact.civilite}</td>
				<td>${newContact.nom}</td>
				<td>${newContact.prenom}</td>
			</tr> 
	</table>
	<a href="contact-update.jsp">Modifier Contact</a>
</body>
</html>