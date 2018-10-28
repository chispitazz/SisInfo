package aplicacionWeb;

import java.util.*;


public class ListaNoticias{
	private List<Noticia> noticias;
	
	//Constructor vac�o
	noticias() {
		this.noticias = new ArrayList<Noticia>();
	}
	
	//Anyadir Noticia
	void anyadirNoticia(Noticia p) {
		this.noticias.add(p);
	}
	
	//Eliminar Noticia
	void quitarNoticia(Noticia p) {
		this.noticias.remove(p);
	}
	
	//Obtener noticias
	List<Noticia> getnoticias(){
		return this.noticias;
	}
	
}