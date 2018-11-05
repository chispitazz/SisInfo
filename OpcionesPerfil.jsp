<!doctype html>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    import="aplicacionWeb.vo.Profesor" %>
<html>
<head>
<meta charset="utf-8">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/IndexStyle.css" rel="stylesheet" type="text/css">
</head>

<%! int conectado = 0;%>

<div class="sidenav">
	
		<a href="EditarPerfil.html">Editar perfil</a>
		 <% 
            
            if(request.getSession().getAttribute("TipoConexion") != null){
            	conectado = (int) request.getSession().getAttribute("TipoConexion");
				 switch (conectado){
				 case 3: 	out.print("<a href=\"verEntregas.html\">Ver carteles entregados</a>");
				 			out.print("<a href=\"AddNoticia.html\">Publicar noticia</a>");
				 			/*out.print("<a href=\"RealizarEntrega.html\">Publicar cartel</a>");*/
				 			out.print("<a href=\"AddAlumno.html\">Añadir alumnos</a>");
				 			if(((Profesor) request.getSession().getAttribute("Profesor")).isAdministrador()){
				 				out.print("<a href=\"AddProfesor.html\">Añadir Profesor</a>");
				 			}
					break;
				 case 2:	/*out.print("<a href=\"verEntregas.html\">Ver carteles entregados</a>");*/
		 					out.print("<a href=\"RealizarEntrega.html\">Entregar trabajo</a>");
		 					/*out.print("<a href=\"AddNoticia.html\">Publicar noticia</a>");*/
		 					/*out.print("<a href=\"AddAlumno.html\">Añadir alumnos</a>");*/
 					break;
				 case 1:	out.print("<a href=\"#\">Ver Ranking</a>");
	            	break;
	            default:
	            		response.sendRedirect("Acceso");
				}
            }
            	%>

</div>	
</html>
