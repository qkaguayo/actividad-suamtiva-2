<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div>
		<form:form action="/registro/crear" method="post" modelAttribute="registro">
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br> 
			
			<form:label path="edad">edad:</form:label>
			<form:input type="text" path="edad"/><br>
			
			<form:label path="email">email:</form:label>
			<form:input type="text" path="email"/><br>
			
			<form:label path="password">password:</form:label>
			<form:input type="text" path="password"/><br> 
			<br>
			
			<br>
			
			<input type="submit" value="crear registro">
		</form:form>
		<br>
		<hr>
		<h1>Lista de registros</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Edad</th>
					<th>email</th> 
					<th>Password</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="registro" items="${lista_registros}" >
				<tr>
					<td><c:out value="${registro.id}" /> </td>
					<td><c:out value="${registro.rut}" /> </td>
					<td><c:out value="${registro.nombre}" /> </td>
					
					<td><c:out value="${registro.apellido}" /> </td> 
					<td><c:out value="${registro.edad}" /> </td>
					<td><c:out value="${registro.email}" /> </td>
					<td><c:out value="${password.cargo}" /> </td>
					
					
					
					<td>
						<a href="/registro/actualizar/${registro.id}">EDITAR</a>
						
					
						 
						<form action="/registro/eliminar2/${registro.id}" method="POST">
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

