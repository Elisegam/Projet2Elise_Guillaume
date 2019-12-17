<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="stylelist.css" />
<title>Contact</title>
</head>
<body>
	<header id="header">
		<a href="index.html"><strong>Acceuil</strong></a>
	</header>
	<h1>Contact</h1>

		<h1>Gestionnaire de contacts</h1>
		
	<form method="post" action="SaveServlet" class="create">
		Civilité : <br> <input type="text" name="civilite"><br>
		Nom : <br> <input type="text" name="nom"><br>
		Prenom : <br> <input type="text" name="prenom"><br>
		Rue : <br> <input type="text" name="rue"><br>
		Code Postal : <br> <input type="text" name="codePostal"><br>
		Ville: <br> <input type="text" name="ville"><br>
		Pays : <br> <input type="text" name="pays"><br>
		<br> <input type="submit" value="Envoyer"> <input
			type="reset" value="RAZ">

	</form>
</body>
</html>