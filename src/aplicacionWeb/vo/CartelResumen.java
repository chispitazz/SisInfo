package aplicacionWeb.vo;

import java.sql.Date;

public class CartelResumen {
	private int grupo;
	private int votos;
	private String titulo;
	private String tema;
	private boolean evaluado;
	private boolean publicado;
	private Date fechaPuclicacion;
	private int idCartel;
	
	//Constructor vacío
	CartelResumen () {	
	}
	
	//Constructor para cartel nuevo
	public CartelResumen(int group,  String theme, int nota, 
			String title, int idCartel, Date fecha) {
		this.grupo = group;
		this.votos = 0;
		this.tema = theme;
		this.titulo = title;
		this.evaluado = nota>=0;
		
		if(fecha != null) {
			this.setFechaPuclicacion(fecha);
			this.publicado = fecha.compareTo(new java.util.Date()) <=0;
		}
			
		this.idCartel=idCartel;
	}
	


	public int getIdCartel() {
		return idCartel;
	}

	public void setIdCartel(int idCartel) {
		this.idCartel = idCartel;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setEvaluado(boolean evaluado) {
		this.evaluado = evaluado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	//Obtener grupo
	public int getGrupo() {
		return this.grupo;
	}

	//Modificar votos
	//Pone evaluado = true y 
	//Si suma -> suma vote a lo previo
	//Si !suma -> votos = vote
	void setVotos (int vote, boolean suma) {
		//Si suma -> suma a lo previo
		this.evaluado = true;
		if (suma) {
			this.votos += vote;
		}
		//Si !suma -> sustituye
		else {
			this.votos = vote;
		}
	}
	
	//Obtener votos
	int getVotos () {
		return this.votos;
	}
	
	//Cambiar titulo 
	void setTitulo (String newTitle) {
		this.titulo = newTitle;
	}
	
	//Obtener titulo
	String getTitulo () {
		return this.titulo;
	}
	
	//Obtener tema
	String getTema () {
		return this.tema;
	}
	
	//Modificar evaluado
	//Si no estaba evaluado entonces evaluado = true
	//Si estaba evaluado entonces evaluado = false y votos = 0
	void setEvaluado () {
		if (!this.evaluado ) { //Pasa a ser evaluado
			this.evaluado = true;
		}
		else  {
			this.evaluado = false;
			this.votos = 0;
		}
	}
	//Obtener evaluado
	boolean getEvaluado() {
		return this.evaluado;
	}
	
	//Modificar publicado
	void setPublicado () {
		this.publicado = true;
	}
	//Obtener publicado
	boolean getPublicado () {
		return this.publicado;
	}

	public Date getFechaPuclicacion() {
		return fechaPuclicacion;
	}

	public void setFechaPuclicacion(Date fechaPuclicacion) {
		this.fechaPuclicacion = fechaPuclicacion;
	}
	
		
}
