package aplicacionWeb.dao;

import java.util.*;

import aplicacionWeb.vo.Pregunta;

public class ListaNoticias extends DAO{
	private List<Pregunta> noticias;
	
	//Constructor vacío
	ListaNoticias() {
		this.noticias = new ArrayList<Pregunta>();
	}
	
	//Anyadir pregunta
	void anyadirPregunta(Pregunta p) {
		this.noticias.add(p);
	}
	
	//Eliminar pregunta
	void quitarPregunta(Pregunta p) {
		this.noticias.remove(p);
	}
	
	//Obtener noticias
	List<Pregunta> getnoticias(){
		return this.noticias;
	}
}
