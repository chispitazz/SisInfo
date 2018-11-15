<!doctype html>
<%@page import="aplicacionWeb.vo.Usuario"%>
<html>
<head>
<meta charset="utf-8">
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>

<%! int conectado = 0;%>

<header id="Menu">
		<ul class="botonesIzq">
            <li><a href="Index.jsp">Noticias</a></li>
          	<li><a href="Carteles.jsp">Carteles</a></li>
		  	<li><a href="#">Wiki</a></li>
            <% 

  
            if(request.getSession() != null && request.getSession().getAttribute("Usuario") != null){

            	conectado = ((Usuario) request.getSession().getAttribute("Usuario")).tipoConect();
				 switch (conectado){
				 case 3: 	out.print("<li><a href=\"#\">Ver Entregas</a></li>");
					break;
				 case 2:	out.print("<li><a href=\"#\">Entregar</a></li>");
	            	break;
	            default:
				}
            }

       
           	%>
 </ul>
        <ul class="last">
        <%
        	if(conectado >0 ){
        		out.print("<li><a href=\"Perfil.jsp\">Ver Perfil</a></li>");
        		out.print("<li><a href=\"UnLogin\">Desconectar</a></li>");
        	}else{
        		out.print("<li><a href=\"Acceso\">Acceder</a></li>");
        	}
        %>
          
        </ul>
	</header>
</body>
</html>
