<%@page import="br.uninove.edu.CalculandoBhaskara"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/estilo.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
<jsp:useBean scope="page" id="cal" class="br.uninove.edu.CalculandoBhaskara"></jsp:useBean>

<jsp:setProperty property="a" name="cal" value='<%= request.getParameter("a") %>'/>
<jsp:setProperty property="b" name="cal" value='<%= request.getParameter("b") %>'/>
<jsp:setProperty property="c" name="cal" value='<%= request.getParameter("c") %>'/>

<div id="pos">
<div>
	<h1>Resposta da calculadora de Bhaskara</h1>
</div>
	<h4>Resposta de : <%=request.getParameter("a")%>x² <%=request.getParameter("b")%>x <%=request.getParameter("c")%></h4>
<div>
	<p>Delta: <% out.print(cal.getDelta()); %></p>
</div>
<div>
	<p>Raiz Positiva: <% out.print(cal.getRaizPositiva()); %></p>
</div>
<div>
	<p>Raiz Positiva: <% out.print(cal.getRaizNegativa()); %></p>
</div>
</div>
</body>
</html>