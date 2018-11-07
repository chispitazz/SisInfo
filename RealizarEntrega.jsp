<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "aplicacionWeb.dao.CartelDAO"
    import = "aplicacionWeb.vo.Cartel"
    import="java.sql.SQLException"
    import="javax.security.auth.message.callback.PrivateKeyCallback.Request"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Entregar</title>
<link href="css/RealizarEntrega.css" rel="stylesheet" type="text/css">
<link href="./css/style.css" rel="stylesheet" type="text/css">

</head>

<body> 
 	<%@ include file="menuPral.jsp" %>
	
		<h1>Entrega</h1>
	<form id = "NuevoCartel" action = "Entregar" method="post">
		<h2>Título</h2> <textarea name = "title" id="titulo"></textarea><br>
		<h2>Información</h2> <textarea name = "information" id="info"></textarea><br>
		<h2>Pregunta</h2> <textarea name = "quest" id="pregunta"></textarea><br><br>
		<!--<h2>Opciones</h2> <textarea id="opciones" placeholder = "Opción1;Opción2;Opción3;Opción4"></textarea><br><br>-->
		<h2>Opciones</h2>
			Marque aquellas opciones que sean la respuesta correcta. <br>
			<input type = "text" name = "opt1" id = "opcion1" placeholder = "Opción 1" size = 100> 
				<input type = "checkbox" name = "corr1" id = "correcta"> <br>
			<input type = "text" name = "opt2" id = "opcion2" placeholder = "Opción 2" size = 100> 
				<input type = "checkbox" name = "corr2" id = "correcta"> <br>
			<input type = "text" name = "opt3" id = "opcion3" placeholder = "Opción 3" size = 100> 
				<input type = "checkbox" name = "corr3" id = "correcta"> <br>
			<input type = "text" name = "opt4" id = "opcion4" placeholder = "Opción 4" size = 100> 
				<input type = "checkbox" name = "corr4" id = "correcta"> <br>
		<h2>Reto</h2> <textarea name = "deal" id="reto"></textarea><br><br>
		<div class = "Error">
		<%if ( request.getAttribute("TipoError") == (Object) 1) {
			out.println("<p> Faltan campos por rellenar. <br> Por favor, revise TITULO </p>");	
		}
		else if (request.getAttribute("TipoError") == (Object) 2 ) {
			out.println("<p> Faltan campos por rellenar. <br> Por favor, revise INFORMACION </p>");
		}
		else if (request.getAttribute("TipoError") == (Object) 3) {
			out.println("<p> Faltan campos por rellenar. <br> Por favor, revise PREGUNTA </p>");
		}
		else if (request.getAttribute("TipoError") == (Object) 4) {
			out.println("<p> Faltan campos por rellenar. <br> Por favor, revise OPCIONES </p>");
		}
		else if (request.getAttribute("TipoError") == (Object) 5){
			out.println("<p> Faltan campos por rellenar. <br> Por favor, revise RETO </p>");
		}
             
        %>
        </div>
		<input type="submit" name = "confirmarEntrega" id = "confirmarEntrega" value="Entregar" form = "NuevoCartel">
		<input type="button" name = "cancelarEntrega" id = "cancelarEntrega" value="Cancelar" form = "NuevoCartel"> 
	</form>
</body>
</html>