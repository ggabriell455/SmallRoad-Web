<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
	<title>ROTA</title>
</head>
<body>
		

			
			
		<form:form modelAttribute="rota">
			<table>
				<tr>
					<th></th>
		
				</tr>
				
				<tr>
				
					<td>${rota.distancia}</td>
							
				
				</tr>
				
			

						
			</table>
		</form:form>

	


</body>
</html>