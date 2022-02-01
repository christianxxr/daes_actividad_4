<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/cuentas/ingresar" method="post">
		<p>
			Introduce la cantidad: <input type="number" name="saldo">
		</p>
		<input type="submit" value="Enviar">
		<input type="hidden" value="${usuario.idCuenta }" name="idCuenta">
	</form>
</body>
</html>