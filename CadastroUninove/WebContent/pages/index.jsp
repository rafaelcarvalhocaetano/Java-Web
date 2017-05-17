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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Cadastro</title>
</head>
<body>
	<div class="row" id="card">
		<div class="col m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<div class="row">
						<form class="col s12">
							<div class="row">
								<div class="input-field col s6">
									<input id="first_name" type="text" class="validate"> <label
										for="first_name">First Name</label>
								</div>
								<div class="input-field col s6">
									<input id="last_name" type="text" class="validate"> <label
										for="last_name">Last Name</label>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<input id="password" type="password" class="validate">
									<label for="password">Password</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input id="password" type="password" class="validate">
									<label for="password">Confirmação de Password</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input id="email" type="text" class="validate"> <label
										for="email">Email</label>
								</div>
							</div>
						</form>
					</div>
				</div>
				<center>
					<div class="card-action">					
					<a class="waves-effect waves-light btn-large"><i class="material-icons left">perm_identity</i>Cadastrar</a>

					<a class="waves-effect waves-light btn-large"><i class="material-icons left"></i>Entrar</a>
					</div>
				</center>
			</div>
		</div>
	</div>
	<div>
		<img id="figura1" alt="imagem" src="uni.png"> <img id="figura2"
			alt="imagem" src="uni.png">
	</div>
	
</body>
</html>