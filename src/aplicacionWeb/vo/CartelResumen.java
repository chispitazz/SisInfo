package aplicacionWeb.vo;

public class CartelResumen {
	private Integer grupo;
	private int bloqueEntrega;
	private int votos;
	private String titulo;
	private String tema;
	private boolean evaluado;
	private boolean publicado;
	private Integer idCartel;
	
	//Constructor vacío
	CartelResumen () {	
	}
	
	//Constructor para cartel nuevo
	public CartelResumen(int group, int bloque, String theme, String title, Integer idCartel) {
		this.grupo = group;
		this.bloqueEntrega = bloque;
		this.votos = 0;
		this.tema = theme;
		this.titulo = title;
		this.evaluado = false;
		this.publicado = false;	
		this.idCartel=idCartel;
	}
	


	public int getBloqueEntrega() {
		return bloqueEntrega;
	}

	public void setBloqueEntrega(int bloqueEntrega) {
		this.bloqueEntrega = bloqueEntrega;
	}

	public Integer getIdCartel() {
		return idCartel;
	}

	public void setIdCartel(int idCartel) {
		this.idCartel = idCartel;
	}

	public void setGrupo(Integer grupo) {
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
	public Integer getGrupo() {
		return this.grupo;
	}
	
	//Obtener bloque entrega
	int getBloque () {
		return this.bloqueEntrega;
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
	
		
}
