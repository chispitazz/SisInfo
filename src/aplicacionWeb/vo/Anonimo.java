package aplicacionWeb.vo;

public class Anonimo {
	int idAnonimo;
	int anyoNacimiento;
	String correo;
	String nick;
	String ocupacion;
	int puntos;

	
	public Anonimo(int idAnonimo, int anyoNacimiento, String correo, String nick, String ocupacion, int puntos) {
		super();
		this.idAnonimo = idAnonimo;
		this.anyoNacimiento = anyoNacimiento;
		this.correo = correo;
		this.nick = nick;
		this.ocupacion = ocupacion;
		this.puntos = puntos;
	}
	
	public int getIdAnonimo() {
		return idAnonimo;
	}

	public void setIdAnonimo(int idAnonimo) {
		this.idAnonimo = idAnonimo;
	}

	public int getAnyoNacimiento() {
		return anyoNacimiento;
	}

	public void setAnyoNacimiento(int anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void contestarPregunta(Pregunta p){
		String opcion="";
		//getOption--> de la página
		if (p.getRespuesta().equals(opcion)){
			//add BD puntos por respuesta válida
		}
		else{
			//add BD respuesta incorrecta
		}
	}
	


	public void verRanking(){}
}
