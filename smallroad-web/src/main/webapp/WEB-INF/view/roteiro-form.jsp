<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SmallROAD - Usuario</title>

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
					<li><a href="../home.jsp">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/usuario/list">Usu�rios</a></li>
					<li><a href="${pageContext.request.contextPath}/nf/list">Notas
							Fiscais</a></li>
					<li><a href="${pageContext.request.contextPath}/roteiro/list">Roteiros</a></li>
					<li><a href="#">Ajuda</a></li>
					<li><a href="../home.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<form:form action="cadastrar" modelAttribute="roteiro" method="POST">
		<div id="main" class="container-fluid" style="margin-top: 50px">


			<div id="top" class="row">
				<div class="col-sm-3">
					<h2>Roteiro</h2>
				</div>
				<div class="col-sm-6">

					<form:hidden var="roteiroId" path="id" />
					<div class="input-group h2">
						<form:input path="nome" name="data[search]" class="form-control "
							id="search" type="text" placeholder="Nome do Roteiro" />
							<span
							class="input-group-btn">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>

				<div class="col-sm-3">
					<input type="submit" value="Cadastrar"
						class="btn btn-primary pull-right h2">
				</div>

			</div>
			<!-- /#top -->


			<hr />
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>NUMERO</th>
								<th>CEP DESTINO</th>
								<th>END DESTINO</th>
								<th class="actions">A��es</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="nf" items="${roteiro.nfs}">
								<tr>

									<td>${ nf.numero}</td>
									<td>${ nf.cepDestino}</td>
									<td>${ nf.endDestino}</td>
									<td><form:checkbox path="id" value="roteiroId" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<!-- /#list -->

			<div id="bottom" class="row">
				<div class="col-md-12" style="margin-bottom: 50px">
					<ul class="pagination">
						<li class="disabled"><a>&lt; Anterior</a></li>
						<li class="disabled"><a>1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="next"><a href="#" rel="next">Pr�ximo &gt;</a></li>
					</ul>
					<!-- /.pagination -->
				</div>
			</div>
			<!-- /#bottom -->
		</div>
		<!-- /#main -->

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