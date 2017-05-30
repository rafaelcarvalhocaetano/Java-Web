<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Meu JS -->
<script type="text/javascript" src="resources/javascript/efeitor.js"></script>

<!-- Meu css -->
<link rel="stylesheet" href="resources/css/estilo.css">

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>

<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>HOME</title>
</head>
<body>
	<div class="row" id="init">
		<div class="col s6 m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title">Ambiente de Acesso e Cadastros</span>
					<p>Bem vindo ao Ambiente de Acesso a Cadastro</p>
					<p>Ambiente onde o usuário testa nosso sistema através de cadastro que são armazenados no banco de dados MySql</p>
				</div>
				<div class="card-action">
				<center>
					<a class="waves-effect waves-light btn" href="cadastrar.jsp" name="cadastrar">Cadastrar</a>
					<a class="waves-effect waves-light btn" href="login.jsp" name="entrar">Entrar</a>
				</center>
				</div>
			</div>
		</div>
	</div>
</body>
</html>