<%@page import="br.com.uninove.domain.Cadastro"%>
<%@page import="java.util.List"%>
<%@page import="br.com.uninove.dao.CadastroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>teste</title>
</head>
<body>

	<%
	CadastroDAO dao = new CadastroDAO();
	List<Cadastro> cadastros = dao.listar();
		
%>
	<%
			for(Cadastro c: cadastros){
				
			
	%>
		<h3><%= c.getId() %></h3>
		<h3><%= c.getNome() %></h3>
		<h3><%= c.getRa() %></h3>
		<h3><%= c.getSenha() %></h3>
		<h3><%= c.getEmail() %></h3>	
		
		
	<%
			}
	%>

</body>
</html>