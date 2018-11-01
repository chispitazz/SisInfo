<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Perfil</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/PerfilStyle.css" rel="stylesheet" type="text/css">
</head>

<body>
<%@ include file="menuPral.jsp" %>


<main class="mainPerfil">
<div class="sidenav">
	
		<a href="EditarPerfil.html">Editar perfil</a>
		<a href="verEntregas.html">Ver carteles entregados</a>
		<a href="AddNoticia.html">Publicar noticia</a>
		<a href="RealizarEntrega.html">Publicar cartel</a>
		<a href="AddAlumno.html">Añadir alumnos</a>
	
</div>	
<div class="content">
	<section class="imagenContent" >
		<img src="./css/imagenes/perfil.png" alt="Foto de Perfil" width="100" height="100">
	</section>
	
	<div class="datosContent">
		<h2>Nombre Apellidos Profesor</h2>
		<br>
		<h3>correoeletronico@dominio.es</h3>
		<br>
		<h3> Departamento</h3>
		<br>
		<h3>Despacho</h3>
		<br>
		<h3>Sitio web/redes sociales</h3>		
	</div>
</div>

</main>			


</body>
</html>
