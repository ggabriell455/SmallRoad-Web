<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<form:form action="saveNf" method="POST" modelAttribute="tempNf">
		<form:hidden path="cepOrigem"/>
		<form:hidden path="endOrigem"/>
		<form:hidden path="numero"/>
		
			<label> ${tempNf.numero}</label>
			
			
			Endereço: <form:input path="endDestino"/>
			CEP:    <form:input path="cepDestino"/>
			
			 <input type="submit" value="Submit">

	</form:form>

</body>

</html>