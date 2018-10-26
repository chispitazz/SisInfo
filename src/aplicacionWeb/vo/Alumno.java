package aplicacionWeb.vo;

public class Alumno extends PersonalUniversitario{
	private String carrera;
	private String grupo;
	private Integer anyoMatricula;
	private Integer idAlumno;
	
	
	public Alumno(String nombre, String correo, String carrera, String grupo,
			Integer anyoMatricula, Integer idAlumno ) {
		super(nombre, correo);
		this.carrera = carrera;
		this.grupo = grupo;
		this.anyoMatricula = anyoMatricula;
		this.idAlumno=idAlumno;
	}
	
	
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	/*
	 * Getters and setters
	 */
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Integer getAnyoMatricula() {
		return anyoMatricula;
	}

	public void setAnyoMatricula(Integer anyoMatricula) {
		this.anyoMatricula = anyoMatricula;
	}

	/*Funciones propias*/
	public void hacerEntrega(Cartel entregado){
		//add to DB
		
	}


	
	
	
}