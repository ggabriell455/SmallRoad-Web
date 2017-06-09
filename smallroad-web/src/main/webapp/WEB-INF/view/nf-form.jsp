<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<title>SmallRoad - ADD NF</title>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/css/nf-form.css"
	rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"><span class="glyphicon glyphicon-road" aria-hidden="true" style="color:#FFF;"></span></a>
				<a class="navbar-brand" href="#">SmallROAD</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/usuario/home">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/usuario/list">Usuários</a></li>
					<li><a href="${pageContext.request.contextPath}/nf/list">Notas
							Fiscais</a></li>
					<li><a href="${pageContext.request.contextPath}/roteiro/list">Roteiros</a></li>
					<li><a href="#">Ajuda</a></li>
					<li><a href="${pageContext.request.contextPath}/usuario/login">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div id="main" class="container-fluid">
		
	<form:form action="saveNf" modelAttribute="tempNf" method="POST">
		<c:choose>
			<c:when test="${not empty tempNf.numero }">
				<h3 class="page-header"> Atualizar Nota Fiscal</h3>
			</c:when>
			<c:otherwise>
				<h3 class="page-header"> Cadastrar Nota Fiscal</h3>
			</c:otherwise>
		</c:choose>
		<br/>
		
		<div class="row">

			<div class="form-group col-md-4">
			
			<c:if test="${empty tempNf.numero }">
				<label for="numeroNF">Número NF</label>
					<form:input path="numero" type="text" class="form-control sizeAddNF"
					id="numeroNF" name="numeroNF" placeholder="Digite o Número da NF" required="Campo Obrigatório"/>
			</c:if>
			</div>

		</div>

		<div class="row">

			<div class="form-group col-md-4">
				<label for="exampleInputEmail1">Endereço de Destino</label>
					<form:input path="endDestino" type="text" class="form-control sizeAddNF"
					id="enderecoDestino" placeholder="Digite o Endereço de Destino" required="Campo Obrigatório"/>
			</div>

			<div class="form-group col-md-4">
				<label for="exampleInputEmail1">CEP de Destino</label>
					<form:input path="cepDestino" type="text" class="form-control sizeAddNF"
					id="cepDestino" name="cepDestino" placeholder="Digite o CEP de Destino" required="Campo Obrigatório"/>
			

				<div class="form-group col-md-3"></div>
				<div class="form-group col-md-3"></div>
			</div>

		</div>
		
			<hr />

			<div class="row">
				<div class="col-md-12" style="margin-bottom: 60px">
					<input type="submit" value="Salvar" class="btn btn-primary">

					<a href="${pageContext.request.contextPath}/nf/list" class="btn btn-default">Cancelar</a>
				</div>
			</div>

	</form:form>

	</div>
	
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<center><p style="color: #a8a8a8; margin-top: 15px;">&#169; SmallRoad - Todos Os Direitos Reservados - 2017</p></center>
	</nav><!-- footer -->
	
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script 
		src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.min.js"></script>
    <script
    	 src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
    <script 
    	src="${pageContext.request.contextPath}/resources/js/jquery.zebra-datepicker.js"></script>

</body>

</html>