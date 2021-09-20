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
		<form:form action="/venta/crear" method="post" modelAttribute="venta">
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="valor total">valor total:</form:label>
			<form:input type="text" path="valor total"/><br>
			
			<input type="submit" value="Crear venta">
		</form:form>
		<br>
		<h1>Lista Ventas</h1>
		<table>
			<thead>
				<tr>
					<th></th>
					<th>nombre</th>
					<th>valor total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="venta" items="${lista_ventas}">
				<tr>
					<td><c:out value="${venta.id}"/></td>
					<td><c:out value="${venta.nombre}"/></td>
					<td><c:out value="${venta.valor_total}"/></td>
					<td> 
						<a href="/venta/actualizar/${venta.id}">Editar</a>
						
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
