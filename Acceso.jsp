<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Acceder</title>
<link href="css/AccesoStyle.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<%@ include file="menuPral.jsp" %>

	<form action="Login" method="post">
	 <div class="columnas">
	 <div class="Centrado"></div>
	  <div class="Cabeza"><h1>Introduzca cuenta de usuario</h1>
	  <div class="Acceso">
		<section class="labes">
			<label for="correoAcceso" class="labels">Correo electrónico:</label>
			<label for="passwordAcceso" class="labels">Contraseña:</label>
		  </section>
		<section class="inputs">
			<input type="text" name="usuario" id="correoAcceso">
			<input type="password" name="password" id="passwordAcceso">
      	  </section>
        </div>
        <div class="subi">
        <% if (request.getAttribute("IntentosConnect") == (Object) 1){
        	 out.println("<p> No se ha podido verificar usuario. <br>Error en correo o contraseÃ±a</p>"); 	
      	  }
        else if (request.getAttribute("IntentosConnect") == (Object) 2) {
        	out.println("<p> Por favor, identificate para acceder </p>");
        }
             
        %>
         <input type="submit" name="submit" id="submit" value="Acceder">
        </div>
       </div>
	</div>
</form>
</body>
</html>
