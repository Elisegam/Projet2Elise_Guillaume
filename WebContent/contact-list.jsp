<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Contact</title>
</head>
<body>
	<h1>Contact</h1>

	<table>
	<tr>
	<th>Civilité</th>
	<th>Nom</th>
	<th>Prénom</th>
	</tr>
		<c:forEach var="contact" items="${listContact}">
			<tr>
				<td>${contact.civilite}</td>
				<td>${contact.nom}</td>
				<td>${contact.prenom}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>