<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    session = "false"
    import="aplicacionWeb.dao.CartelDAO" 
    import = "aplicacionWeb.vo.Cartel" 
    import = "aplicacionWeb.vo.Pregunta" 
    import="java.sql.SQLException"
    import="java.util.*"
    import="javax.security.auth.message.callback.PrivateKeyCallback.Request" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cartel</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/CartelesStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<%@ include file="menuPral.jsp" %>
<%

		System.out.println("Estoy en el JSP cartel");


		Cartel	c = (Cartel) request.getAttribute("cartel");
		System.out.println("Cojo cartel");
		Pregunta p= c.getPregunta();
		List<String> op= p.getOpciones();
		
%>

<main class="mainCarteles">
		<div class="InfoCartel">
			<h1>Título del cartel</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			<div class="reto">
				<h2>Reto</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
		</div>
		<div class="Cuestionario">
			<h1> Cuestionario</h1>
			<p> Aquí se formularía la pregunta <br> </p>
			
			<div class = "radio">
				<label>
					<input type="radio" name="option1" id="optionsRadios1" value="option1">
					Esta sería la opción 1
				</label>
			</div>
			<div class = "radio">
				<label>
					<input type="radio" name="option2" id="optionsRadios2" value="option2">
					Esta sería la opción 2
				</label>
			</div>
			<div class = "radio">
				<label>
					<input type="radio" name="options3" id="optionsRadios3" value="option3">
					Esta sería la opción 3
				</label>
			</div>
			<div class = "radio">
				<label>
					<input type="radio" name="options4" id="optionsRadios4" value="option4">
					Esta sería la opción 4
				</label>
			</div>

			<div class="CuestionarioRespuesta">
				<input type="text" value="  Nick"><br><br>
				<input type="password" value="contraseña">
				<button> Conéctate para contestar </button><br><br>
				<button> Nuevo participante </button>
			</div>
				<div class="CuestionarioRespuesta">
				
			</div>
			<p>
				Si te conectas entrarás en el ranking de puntuación
			</p>
			
		
		</div>
		
	</main>
					
</body>
</html>