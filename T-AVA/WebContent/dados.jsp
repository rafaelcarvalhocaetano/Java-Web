<%@page import="java.util.List"%>
<%@page import="br.com.uninove.dao.CadastroDAO"%>
<%@page import="br.com.uninove.domain.Cadastro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!-- Meu JS -->
<script type="text/javascript" src="resources/javascript/efeitor.js" ></script>

<!-- Meu css -->
<link rel="stylesheet" href="resources/css/dados.css">

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>DADOS</title>
</head>
<body>
<%
		session.setAttribute("info1", request.getParameter("nome"));
		session.setAttribute("info2", request.getParameter("ra"));
		session.setAttribute("info3", request.getParameter("email"));

		String i1 = String.valueOf(session.getAttribute("info1"));
		String i2 = String.valueOf(session.getAttribute("info2"));
		String i3 = String.valueOf(session.getAttribute("info3"));
		
%>
	<div id="dados" class="row offset-s9">
		<div class="col m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">

					<form method="post">

						<div class="row">
							<p>
								NOME:
								<%=i1%></p>
						</div>
						<div class="row">
							<p>
								RA:
								<%=i2%></p>
						</div>
						<div class="row">
							<p>
								EMAIL:
								<%=i3%></p>
						</div>
						<div class="card-action">
							<center>
								<a class="waves-effect waves-light btn" href="login.jsp">Confirmar</a>
							</center>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>