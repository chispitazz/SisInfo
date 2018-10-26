package aplicacionWeb.vo;

public class Profesor extends PersonalUniversitario {
	private String departamento;
	private String despacho;	//no se que tipo de dato es, la verdad
	private String sitioWeb;
	boolean administrador;	//true:administrador, false:no administrador
	
	
	public Profesor(String nombre, String correo,String departamento, String despacho, 
			String sitioWeb,boolean administrador) {
		super(nombre,correo);
		this.departamento = departamento;
		this.despacho = despacho;
		this.sitioWeb = sitioWeb;
		this.administrador = administrador;
	}
	
	/*
	 * Getters and setters
	 */
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDespacho() {
		return despacho;
	}
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}
	public String getSitioWeb() {
		return sitioWeb;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	/*   */
	public void evaluar(){
		
	}
	public void publicarNoticia() {
		
	}
	public void publicarCartel(){
		
	}
	public void verEstadisticas(){
		
	}
}
