package aplicacionWeb.vo;

public class Profesor extends PersonalUniversitario {
	private int idProfesor; 
	private String departamento;
	private String despacho;	//no se que tipo de dato es, la verdad
	private String sitioWeb;
	boolean administrador;	//true:administrador, false:no administrador
	
	
	public Profesor(String nombre, String correo,String departamento, String despacho, 
			String sitioWeb,boolean administrador, String pass, int id) {
		super(nombre,correo, pass);
		this.departamento = departamento;
		this.despacho = despacho;
		this.sitioWeb = sitioWeb;
		this.administrador = administrador;
		this.idProfesor = id;
	}
	
	public int getID() {
		return this.idProfesor;
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
	
	/**
	 * 
	 * @return 3: tipo de conexion establecido para Profesores
	 */
	public int tipoConect() {
		return 3;
	}

	/**
	 * 
	 * @param nombre: nombre del profesor que se quiere verificar
	 * @param pass: pasword sin encriptar a verificar
	 * @return devuelve TRUE si nombre y contraseña son las mismas que las de this
	 */
	public boolean verificarProfesor(String correo, String pass) {
		return correo.equals(this.getCorreo()) && this.verificarUsuario(pass);
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
