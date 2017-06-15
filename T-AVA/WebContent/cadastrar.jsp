<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html charset=utf-8">

<title>Cadastro</title>
</head>
<body>
	<center style="margin-top: 10%;">
		<form method="post" action="Cad">

			NOME: 
			<br>
			<input id="nome" type="text" class="validate" name="nome">
			<br>
			SENHA:
			<br>
			<input id="senha" type="password" class="validate" name="senha">
			<br>
			RA:
			<br>
			<input id="csenha" type="password" class="validate" name="ra">
			<br>
			EMAIL:
			<br>
			<input id="email" type="text" class="validate" name="email">
			<br>

			<div class="card-action">
			<br>

				<a class="waves-effect waves-light btn" href="index.jsp"><button>VOLTAR</button></a>
				<input type="submit" class="waves-light btn" value="CONFIRMAR" />

			</div>
		</form>
	</center>
</body>
</html>