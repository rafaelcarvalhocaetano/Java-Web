<%@page import="br.uninove.bean.CalculadoraBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Estilo do bootstrap -->
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css" />

	<!-- Meu estilo -->
	<link rel="stylesheet" type="text/css" href="resources/css/myStyle.css" />
	<!-- JavaScript do Bootstrap -->
	<script src="resources/js/bootstrap.min.js"></script>

	<!-- Mobile -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Respostas</title>
</head>
<body>
	<jsp:useBean id="bhaskara" scope="page" class="br.uninove.bean.CalculadoraBean" />
    
    <jsp:setProperty property="a" name="bhaskara" value='<%=request.getParameter("a")%>' />
    <jsp:setProperty property="b" name="bhaskara" value='<%=request.getParameter("b")%>' />
    <jsp:setProperty property="c" name="bhaskara" value='<%=request.getParameter("c")%>' />
    
       
       <div class="jumbotron">
  		<h3>Resposta da calculadora de Bhaskara <span class="label label-default"><%=request.getParameter("a")%>x² + <%=request.getParameter("b")%>x + <%=request.getParameter("c")%></span></h3>
		
  		<ul class="list-group">
		  <li class="list-group-item">Delta<span class="badge">  Delta: <% out.print(bhaskara.getDelta()); %> <br/></span></li>
		</ul>
		
		<ul class="list-group">
		  <li class="list-group-item">Raiz Positiva<span class="badge"><%= bhaskara.getRaizPositiva() %></span></li>
		</ul>
		
		<ul class="list-group">
		  <li class="list-group-item">Raiz Negativa<span class="badge"><%= bhaskara.getRaizNegativa() %></span></li>
		</ul>
		
	</div>

</body>
</html>