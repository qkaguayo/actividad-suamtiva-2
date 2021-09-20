<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Venta</title>
</head>
<body>
	<div>
		<form:form action="/venta/modificar" method="post" modelAttribute="venta">
		<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			
			<form:label path="producto">producto:</form:label>
			<form:input type="text" path="producto"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<form:label path="comentario">comentario:</form:label>
			<form:input type="text" path="comentario"/><br>
			
			<input type="submit" value="Modificar Venta">
		</form:form>
		<br>
		<h1>Lista Ventas</h1>
		<table>
			<thead>
				<tr>
					<th></th>
					<th>Producto</th>
					<th>Cantidad</th>
					<th>Comentarios</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="venta" items="${lista_ventas}">
				<tr>
					<td><c:out value="${venta.id}"/></td>
					<td><c:out value="${venta.producto}"/></td>
					<td><c:out value="${venta.cantidad}"/></td>
					<td><c:out value="${venta.comentario}"/></td>
					
					<td> 
						<a href="/venta/actualizar/${venta.id}">Editar</a>
						<form action="/venta/eliminar" method="POST">
						<input type="hidden" name="id" value="<c:out value="${venta.id}" />" >
						<input type="submit" value="Eliminar">
						</form>
						
					  	<form action="/venta/eliminar/${venta.id}" method="POST">
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