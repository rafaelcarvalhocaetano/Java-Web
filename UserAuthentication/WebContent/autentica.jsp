<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autenticação</title>
</head>
<body>
<center>
	<jsp:useBean scope="page" id="autenticacao" class="br.com.uninove.Autenticacao"/>
	<jsp:setProperty value='<%= request.getParameter("usuario") %>' name="autenticacao" property="usuario"/>
	<jsp:setProperty value='<%= request.getParameter("senha") %>' name="autenticacao" property="senha"/>

</center>
<%
	if(autenticacao.autenticar()){
		session.setAttribute("usuario ", request.getParameter("usuario"));
		session.setAttribute("autenticado", true);
		out.print("<h3> Usuário autenticado </h3>");
	}else{
		session.setAttribute("autenticacao", false);
		out.print("<h3> Usuário Não autenticado </h3>");
	}
%>
<a href="restrita.jsp">Area restrita</a>


</body>
</html>