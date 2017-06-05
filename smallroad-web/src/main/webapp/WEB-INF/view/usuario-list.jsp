<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>SmallROAD - Usuario</title>

 <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/resources/semantic/semantic.css" rel="stylesheet">
 <script src="${pageContext.request.contextPath}/resources/semantic/semantic.js"></script>
</head>
<body>
 
 <div class="menu">

          <div class="ui inverted segment">
              <div class="ui inverted secondary menu">

                  <label class="item"><h3>SmallRoad</h3></label>
                  <a href="../home.jsp" class="item">Início</a>
                  <a href="${pageContext.request.contextPath}/usuario/list" class="item active">Manutenção de Usuários</a>
                  <a href="${pageContext.request.contextPath}/nf/list" class="item">Manutenção de NF</a>
                  <a href="${pageContext.request.contextPath}/roteiro/list" class="item">Manutenção de Roteiros</a>
				  <a href="#" class="item">Ajuda</a>				  
                  <div class="right menu">

                      <a class="ui item">
                           <i class="sign out icon"></i>
                           Logout
                      </a>
                  
                  </div>

               </div>

          </div>

</div><!-- menu -->

<br/>
<br/>
 
 	<div id="top" class="row">

			<form:form action="search" method="POST">
			
				<div class="ui icon input" style="float: left; margin-left: 32%;">
					<i class="search icon"></i>
					<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Usuarios">
				</div>
				
			</form:form>
			
			<button onclick="location.href='showFormForAdd'" class="ui primary button" style="margin-left: 52px;">Novo Usuário</button>
		 
<br/>
<br/>
<br/>
<br/>

 	<div id="list">
 	
		<table class="ui celled table">
			<thead>
				<tr>
					<th width="100">ID</th>
					<th width="400">Nome</th>
					<th width="200">Perfil</th>
					<th width="300">E-mail</th>
					<th width="200">Data Cadastro</th>
					<th class="actions" width="280">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempUsuario" items="${usuarios}">
					<c:url var="deleteLink" value="/usuario/delete">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>
					
					<c:url var="updateLink" value="/usuario/showFormForUpdate">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>
					
					<c:url var="viewLink" value="/usuario/showFormForView">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>
					
					
					<tr>
						<td>${tempUsuario.id}</td>
						<td>${tempUsuario.nome}</td>
						<td>${tempUsuario.perfil}</td>
						<td>${tempUsuario.email}</td>
						<td>29/05/2017</td>
						<td class="actions">
						<div class="ui buttons">
							<a class="ui green basic button" href="${viewLink}">Visualizar</a>
							<a class="ui blue basic button" href="${updateLink}">Editar</a>
							<a class="ui red basic button" href="${deleteLink}" class="btn btn-danger btn-xs"  onclick="if (!(confirm('Tem certeza que deseja Excluir o usuário?'))) return false">Excluir</a>
						</div>
						</td>
					</tr>
			
				</c:forEach>
			</tbody>
			
			<tfoot>
    <tr><th colspan="6">
      <div class="ui left floated pagination menu">
        <a class="icon item">
          <i class="left chevron icon"></i>
        </a>
        <a class="item">1</a>
        <a class="item">2</a>
        <a class="item">3</a>
        <a class="item">4</a>
        <a class="icon item">
          <i class="right chevron icon"></i>
        </a>
      </div>
    </th>
  </tr>
  </tfoot>
			
		</table>
	</div>
	
		<!-- Modal -->
		
			<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="modalLabel">Excluir Usuário</h4>
			      </div>
			      <div class="modal-body">
			        Deseja realmente excluir este usuario?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" onclick="">Sim</button></a>
					<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
			      </div>
			    </div>
			  </div>
			</div>
		
	</div> <!-- /#list -->
	



 <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>