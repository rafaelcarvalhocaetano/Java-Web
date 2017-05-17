<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Meu JS -->
<script type="text/javascript" src="resources/javascript/efeito.js"></script>
<!-- Meu css -->
<link rel="stylesheet" href="resources/css/estilo.css">

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>

	<div class="row">
		<div class="col s12 m6">
			<div class="card blue-grey darken-1">

				<div class="card-content white-text">
					<div class="row">
						<form class="col s12">
							<div class="row">
								<div class="input-field col s6">
									<input id="first_name" type="text"
										class="validate"> <label for="first_name">First
										Name</label>
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
									<input id="email" type="text" class="validate"> <label
										for="email">Email</label>
								</div>
							</div>
						</form>
					</div>

				</div>
				<center>
				<div class="card-action">
					<a href="#">Sair</a> <a href="#">Cadastrar</a>
				</div>
				</center>
			</div>
		</div>
	</div>

</body>
</html>