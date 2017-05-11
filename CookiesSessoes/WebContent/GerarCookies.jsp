<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String nome = request.getParameter("nome");
	if(nome == null){
		nome = "";
	}
	String codifica = URLEncoder.encode(nome, "UTF-8");
	Cookie cookie= new Cookie("nomeDoUsuario", codifica);
	cookie.setVersion(0);
	cookie.setMaxAge(6);
	response.addCookie(cookie);
	

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies</title>
</head>
<body>

<a href="ExibirCookie.jsp">Veja Aqui o valor do cookie gerado</a>

</body>
</html>