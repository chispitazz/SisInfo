<!doctype html>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    session = "false"
    import="aplicacionWeb.dao.NoticiaDAO" 
    import = "aplicacionWeb.vo.*"
    import="java.sql.SQLException" %>
<html>
<head>
<meta charset="utf-8">
<title>Perfil</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/PerfilStyle.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:include page="menuPral.jsp" flush="true"/>

<%! int conectado = 0;
	Usuario u;
%>

<% if(request.getSession().getAttribute("TipoConexion") != null){
            	conectado = (int) request.getSession().getAttribute("TipoConexion");
            	switch(conectado){
	        		case 3: u = (Usuario) request.getSession().getAttribute("Profesor");
	        			break;
	        		case 2:  u = (Usuario) request.getSession().getAttribute("Alumno");
	        			break;
	        		case 1: u = (Usuario) request.getSession().getAttribute("Anonimo");
	        			break;
	        		default:
            	}
            	
}%>
<main class="mainPerfil">
<jsp:include page="OpcionesPerfil.jsp" flush="true"/>
<div class="content">
	<section class="imagenContent" >
		<img src="./css/imagenes/perfil.png" alt="Foto de Perfil" width="100" height="100">
	</section>

	<div class="datosContent">
		<h2><%=u.getNombre() %></h2>
		<br>
		<h3><%=u.getCorreo() %></h3>
		<br>
		
		<%switch(conectado){
		case 3: 
			out.println("<h3>" + ((Profesor) u).getDepartamento() + "</h3><br>" + 
					"<h3>" + ((Profesor) u).getDespacho() +"</h3><br>" +"<h3><a>" + ((Profesor) u).getSitioWeb() +"</a></h3><br>");
			break;
		case 2: 
			out.println("<h3>" + ((Alumno) u).getCarrera() + "\t\t" + ((Alumno) u).getAnyoMatricula() + "</h3><br>" + 
					"<h3>Grupo de trabajo: " + ((Alumno) u).getGrupo()+ "</h3><br>");
			break;
		case 1:
			out.println("<h3>" + ((Anonimo) u).getOcupacion() + "</h3><br>" + "<h3>Puntuación: " + ((Anonimo) u).getPuntos() + "</h3><br>");
			break;
		}
		
		%>
	</div>

</div>

</main>			


</body>
</html>
