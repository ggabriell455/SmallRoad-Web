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

			<!-- precisa dessa informacao pra associar com a id do usuario -->
			<form:hidden var="roteiroId" path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="nome" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						
					</tr>

				
				</tbody>
			</table>
			
			<table>
				<tr>
					<th>Numero</th>
					<th>Cep</th>
					<th>Endereço</th>
					<th>Data Entrega</th>
					<th>Ação</th>
				</tr>
				
			
				<c:forEach var="tempNf" items="${nfs}">
					<form:checkboxes items="${tempNf}" path="${roteiroId}"/>			
					
					
					<tr>
						
					
						
						<td> ${tempNf.numero} </td>
						<td> ${tempNf.cepDestino} </td>
						<td> ${tempNf.endDestino} </td>
						<td> ${tempNf.dtEntrega} </td>
						<td> </td>

						
					</tr>
				
				</c:forEach>
						
			</table>
		<input type="submit" value="Salvar" class="save" />
		
		</form:form>
		
		
				
				
		
				
			

	


</body>
