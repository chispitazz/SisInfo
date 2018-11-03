package aplicacionWeb.vo;

import aplicacionWeb.security.verificacionAcceso;

public class Anonimo implements Usuario{
	int idAnonimo;
	int anyoNacimiento = 0;
	String correo;
	String nick;
	String ocupacion = "";
	String pass;
	int puntos = 0;
	verificacionAcceso VA;

	
	public Anonimo(int idAnonimo, int anyoNacimiento, String correo, String nick, String ocupacion, int puntos, String passw) {
		this.idAnonimo = idAnonimo;
		this.anyoNacimiento = anyoNacimiento;
		this.correo = correo;
		this.nick = nick;
		this.ocupacion = ocupacion;
		this.puntos = puntos;
		this.pass = passw;
		this.VA = new verificacionAcceso();
	}
	
	public int getId() {
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

	public String getNombre() {
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
	
	public String getPass() {
		return this.getPass();
	}

	public void contestarPregunta(Pregunta p){
		String opcion="";
		//getOption--> de la p�gina
		if (p.getRespuesta().equals(opcion)){
			//add BD puntos por respuesta v�lida
		}
		else{
			//add BD respuesta incorrecta
		}
	}
	
	/**
	 * 
	 * @return 1: tipo de conexion establecido para anonimos
	 */
	public int tipoConect() {
		return 1;
	}


	public void verRanking(){}

	public boolean verificarAnonimo(String nick, String pass) {
		return this.nick.equals(nick) && VA.verificarPassword(pass,this.pass);
	}
}
