<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- referencia o css -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista de Usuarios Cadstrados</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!--  botao: Add Usuario -->
		
			<input type="button" value="Add Usuario"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<!--  procura --->
			<form:form action="search" method="POST">
				Procurar Usuário: <input type="text" name="procuraNome" />
				
				<input type="submit" value="Procurar" class="add-button" />
			</form:form>
		
			<!--  tabela -->
		
			<table>
				<tr>
					<th>Nome</th>
					<th>Senha</th>
					<th>Email</th>
					<th>Ação</th>
				</tr>
				
				<!-- cria um laço para printar os usuarios -->
				<c:forEach var="tempUsuario" items="${usuarios}">
				
					<!-- constroi um link de update com a id do usuario -->
					<c:url var="updateLink" value="/usuario/showFormForUpdate">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>					

					<!-- constroi um link de delete com a id do usuario -->
					<c:url var="deleteLink" value="/usuario/delete">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempUsuario.nome} </td>
						<td> ${tempUsuario.senha} </td>
						<td> ${tempUsuario.email} </td>
						
						<td>
							<!-- mostra o link de update e delete -->
							<a href="${updateLink}">Atualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Tem certeza que deseja deletar o usuário?'))) return false">Deletar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>