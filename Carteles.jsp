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
		Cartel	c = (Cartel) request.getAttribute("Cartel");	
		//Pregunta p= c.getPregunta();
		//List<String> op= p.getOpciones();
		
		
	//	if(c != null){
			out.println("<main class=\"mainCarteles\">"+
					 "		<div class=\"InfoCartel\">"+
					 "			<h1>"+" c.getTitulo()" +"</h1>"+
					 "			<p>"+"c.getTexto()"+"</p>"+
					 "			<div class=\"reto\">"+
					 "				<h2>Reto</h2>"+
					 "				<p>"+" c.getReto()"+"</p>"+
					 "			</div>"+
					 "		</div>"+
					 "		<div class=\"Cuestionario\">"+
					 "			<h1> Cuestionario</h1>"+
					 "			<p> "+ "p.getQuestion()" +" <br> </p>"+
					 "			<div class = \"radio\">"+
					 "				<label>"+
					 "					<input type=\"radio\" name=\"option1\" id=\"optionsRadios1\" value=\"option1\">"
					 					+ "op.get(0)"	+
					 "				</label>"+
					 "			</div>"+
					 "			<div class = \"radio\">"+
					 "				<label>"+
					 "					<input type=\"radio\" name=\"option2\" id=\"optionsRadios2\" value=\"option2\">"+
										 "op.get(1)"+
					 "				</label>"+
					 "			</div>"+
					 "			<div class = \"radio\">"+
					 "				<label>"+
					 "					<input type=\"radio\" name=\"options3\" id=\"optionsRadios3\" value=\"option3\">"+
										 "op.get(2)"+
					 "				</label>"+
					 "			</div>"+
					 "			<div class = \"radio\">"+
					 "				<label>"+
					 "					<input type=\"radio\" name=\"options4\" id=\"optionsRadios4\" value=\"option4\">"+
										" op.get(3)"+
					 "				</label>"+
					 "			</div>"+
					 
					 "			<div class=\"CuestionarioRespuesta\">"+
					 "				<input type=\"text\" value=\"  Nick\"><br><br>"+
					 "				<input type=\"password\" value=\"contraseña\">"+
					 "				<button> Conéctate para contestar </button><br><br>"+
					 "				<button> Nuevo participante </button>"+
					 "			</div>"+
					 "				<div class=\"CuestionarioRespuesta\">"+
					 "				"+
					 "			</div>"+
					 "			<p>"+
					 "				Si te conectas entrarás en el ranking de puntuación"+
					 "			</p>"+
					 "			"+
					 "		"+
					 "		</div>"+
					 "		"+
					 "	</main>");
	//	}
		
		
	
%>


<%-- <%= expresión que genera un string %> --%>
<%-- <%@ Clase a importar%> --%>
<%-- Comentario JSP???? --%>
<!-- Aqui va el contenido del body -->
</body>
</html>