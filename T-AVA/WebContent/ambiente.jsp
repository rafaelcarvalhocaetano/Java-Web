<%@page import="java.util.ArrayList"%>
<%@page import="servlet.Cad"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="factory.ConexaoFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="domain.Cadastro"%>
<%@page import="java.util.List"%>
<%@page import="dao.CadastroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>AMBIENTE</title>
</head>
<%
	String ra = (String) request.getSession().getAttribute("rah");

	CadastroDAO dao = new CadastroDAO();
	Cadastro c = new Cadastro();
	c = dao.buscarCodigo(ra);
%>

<body>
	<div id="nava">
		<i class="md-36 material-icons">person_pin</i> <span> <%=c.getNome()%>
		</span> <i class="material-icons">info_outline</i> <span> <%=c.getRa()%>
		</span>
	</div>
	<div id="botao">
		<center>
			<a class="waves-effect waves-light btn" href="login.jsp">SAIR</a>
		</center>
	</div>
</body>
</html>