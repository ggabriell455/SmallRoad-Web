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
	
	<form:form action="saveNf" modelAttribute="tempNf" method="POST">

	
			
			Numero      <form:input path="numero"/>
			End Origem: <form:input path="EndOrigem"/>
			CEP Origem: <form:input path="cepOrigem"/>
			Endereço: <form:input path="endDestino"/>
			CEP:    <form:input path="cepDestino"/>
			
	
	
			
			 <input type="submit" value="Submit">

	</form:form>

</body>

</html>