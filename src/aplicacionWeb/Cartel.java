package aplicacionWeb;

public class Cartel {
	private String titulo;
	private String texto;
	private String reto;
	private Pregunta pregunta;
	
	//Constructor cartel vacío
	Cartel() {
	}
	
	//Constructor cartel sin pregunta
	Cartel(String title, String txt, String rt) {
		this.titulo = title;
		this.texto = txt;
		this.reto = rt;
		this.pregunta = new Pregunta();
	}
	
	//Poner pregunta
	void setPregunta(String q, String answer, String op1, String op2, String op3,
			String op4) {
		this.pregunta = new Pregunta(q,answer,op1,op2,op3,op4);
	}
	
	void setPregunta(Pregunta p) {
		this.pregunta=p;
	}
	
	//Obtener título
	String getTitulo() {
		return this.titulo;
	}
	
	//Obtener texto
	String getTexto() {
		return this.texto;
	}
	
	//Obtener reto
	String getReto() {
		return this.reto;
	}
	
	//Obtener pregunta
	Pregunta getPregunta() {
		return this.pregunta;
	}
	

}
