<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
	<title>Smallroad Home</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<h2>SmallROAD</h2>

		</div>
		<div class="usuario_logado">
			

		</div>




	</div>
		<div class="container">
				<div class="nav">
					
					<ul class="lista_nav">
					 	<li>
						 	<input type="button" value="Manut. Usuario"
					   		onclick="window.location.href='usuario/list'"
					   		class="botao"/>
					   </li> 
					    <br>
					 	<li>
						 	<input type="button" value="Manut. Nfs"
					   		onclick="window.location.href='nf/list'"
					   		class="botao"/>
					   </li>
					   <br>
						 	<li><input type="button" value="Manut. Roteiro"
					   		onclick="window.location.href='roteiro/list'"
					   		class="botao"/>
				   		</li>
					</ul>



				</div>
				<div class="processamento">



			    </div>
				


		</div>



	</div>

	<div class="footer">

	

	</div>
	


</body>
</html>