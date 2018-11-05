<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    session = "false"
    import="aplicacionWeb.dao.AlumnoDAO" 
    import = "aplicacionWeb.vo.Alumno" 
    import="aplicacionWeb.vo.ListaNoticias"
    import="java.sql.SQLException"
    import="javax.security.auth.message.callback.PrivateKeyCallback.Request" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Alumno</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/PerfilStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file= "menuPral.jsp" %>
<%!  Alumno a; %>
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
		<br>
		<button>Añadir foto</button> 
	</section>
	<div class="datosContent">
		<form id="formNombre"  method="post">
		  <input type="text" value="Nombre Apellidos Alumno">
	  	</form>
		<br>
		<form id="formCorreo"  method="post">
		  <input type="text" value="NIA@unizar.es">
	  	</form>
		<br>
		<form id="formGrupo"  method="post">
		  <input type="text" value="Grupo">
	  	</form>
		<br>
		<form id="formNIA"  method="post">
		  <input type="text" value="NIA">
	  	</form>
		<br>
	  	<button>Guardar cambios</button> <button>Cancelar</button>
	</div>
</div>
</main>			


<%-- <%= expresión que genera un string %> --%>
<%-- <%@ Clase a importar%> --%>
<%-- Comentario JSP???? --%>
<!-- Aqui va el contenido del body -->
</body>
</html>