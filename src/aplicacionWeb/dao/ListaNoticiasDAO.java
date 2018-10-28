package aplicacionWeb.dao;

import java.util.*;

import aplicacionWeb.vo.Pregunta;

public class ListaNoticiasDAO extends DAO{
	private List<Pregunta> noticias;
	//TODO: ESTO NO ES EL DAO DEL QUIZ!!!!!!!!!
	//Constructor vacío
	ListaNoticiasDAO() {
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
