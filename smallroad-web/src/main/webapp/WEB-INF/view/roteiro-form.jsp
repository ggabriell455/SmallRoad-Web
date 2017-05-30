<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
	<title>Smallroad Home</title>
</head>
<body>
		<form:form action="cadastrar" modelAttribute="roteiro" method="POST">
			<form:hidden var="roteiroId" path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="nome" /></td>
					</tr>
				</tbody>
			</table>
			<form:form modelAttribute="nfs" >
			<c:forEach var="nf" items="${nfs}">
			<table>
				<tbody>
					<tr>
						<td>Numero:</td>
						<td>CEP DESTINO</td>
						<td>END ORIGEM</td>
						<td></td>
					</tr>
					<tr>
						<td>${ nf.numero}</td>
						<td>${ nf.cepDestino}</td>
						<td>${ nf.endDestino}</td>
						<td> <input type="checkbox"/></td>
					</tr>
			
				</tbody>
			</table>
			</c:forEach>
				<input type="submit" />
			</form:form>
		
		</form:form>
		
		
				
				
		
				
			

	


</body>
