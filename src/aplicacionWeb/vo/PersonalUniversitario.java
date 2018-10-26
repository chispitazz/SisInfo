package aplicacionWeb.vo;

public class PersonalUniversitario {
	private String Nombre;
	private String Correo;
		
	
	public PersonalUniversitario() {
		super();
	}
	public PersonalUniversitario(String nombre, String correo) {
		super();
		Nombre = nombre;
		Correo = correo;
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
	
	
	
}
