<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SmallRoad - Notas Fiscais</title>
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
	
	<div id="main" class="container-fluid" style="margin-top: 50px">

		<div id="top" class="row">
			<div class="col-sm-3">
				<h2>Notas Fiscais</h2>
			</div>
			<div class="col-sm-6">
				<form:form action="search" method="POST">
					<div class="input-group h2">
						<input name="procuraNumero" class="form-control" id="search"
							type="text" placeholder="Adicionar Notas Fiscais"> <span
							class="input-group-btn">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-plus"></span>
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
		</div>
		<!-- /#top -->


		<hr />
		<div id="list" class="row">

			<div class="table-responsive col-md-12">
				<table class="table table-striped ">
						<tr>
							<th>Numero</th>
							<th>Cep</th>
							<th>Endereço</th>
							<th>Data Entrega</th>
							<th>Ação</th>
						</tr>
					<tbody>
					
					<!-- cria um laco para printar os usuarios -->
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
						
					</tbody>
				</table>
			</div>

			<!-- Modal

			<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
				aria-labelledby="modalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Fechar">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="modalLabel">Excluir Usuário</h4>
						</div>
						<div class="modal-body">Deseja realmente excluir este
							usuario?</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="">Sim</button>
							</a>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">N&atilde;o</button>
						</div>
					</div>
				</div>
			</div>-->

		</div><!-- /#list -->

		<div id="bottom" class="row">
			<div class="col-md-12" style="margin-bottom: 60px">
				<ul class="pagination">
					<li class="disabled"><a>&lt; Anterior</a></li>
					<li class="disabled"><a>1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
				</ul>
				<!-- /.pagination -->
			</div>
		</div>
		<!-- /#bottom -->
	</div>
	
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<center><p style="color: #a8a8a8; margin-top: 15px;">SmallRoad - Todos Os Direitos Reservados - 2017</p></center>
	</nav><!-- footer -->
	
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>