<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	<div>
		<form:form action="/usuario/modificar" method="post" modelAttribute="usuario">
		<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="edad">edad:</form:label>
			<form:input type="text" path="edad"/><br>
			
			<input type="submit" value="Modificar usuario">
		</form:form>
		<br>
		<h1>Lista Usuarios</h1>
		<table>
			<thead>
				<tr>
					<th></th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Edad</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista_usuarios}">
				<tr>
					<td><c:out value="${usuario.id}"/></td>
					<td><c:out value="${usuario.rut}"/></td>
					<td><c:out value="${usuario.nombre}"/></td>
					<td><c:out value="${usuario.apellido}"/></td>
					<td><c:out value="${usuario.edad}"/></td>
					<td> 
						<a href="/usuario/actualizar/${usuario.id}">Editar</a>
						<form action="/usuario/eliminar" method="POST">
						<input type="hidden" name="id" value="<c:out value="${usuario.id}" />" >
						<input type="submit" value="Eliminar">
						</form>
						
					  	<form action="/usuario/eliminar/${usuario.id}" method="POST">
						<input type="hidden" name="_method" value="delete" >
						<input type="submit" value="Eliminar">
						</form>
						
					</td>
		
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>