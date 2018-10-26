package aplicacionWeb;

import java.util.*;

public class Quiz {
	private List<Pregunta> quiz;
	
	//Constructor vacío
	Quiz() {
		this.quiz = new ArrayList<Pregunta>();
	}
	
	//Anyadir pregunta
	void anyadirPregunta(Pregunta p) {
		this.quiz.add(p);
	}
	
	//Eliminar pregunta
	void quitarPregunta(Pregunta p) {
		this.quiz.remove(p);
	}
	
	//Obtener quiz
	List<Pregunta> getQuiz(){
		return this.quiz;
	}
}
