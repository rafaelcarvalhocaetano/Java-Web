<%@page import="java.util.List"%>
<%@page import="dao.CadastroDAO"%>
<%@page import="domain.Cadastro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

<center>
<form method="post">
<br>
NOME: <%=i1%>
<br>
RA:	<%=i2%>
<br>
EMAIL:<%=i3%>
<br>
<br>
<a class="waves-effect waves-light btn" href="login.jsp"><button>Confirmar</button></a>
</form>
</center>
</body>
</html>