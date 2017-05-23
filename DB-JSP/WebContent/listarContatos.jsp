<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.agenda.model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.agenda.dao.AgendaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<%
		AgendaDAO dao = new AgendaDAO();

		List<Contato> contatos = dao.listarDados();
	%>
	<table border="1" cellpadding="10">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Telefone</th>
			<th>Celular</th>
			<th>Data de Nascimento</th>
			<th>Endereço</th>
			<th>Cidade</th>
			<th>Estado</th>
		</tr>
		<%
			for(Contato c: contatos){
				
				String fdata = new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento());
		%>
		<tr>
			<td><%= c.getCodigo() %></td>
			<td><%= c.getNome() %></td>
			<td><%= c.getTelefone() %></td>
			<td><%= c.getCelular() %></td>
			<td><%= fdata %></td>
			<td><%= c.getEndereco() %></td>
			<td><%= c.getCidade() %></td>
			<td><%= c.getEstado() %></td>
		</tr>
		
		<%  
			}
		%>

	</table>

</body>
</html>