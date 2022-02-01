<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Transferencias</h1>

	<form action="/cuentas/transferencia" method="post">

		<p>
			Introduzca la cantidad: <input type="number" name="cantidad">
		</p>
		<p>
			Seleccione cuenta destino: <select name="cuenta.idCuenta">
				<c:forEach var="ele" items="${listaCuentas}">
					<c:if test="${ele.idCuenta != usuario.idCuenta }">
						<option value="${ele.idCuenta}">${ele.idCuenta}</option>
					</c:if>
				</c:forEach>
			</select>
		</p>
		<input type="hidden" value="${usuario.idCuenta }" name="idCuenta">
		<input type="submit" value="Transferir">
	</form>

</body>
</html>