<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SmallROAD - Adicionar Usuário</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/usuario-form.css"
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
					<li><a href="../home.jsp">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/usuario/list">Usuários</a></li>
					<li><a href="${pageContext.request.contextPath}/nf/list">Notas
							Fiscais</a></li>
					<li><a href="${pageContext.request.contextPath}/roteiro/list">Roteiros</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="main" class="container-fluid">

		<h3 class="page-header">Adicionar Usuário</h3>

		<br/>
		<br/>

		<form:form id="formulario" action="saveUsuario" modelAttribute="usuario" method="POST">
			<form:hidden path="id" />
			<div class="row">

				<div class="form-group col-md-3">
					<label for="exampleInputEmail1">Nome</label>
					<form:input path="nome" type="text" class="form-control sizeAddUsuario"
						id="exampleInputEmail1" placeholder="Digite o nome do Usuário" required="Campo Obrigatório"/>
				</div>

				<div class="form-group col-md-3">
					<label for="exampleInputEmail1">Username/NickName</label>
					<form:input path="nickname" type="text" class="form-control sizeAddUsuario"
						id="exampleInputEmail1" placeholder="Digite um Usuário" required="Campo Obrigatório"/>
				</div>
				
				<div class="form-group col-md-3">
					<label for="exampleInputEmail1">E-mail</label>
					<form:input path="email" type="email" class="form-control sizeAddUsuario"
						id="exampleInputEmail1" placeholder="Digite um e-mail" required="Campo Obrigatório"/>
				</div>
				
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="exampleInputEmail1">Senha</label>
					<form:input path="senha" type="password" class="form-control sizeAddUsuario"
						id="exampleInputEmail1" placeholder="Digite uma senha" required="Campo Obrigatório"/>
				</div>

				<div class="form-group col-md-3 ">
					<label for="exampleInputEmail1">Perfil</label>
					<form:select class="form-control sizeAddUsuario" path="perfil">
						<form:option value="Admin" label="Admin" />
						<form:option value="Supervisor" label="Supervisor" />
						<form:option value="Motorista" label="Motorista" />
					</form:select>
				</div>
				
			</div>

			<hr />

			<div class="row">
				<div class="col-md-12" style="margin-bottom: 60px">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="${pageContext.request.contextPath}/usuario/list"
						class="btn btn-default">Cancelar</a>
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
</body>
</html>