<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restrita</title>
</head>
<body>
	<%
		boolean aut = false;
		aut = Boolean.parseBoolean(session.getAttribute("autenticacao").toString());
		
		if(aut){
			out.print("Você Não pode estar aqui");
		}else{
			out.print("Você pode estar aqui");
		}
	%>
</body>
</html>