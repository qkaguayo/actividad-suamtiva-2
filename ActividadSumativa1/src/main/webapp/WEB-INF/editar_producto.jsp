<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>
	<div>
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
		<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<form:label path="descripcion">descripcion:</form:label>
			<form:input type="text" path="descripcion"/><br>
			
			<input type="submit" value="Modificar producto">
		</form:form>
		<br>
		<h1>Lista productos</h1>
		<table>
			<thead>
				<tr>
					<th></th>
					<th>Nombre</th>
					<th>Cantidad</th>
					<th>Descripcion</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}">
				<tr>
					<td><c:out value="${producto.id}"/></td>
					<td><c:out value="${producto.nombre}"/></td>
					<td><c:out value="${producto.cantidad}"/></td>
					<td><c:out value="${producto.descripcion}"/></td>

					<td> 
						<a href="/producto/actualizar/${producto.id}">Editar</a>
						<form action="/producto/eliminar" method="POST">
						<input type="hidden" name="id" value="<c:out value="${producto.id}" />" >
						<input type="submit" value="Eliminar">
						</form>
						
					  	<form action="/producto/eliminar/${producto.id}" method="POST">
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