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
						<td><label>Numero:</label></td>
						<td>${nf.numero}</td>
					</tr>
					<tr>
						<td><label>CEP ORIGEM:</label></td>
						<td>${nf.cepOrigem}</td>
					</tr>
					<tr>
						<td><label>END ORIGEM:</label></td>
						<td>${nf.endOrigem}</td>
					</tr>
					<tr>
						<td><label>ROTEIRO:</label></td>
						<td><form:checkbox path="nfs" value="nf"/></td>
					</tr>
				</tbody>
			</table>
			</c:forEach>
			</form:form>
		
		</form:form>
		
		
				
				
		
				
			

	


</body>
