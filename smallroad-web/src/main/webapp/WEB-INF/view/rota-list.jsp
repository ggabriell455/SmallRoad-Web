<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<title>ROTA</title>
</head>
<body>



	<c:forEach var="nf" items="${nfs}">
		<table>
			<tbody>
				<tr>
					<td><label>Numero:</label></td>
					<td>${nf.numero}</td>
				</tr>
				<tr>
					<td><label>CEP DESTINO:</label></td>
					<td>${nf.cepDestino}</td>
				</tr>
				<tr>
					<td><label>END DESTINO:</label></td>
					<td>${nf.endDestino}</td>
				</tr>
				<tr>
					<td><label>ROTEIRO:</label></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</c:forEach>




</body>
</html>