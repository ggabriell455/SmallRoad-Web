<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
	 <link href="${pageContext.request.contextPath}/resources/semantic/semantic.css" rel="stylesheet">
 	 <script href="${pageContext.request.contextPath}/resources/semantic/semantic.js"></script>
	<title>Smallroad Home</title>
</head>
<body>

<div class="menu" style="margin-bottom: 15px;">

          <div class="ui inverted segment">
              <div class="ui inverted secondary menu">

                  <label class="item"><h3>SmallRoad</h3></label>
                  <a href="../home.jsp" class="item">Início</a>
                  <a href="${pageContext.request.contextPath}/usuario/list" class="item">Manutenção de Usuários</a>
                  <a href="${pageContext.request.contextPath}/nf/list" class="item active">Manutenção de NF</a>
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


			<input type="button" value="Add Nf"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button ui green button"/>
				   
				   <br/>
				   <br/>
				   
				<form:form action="search" method="POST">
				 <div class="ui icon input">
					<i class="search icon"></i>
					<input type="text" name="procuraNumero" placeholder="Procurar"/>
				 </div>
				 
					<input type="submit" value="Procurar" class="add-button ui primary button" />
				</form:form>
			
			<table class="ui celled table">
				<thead>
					<tr>
						<th width="100">Numero</th>
						<th width="200">Cep</th>
						<th width="800">Endereço</th>
						<th width="300">Data Entrega</th>
						<th width="200">Ação</th>
					</tr>
				</thead>
				
				<!-- cria um laço para printar os usuarios -->
				<c:forEach var="tempNf" items="${nfs}">
					<c:url var="updateLink" value="/nf/ShowFormForUpdate">
						<c:param name="nfNumero" value="${tempNf.numero}" />
					</c:url>					

					<!-- constroi um link de delete com a id do usuario -->
					<c:url var="deleteLink" value="/nf/delete">
						<c:param name="nfNumero" value="${tempNf.numero}" />
					</c:url>	
								
					<tr>
						<td> ${tempNf.numero} </td>
						<td> ${tempNf.cepDestino} </td>
						<td> ${tempNf.endDestino} </td>
						<td> ${tempNf.entregue} </td>
						<td> 
						<center>
							<div class="ui buttons">
							<a href="${updateLink}"  class="ui blue basic button">Alterar</a>
							<a href="${deleteLink}"  class="ui red basic button">Deletar</a>
							</div>
						</center>
						</td>
					</tr>
				</c:forEach>
			</table>


	


</body>
</html>