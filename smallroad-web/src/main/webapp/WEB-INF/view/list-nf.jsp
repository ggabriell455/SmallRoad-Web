<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
	<title>Smallroad Home</title>
</head>
<body>
			<input type="button" value="Add Nf"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<table>
				<tr>
					<th>Numero</th>
					<th>Cep</th>
					<th>Endere�o</th>
					<th>Data Entrega</th>
					<th>A��o</th>
				</tr>
				
				<!-- cria um la�o para printar os usuarios -->
				<c:forEach var="tempNf" items="${nfs}">
					<c:url var="updateLink" value="/nf/ShowFormForUpdate">
						<c:param name="nfNumero" value="${tempNf.numero}" />
					</c:url>					

					<!-- constroi um link de delete com a id do usuario -->
					<c:url var="deleteLink" value="/nf/delete">
						<c:param name="nfNumero" value="${tempNf.numero}" />
					</c:url>	
								
					<tr>
						<td> ${tempNf.numero} </td>
						<td> ${tempNf.cepDestino} </td>
						<td> ${tempNf.endDestino} </td>
						<td> ${tempNf.dtEntrega} </td>
						<td> 
							<a href="${updateLink}">UPDATE</a>|
							<a href="${deleteLink}">DELETE</a>
						
						
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>


	


</body>
</html>