<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Authentication</title>
</head>
<body>
	<form method="POST" action="autentica.jsp">
	<center>
		<h1>Autenticação de usuário</h1>
		<h4>Usuário: </h4>
		<input type="text" name="usuario"/>
		<h4>Senha: </h4>
		<input type="password" name="senha"/>
		<input type="submit" value="login"/>
	</center>
	</form>

</body>
</html>