<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="stylelist.css" />

<title>Contact Liste</title>
</head>
<body>
	<header id="header">
		<a href="index.html"><strong>Acceuil</strong></a>
	</header>
	<h1>Liste des contacts</h1>
	
		<a href="contact-form.jsp" class="link">Créer un nouveau contact</a>
		
	
	<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive">
				<table
					summary="This table shows how to create responsive tables using Bootstrap's default functionality"
					class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Civilité</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Rue</th>
							<th>Ville</th>
							<th>Code Postal</th>
							<th>Pays</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="contact" items="${listContact}">
							<tr>
								<td>${contact.civilite}</td>
								<td>${contact.nom}</td>
								<td>${contact.prenom}</td>
								<td>${contact.adresse.rue}</td>
								<td>${contact.adresse.ville}</td>
								<td>${contact.adresse.codePostal}</td>
								<td>${contact.adresse.pays}</td>
								<td><form
										action="UpdateButton?pk=<c:out value='${contact.pk}'/>"
										method="post" /> <input type="hidden" name="pk"
									value='${contact.pk}'> <input type="submit"
									value="Modif">
									</form></td>
								<td><form
										action="DeleteServlet?pk=<c:out value='${contact.pk}'/>"
										method="post" /> <input type="hidden" name="pk"
									value='${contact.pk}'> <input type="submit"
									value="Supprim">
									</form></td>

							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
			<!--end of .table-responsive-->
		</div>
	</div>
	</div>
	<%-- <table>
		<tr>
			<th>Civilité</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Rue</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Pays</th>

		</tr>
		<c:forEach var="contact" items="${listContact}">
			<tr>
				<td>${contact.civilite}</td>
				<td>${contact.nom}</td>
				<td>${contact.prenom}</td>
				<td>${contact.adresse.rue}</td>
				<td>${contact.adresse.ville}</td>
				<td>${contact.adresse.codePostal}</td>
				<td>${contact.adresse.pays}</td>
				<td><form
						action="UpdateButton?pk=<c:out value='${contact.pk}'/>"
						method="post" /> <input type="hidden" name="pk"
					value='${contact.pk}'> <input type="submit" value="Modif">
					</form></td>
				<td><form
						action="DeleteServlet?pk=<c:out value='${contact.pk}'/>"
						method="post" /> <input type="hidden" name="pk"
					value='${contact.pk}'> <input type="submit" value="Supprim">
					</form></td>

			</tr>
		</c:forEach> --%>
	<!-- </table> -->
</body>
</html>