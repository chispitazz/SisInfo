<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    session = "false"
    import="aplicacionWeb.dao.NoticiaDAO" 
    import = "aplicacionWeb.vo.Noticia" 
    import="aplicacionWeb.vo.ListaNoticias"
    import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SistemasInformacion</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/IndexStyle.css" rel="stylesheet" type="text/css">
</head>
</head>
<body>

<%! 
	//Declaración de variables globales

%>
<%
		System.out.println("Estoy en el JSP");
		ListaNoticias noticias = (ListaNoticias) request.getAttribute("Noticas");

		if(noticias != null){
		int i = 0;
		for(Noticia n : noticias.getnoticias()){
				out.println("<article  class=\"Noticia\"><img src=\"./css/imagenes/box-image1.gif\" alt=\"imagen noticia 1\">" 
			+ "<div> <h2>" + n.titulo() + "</h2><p>" + n.noticia() + "</p>"
			+ "</div></article>");
				System.out.println("<article  class=\"Noticia\"><img src=\"./css/imagenes/box-image1.gif\" alt=\"imagen noticia 1\">" 
						+ "<div> <h2> Noticia 1</h2><p> Esto es el texto de la noticia 1 resumido</p>"
						+ "</div></article>");
		
		}
	}
%>
</body>
</html>