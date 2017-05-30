<%@page import="javax.websocket.Session"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.List"%>
<%@page import="br.com.uninove.domain.Cadastro"%>
<%@page import="br.com.uninove.dao.CadastroDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="br.com.uninove.factory.ConexaoFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>

<!-- Meu JS -->
<script type="text/javascript" src="resources/javascript/efeitor.js"></script>

<!-- Meu CSS -->
<link rel="stylesheet" href="resources/css/dados.css">
<!-- JQuery -->

<!-- Compiled and minified CSS -->
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>LOGIN</title>
</head>
<body>
	<div id="dados" class="row offset-s9">
		<div class="col m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<form method="post" action="Verificando">
						<center>
							<p>LOGIN</p>
						</center>
						<div class="row">
							<div class="input-field col s12">
								<input type="text" class="validate" name="ra">
								 <label	id="senha">RA</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input type="password" class="validate" name="senha"> <label>Senha</label>
							</div>
						</div>
						<div class="card-action">
							<center>
								<input type="submit" class="waves-light btn" value="Entrar" />
							</center>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>