<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/inicio" method="post">
		<p>
			N�mero de cuenta: <input type="number" name="idCuenta">
		</p>
		<input type="submit" value="Entrar">
		<h3>Mensajes: ${mensaje }</h3>
	</form>

</body>
</html>