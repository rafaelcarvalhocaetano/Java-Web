<%@page import="javax.websocket.Session"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.List"%>
<%@page import="domain.Cadastro"%>
<%@page import="dao.CadastroDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="factory.ConexaoFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Meu JS -->
<script type="text/javascript" src="resources/javascript/efeitor.js"></script>

<!-- Meu CSS -->
<link rel="stylesheet" href="resources/css/dados.css">
<!-- JQuery -->


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>LOGIN</title>
</head>
<body>
	
		<form>
			<center>
				<p>LOGIN</p>
			
			<div>
				
					RA: <input type="text" name="ra">
				
			
					SENHA: <input type="password" class="validate" name="senha">
			
			</div>
			<div>
				<center>
					<input type="submit" value="Entrar" />
				</center>
			</div>
			</center>
		</form>

</body>
</html>