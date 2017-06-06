<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
<title>Smallroad Home</title>
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
				<a class="navbar-brand" href="#">SmallROAD</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../home.jsp">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/usuario/list">Usu�rios</a></li>
					<li><a href="${pageContext.request.contextPath}/nf/list">Notas
							Fiscais</a></li>
					<li><a href="${pageContext.request.contextPath}/roteiro/list">Roteiros</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="main" class="container-fluid" style="margin-top: 50px">

		<div id="top" class="row">

			<div class="col-sm-3">
				<h2>Notas Fiscais</h2>
			</div>

			<div class="col-sm-6">

				<form:form action="search" method="POST">
					<div class="input-group h2">
						<input name="procuraNumero" class="form-control" id="search"
							type="text" placeholder="Pesquisar Notas Fiscais"> <span
							class="input-group-btn">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form:form>

			</div>


			<div class="col-sm-3">
					<input type="button" value="Nova Nota Fiscal"
						onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button btn btn-primary pull-right h2" />
			</div>
		</div><!-- /#top -->

		<hr/>
		<div id="list" class="row">

		<div class="table-responsive col-md-12">

			<table class="table table-striped" cellspacing="0" cellpadding="0">
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
						<td>${tempNf.numero}</td>
						<td>${tempNf.cepDestino}</td>
						<td>${tempNf.endDestino}</td>
						<td>${tempNf.entregue}</td>
						<td>
						<a class="btn btn-warning btn-xs" href="${updateLink}">UPDATE</a> 
						<a class="btn btn-danger btn-xs" href="${deleteLink}">DELETE</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div><!-- /#list -->

	<div id="bottom" class="row">
			<div class="col-md-12">
				<ul class="pagination">
					<li class="disabled"><a>&lt; Anterior</a></li>
					<li class="disabled"><a>1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#" rel="next">Pr�ximo &gt;</a></li>
				</ul>
				<!-- /.pagination -->
			</div>
		</div><!-- /#bottom -->

</div><!-- /#main -->

</body>
</html>