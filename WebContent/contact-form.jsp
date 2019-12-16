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

		<h1>Gestionnaire de contacts</h1>
		<h2>
			<a href="/contact-list.jsp">Liste des contacts</a>

		</h2>

		<div align="center">
			<form action="ContactServlet" method="post">
			<h2>Add New User</h2>
				<table border="1" cellpadding="5">

					<tr>
						<th>Civilité:</th>
						<td><input type="text" name="civilite" size="45"
							value="<c:out value='${contact.civilite}' />" /></td>
					</tr>
					<tr>
						<th>Nom:</th>
						<td><input type="text" name="nom" size="45"
							value="<c:out value='${contact.nom}' />" /></td>
					</tr>
					<tr>
						<th>Prénom:</th>
						<td><input type="text" name="country" size="15"
							value="<c:out value='${contact.prenom}' />" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save" /></td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>