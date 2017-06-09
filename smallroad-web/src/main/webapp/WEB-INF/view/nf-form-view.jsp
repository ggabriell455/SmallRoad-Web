<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SmallROAD - Visualizar</title>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
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

	<form:form modelAttribute="nf" method="POST">
		<form:hidden path="numero" />
		<c:url var="updateLink" value="/nf/showFormForUpdate">
			<c:param name="nfNumero" value="${nf.numero}" />
		</c:url>
		<c:url var="deleteLink" value="/nf/delete">
			<c:param name="nfNumero" value="${nf.numero}" />
		</c:url>

		<div id="main" class="container-fluid">
			<h3 class="page-header">Nf Numero: ${nf.numero}</h3>

			<div class="row">
				<div class="col-md-4">
					<p>
						<strong>Nome</strong>
					</p>
					<p>${nf.cepOrigem}</p>
				</div>

				<div class="col-md-4">
					<p>
						<strong>Cep Destino</strong>
					</p>
					<p>${nf.cepDestino}</p>
				</div>

				<div class="col-md-4">
					<p>
						<strong>Endereço Destino</strong>
					</p>
					<p>${nf.endDestino}</p>
				</div>

				<div class="col-md-4">
					<p>
						<strong>Roteiro N:</strong>
					</p>
					<p>${nf.roteiro.id}</p>
				</div>

				<div class="col-md-4">
					<p>
						<strong>Entregue</strong>
					</p>
					<p>${nf.entregue}</p>
				</div>

			</div>

			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="${pageContext.request.contextPath}/nf/list"
						class="btn btn-primary">Fechar</a> <a href="${updateLink}"
						class="btn btn-default">Editar</a> <a href="${deleteLink}"
						class="btn btn-default"
						onclick="if (!(confirm('Tem certeza que deseja deletar a nota fiscal?'))) return false">Excluir</a>
				</div>
			</div>

		</div>

	</form:form>
	
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<center><p style="color: #a8a8a8; margin-top: 15px;">&#169; SmallRoad - Todos Os Direitos Reservados - 2017</p></center>
	</nav><!-- footer -->

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>