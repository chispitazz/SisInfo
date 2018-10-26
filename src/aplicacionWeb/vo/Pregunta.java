package aplicacionWeb.vo;

import java.util.*;

public class Pregunta {
	
	private String question;
	List<String> opciones;
	private String respuesta;
	
	//Constructor pregunta vacío
	Pregunta () {
		
	}
	//Constructor pregunta
	public Pregunta(String q, String answer, String op1, String op2, String op3, String op4) {
		this.question = q;
		//PENDIENTE: saber si solo son 4 opciones o más
		this.opciones = new ArrayList<String>();
		this.opciones.add(op1);
		this.opciones.add(op2);
		this.opciones.add(op3);
		this.opciones.add(op4);
		respuesta = answer;
	}
	
	//Cambiar pregunta
	void setPregunta(String nuevaP) {
		this.question = nuevaP;
	}
	
	//Obtener pregunta
	public String getQuestion() {
		return this.question;
	}
	
	//No se considera cambiar las opciones, ni la respuesta
	
	//Obtener opciones
	List<String> getOpciones (){
		return this.opciones;
	}
	
	//Obtener respuesta
	String getRespuesta() {
		return this.respuesta;
	}
}
