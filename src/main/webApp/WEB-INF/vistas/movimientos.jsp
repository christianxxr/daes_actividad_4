<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Número de cuenta: ${usuario.idCuenta }</h1>
	<h2>Saldo: ${listaCuentas}</h2>

	<table border="1">
		<tr>
			<th>Cantidad</th>
			<th>Fecha</th>
			<th>Operación</th>
		</tr>
		<c:forEach var="ele" items="${listaMovimientos}">
			<c:if test="${ele.cuenta.idCuenta == usuario.idCuenta }">
				<tr>
					<td>${ele.cantidad}</td>
					<td><fmt:formatDate type="both" dateStyle="medium"
							timeStyle="medium" value="${ele.fecha }" /></td>
					<td>${ele.operacion }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<a href="/cuentas/opciones">Volver</a>

</body>
</html>