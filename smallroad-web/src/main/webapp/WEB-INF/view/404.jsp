<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link href="${pageContext.request.contextPath}/resources/css/error-page.css" rel="stylesheet">

<title></title>
</head>

<body>

 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
   <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
     <span class="sr-only">Toggle navigation</span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand"><span class="glyphicon glyphicon-road" aria-hidden="true" style="color:#FFF;"></span></a>
    <a class="navbar-brand" href="#">SmallROAD</a>
   </div>
   <div id="navbar" class="navbar-collapse collapse">
    <ul class="nav navbar-nav navbar-right">
     <li><a href="../home.jsp">Home</a></li>
     <li><a href="${pageContext.request.contextPath}/usuario/list">Usuários</a></li>
     <li><a href="${pageContext.request.contextPath}/nf/list">Notas Fiscais</a></li>
     <li><a href="${pageContext.request.contextPath}/roteiro/list">Roteiros</a></li>
     <li><a href="#">Perfil</a></li>
     <li><a href="#">Ajuda</a></li>
    </ul>
   </div>
  </div>
 </nav>

    <!-- Error Page -->
            <div class="error" style="margin-top:2%;">
                <div class="container-floud">
                    <div class="col-xs-12 ground-color text-center">
                        <div class="container-error-404">
                            <div class="clip"><div class="shadow"><span class="digit thirdDigit"></span></div></div>
                            <div class="clip"><div class="shadow"><span class="digit secondDigit"></span></div></div>
                            <div class="clip"><div class="shadow"><span class="digit firstDigit"></span></div></div>
                        </div>
                        <h2 class="h1">Desculpe, Página não Encontrada.</h2>
                    </div>
                </div>
            </div>
        <!-- Error Page -->
        <script src="${pageContext.request.contextPath}/resources/js/error-page.js"></script>
        
      <nav class="navbar navbar-inverse navbar-fixed-bottom">
		<center><p style="color: #a8a8a8; margin-top: 15px;">SmallRoad - Todos Os Direitos Reservados - 2017</p></center>
	</nav><!-- footer -->

 <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>

</html>