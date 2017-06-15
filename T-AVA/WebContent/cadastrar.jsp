<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">

<!-- Meu JS -->
<script type="text/javascript" src="resources/javascript/efeitor.js"></script>
<!-- Meu css -->
<link rel="stylesheet" href="resources/css/estilo.css">

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>

<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do" rel="stylesheet">

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html charset=utf-8">

<title>Cadastro</title>
</head>
<body>
	<div class="row" id="painel">
		<div class="col m5.5">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<div class="row">
						<form class="col s12" method="post" action="CrudCadastro">
							<div class="row">
								<div class="input-field col s12">
									<input id="nome" type="text" class="validate" name="nome"> <label>Nome</label>
								</div>
							</div>	
							<div class="row">
								<div class="input-field col s12">
									<input id="senha" type="password" class="validate" name="senha">
									<label >Senha</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input  id="csenha" type="password" class="validate" name="ra">
									<label>RA</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input id="email" type="text" class="validate" name="email"> <label>Email</label>
								</div>
							</div>
							<div class="card-action">	
							<center>			
								<a class="waves-effect waves-light btn" href="index.jsp">Voltar</a>
								<input type="submit" class="waves-light btn" value="Confirmar"/>
							</center>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>