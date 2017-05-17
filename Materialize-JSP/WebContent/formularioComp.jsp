<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário</title>
</head>
<body>
	<div id="center" class="row">
		<form class="col s10">
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="Placeholder" id="first_name" type="text"
						class="validate"> <label for="first_name">Nome</label>
				</div>
				<div class="input-field col s6">
					<input id="last_name" type="text" class="validate"> <label
						for="last_name">Ultimo Nome</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="password" type="password" class="validate"> <label
						for="password">Senha</label>
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




	<div id="center" class="progress">
		<div class="determinate" style="width: 50%"></div>
	</div>



</body>
</html>