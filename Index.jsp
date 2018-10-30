<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="aplicacionWeb.dao.NoticiaDAO" 
    import = "aplicacionWeb.vo.Noticia" 
    import="aplicacionWeb.vo.ListaNoticias" 
    import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SistemasInformacion</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/IndexStyle.css" rel="stylesheet" type="text/css">
</head>
</head>
<body>
<%! 
	//Declaración de variables globales
	ListaNoticias ultimasNoticias = null;
%>
<%
	
	try{
		NoticiaDAO nDAO = new NoticiaDAO();
		int i = 0;
		while(!nDAO.conectado() && i <20){
			nDAO.conectarDAO();
			i++;
		}
		if(i>=20){
			System.out.println("Error al conectar");
			
		}
	//	 ultimasNoticias = new ListaNoticias(nDAO.getListaNoticias());
	}catch(SQLException e){
		System.out.println ("ERROR AL CARGAR NOTICIAS\n" + e);
	}
	if(ultimasNoticias != null){
		int i = 0;
		for(Noticia n : ultimasNoticias.getnoticias()){
				out.println("<article  class=\"Noticia\"><img src=\"./css/imagenes/box-image1.gif\" alt=\"imagen noticia 1\">" 
			+ "<div> <h2> Noticia 1</h2><p> Esto es el texto de la noticia 1 resumido</p>"
			+ "</div></article>");
		}
	}
%>
</body>
</html>