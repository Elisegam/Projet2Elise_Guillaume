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

		<h1>Modifier contact</h1>
		
	<form method="post" action="UpdateServlet">
		Civilité : <br> <input type="text" name="civilite" placeholder=""><br>
		Nom : <br> <input type="text" name="nom" placeholder="">><br>
		Prenom : <br> <input type="text" name="prenom" placeholder="">><br>
		<br> <input type="submit" value="Envoyer"> <input
			type="reset" value="RAZ">

	</form>
</body>
</html>