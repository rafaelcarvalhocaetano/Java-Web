<%@page import="br.com.agenda.model.Contato"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda de Contatos</title>
</head>
<body>

<form action="">

Nome: <input type="text" name="nome">
<br>
Telefone: <input type="text" name="telefone">
<br>
Celular: <input type="text" name="celular">
<br>
Data de Nascimento: <input type="text" name="data">
<br>
Endereço: <input type="text" name="endereco">
<br>
Cidade: <input type="text" name="cidade">
<br>
Estado: <input type="text" name="estado">
<br>
<input type="submit" value="Salvar">
</form>

</body>
</html>