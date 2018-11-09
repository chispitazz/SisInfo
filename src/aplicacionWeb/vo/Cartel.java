package aplicacionWeb.vo;

public class Cartel {
	private String titulo;
	private String texto;
	private String reto;
	private Pregunta pregunta;
	private int id;
	
	//Constructor cartel vacío
	public Cartel() {
	}
	
	//Constructor cartel sin pregunta
	public Cartel(String title, String txt, String rt, int id) {	//add ID
		this.titulo = title;
		this.texto = txt;
		this.reto = rt;
		this.pregunta = new Pregunta();
		this.id=id;
	}
	
	//Poner pregunta
	public void setPregunta(String q, String answer, String op1, String op2, String op3,
			String op4) {
		this.pregunta = new Pregunta(q,answer,op1,op2,op3,op4);
	}
	
	public void setPregunta(Pregunta p) {
		this.pregunta=p;
	}
	
	//Obtener título
	public String getTitulo() {
		return this.titulo;
	}
	
	//Obtener texto
	public String getTexto() {
		return this.texto;
	}
	
	//Obtener reto
	public String getReto() {
		return this.reto;
	}
	
	//Obtener pregunta
	public Pregunta getPregunta() {
		return this.pregunta;
	}
	
	// Obtener id
	public int getId() {
		return this.id;
	}
	

}
