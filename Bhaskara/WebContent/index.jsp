<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt_br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<!-- Estilo do bootstrap -->
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css" />
	
	<!-- Meu estilo -->
	<link rel="stylesheet" type="text/css" href="resources/css/myStyle.css" />
	<!-- JavaScript do Bootstrap -->
	<script src="resources/js/bootstrap.min.js"></script>
	
	<!-- Mobile -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
 
	<title>Calculadora de Bhaskara</title>
</head>
<body>

	<form method="post" action="bhaskara.jsp" class="navbar-form navbar-left" role="search" id="form">
	
		<div class="page-header" >
	 		<h3 id="a">Calculadora de Bhaskara</h3>
		</div>
		
		<div class="input-group">
	  		<span class="input-group-addon" id="sizing-addon2">A</span>
	  		<input type="text" name="a" id="valorA" class="form-control" placeholder="Informe o valor de 'A' " >
		</div>
		<div class="input-group">
	  		<span class="input-group-addon" id="sizing-addon2">B</span>
	  		<input type="text" name="b" id="valorB" class="form-control" placeholder="Informe o valor de 'B' " >
		</div>
		<div class="input-group">
	  		<span class="input-group-addon" id="sizing-addon2">C</span>
	  		<input type="text" name="c" id="valorC" class="form-control" placeholder="Informe o valor de 'C' " >
		</div>
		
		<button class="btn btn-primary" type="submit" value="Calcular">Calcular</button>	
	</form>

</body>
</html>