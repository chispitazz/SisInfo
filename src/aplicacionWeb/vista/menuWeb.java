package aplicacionWeb.vista;

public class menuWeb {

	int tipoConect = 0; // 0 = sin loggin, 1 = anonimo ,2 = alumuno, 3 = profesor
	String htmlCommon = "<header id=\"Menu\"> " + 
			"				<ul><li><a href=\"index.html\">Noticias</a></li> " + 
								"<li><a href=\"Carteles.html\">Carteles</a></li> " + 
								"<li><a href=\"#\">Wiki</a></li> " + 
								"</ul>";
	String htmlAcceso = "<a class=\"last\" href=\"Acceso.html\">Acceder</a> ";
	String ProfessorOptions = "<li><a href=\"#\">Puntuar</a></li> ";
	String AlumnOptions = "<li><a href=\"#\">Entregar</a></li> ";
	public menuWeb(){
		
	}
	
	public menuWeb(String accesoCon) {
		switch (accesoCon) {
		case "Profesor":
			this.tipoConect = 3;
			break;

		case "Alumno":
			this.tipoConect = 2;
			break;
		case "Anonimo":
			this.tipoConect = 1;
			break;
		default:
			this.tipoConect = 0;
			break;
		}
	}
	
	public String generarVista() {
		String menu = htmlCommon;
		switch (tipoConect) {
			case 1:		//anonimo
				menu += this.htmlAcceso; //TODO: Unlogin!!!!!
			break;
			case 2:
				menu += this.AlumnOptions +this.htmlAcceso;
			break;
			case 3:
				menu += this.ProfessorOptions+this.htmlAcceso;
			break;
			default:
				menu += this.htmlAcceso;
		}
			return menu + "</header>";
	}
}
