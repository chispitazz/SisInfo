package aplicacionWeb.vo;

public class Alumno extends PersonalUniversitario{
	private int carrera;
	private int grupo;
	private int anyoMatricula;
	private int idAlumno;
	private String password;
	
	public Alumno(String nombre, String correo, int carrera, int grupo, int anyoMatricula, String password) {
		//TODO: parsear correo para extraer id
		super(nombre, correo);
		this.carrera = carrera;
		this.grupo = grupo;
		this.anyoMatricula = anyoMatricula;
		this.password = password;
		//this.idAlumno=idAlumno;
	}
	
	public Alumno(int id, String correo, int carrera, int grupo, int anyoMatricula, String password, String nombre) {
		//TODO: parsear correo para extraer id
		super(nombre, correo);
		this.idAlumno=id;
		this.carrera = carrera;		
		this.grupo = grupo;
		this.anyoMatricula = anyoMatricula;
		this.password = password;
		
	}
	
	public boolean verificarAlumno(int id, String pass) {
		return (this.idAlumno == id && pass.equals(this.password));
	}
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	/*
	 * Getters and setters
	 */
	public int getCarrera() {
		return carrera;
	}

	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public int getAnyoMatricula() {
		return anyoMatricula;
	}

	public void setAnyoMatricula(int anyoMatricula) {
		this.anyoMatricula = anyoMatricula;
	}

	/*Funciones propias*/
	public void hacerEntrega(Cartel entregado){
		//add to DB
		
	}


	
	
	
}