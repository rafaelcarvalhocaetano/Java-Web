<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String nomeCookie = "nomeDoUsuario";
	Cookie cookies[] = request.getCookies();
	Cookie cookieLocal = null;
	
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals(nomeCookie)){
				cookieLocal = cookies[i];
				break;				
		}
	}
}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exibindo o Cookie</title>
</head>
<body>
	<%
	
	if(cookieLocal == null){
		out.println("Não foi encontrado nenhuma coockie");
	}else{
		String valor = URLDecoder.decode(cookieLocal.getValue(), "UTF-8");
		out.println("O valor da cookie é: "+valor);
	}
	
	%>
</body>
</html>