<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
	<title>Smallroad Home</title>
</head>
<body>
		<form:form action="showFormforAdd" modelAttribute="roteiro">
		
			<table >
				<tr>
						<th> ID </th>
						<th> NOME </th>
						<th>  <th>
				
				</tr>
		
				<c:forEach var="roteiro" items="${roteiros}">
				
					<tr>
					
						<td> ${roteiro.id} </td>
						<td> ${roteiro.nome} </td>
						
	
					</tr>
					
				</c:forEach>
					
				</table>
				<input type="submit" value="Create List">
			</form:form>	
				
				
		
				
			

	


</body>
