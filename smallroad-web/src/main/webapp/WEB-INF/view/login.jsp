<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css"/>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/login.css"
	rel="stylesheet">
	
<title>Login</title>
</head>

<body>
	
	<div class="top"></div>
	
	<form:form action="checkLogin" class="form-signin">
	
    <div class="wrapper">      
      <h2 class="form-signin-heading">SmallRoadWeb - Login</h2>
      	<input  type="text" class="form-control" name="username" placeholder="Usuario ou E-mail" required autofocus />
      	<input  type="password" class="form-control" name="password" placeholder="Senha" required/>      
      	<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
     </div>
     
    </form:form>   
    
</body>

</html>