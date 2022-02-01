<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.menu {
	display: flex;
}

.menu a {
	border: 2px solid #00AEFF;
	padding: 0.625em;
	color: #000;
	display: block;
	text-decoration: none;
	text-transform: uppercase;
	font-weight: 400;
	width: 100%;
	text-align: center;
	transition: 0.2s ease all;
	font-size: 1em;
}

.menu a:hover {
	background: #00AEFF;
}
</style>
<body>

	<h3>Bienvenido, número de cuenta ${usuario.idCuenta }</h3>

	<nav class="menu">
		<a href="/cuentas/ingresar">Ingresar</a> <a href="/cuentas/extraer">Extraer</a>
		<a href="/cuentas/verMovimientos">Ver movimientos</a> <a
			href="/cuentas/transferencia">Transferencia</a> <a
			href="/cuentas/cerrarSesion">Cerrar sesión</a>
	</nav>
	<h3>Mensajes: ${mensaje}</h3>
</body>
</html>