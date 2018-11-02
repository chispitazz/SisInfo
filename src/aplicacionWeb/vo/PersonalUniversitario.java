package aplicacionWeb.vo;

import aplicacionWeb.security.verificacionAcceso;

public class PersonalUniversitario {
	protected String Nombre;
	protected String Correo;
	protected String password;
	private verificacionAcceso VA; 
	
	public PersonalUniversitario() {
		super();
	}
	public PersonalUniversitario(String nombre, String correo, String pass) {
		super();
		Nombre = nombre;
		Correo = correo;
		password = pass;
		VA = new verificacionAcceso();
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	public void setPassword(String pass) {
		this.password = VA.generarHash(pass);
	}
	
	public boolean verificarUsuario(String pass) {
		return this.VA.verificarPassword(pass, this.password);
	}
	
	
}
