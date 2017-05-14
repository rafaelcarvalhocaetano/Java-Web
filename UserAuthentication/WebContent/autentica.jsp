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
	<jsp:setProperty value="<%= request.getParameter("usuario") %>" name="autenticacao" property="usuario"/>
	<jsp:setProperty value="<%= request.getParameter("senha") %>" name="autenticacao" property="usuario"/>

</center>
<%
	if(autenticacao.autentica()){
		session.setAttribute("usuario ", request.getParameter("usuario"));
		session.setAttribute("autenticado", true);
	}else{
		session.setAttribute("autenticacao", false);
	}
%>
<a href="restrita.jsp">Area restrita</a>


</body>
</html>