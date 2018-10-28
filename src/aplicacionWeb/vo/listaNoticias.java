package aplicacionWeb.vo;

import java.util.*;
import aplicacionWeb.dao.*;

public class ListaNoticias{
	private List<Noticia> noticias;
	
	//Constructor vacío
	public ListaNoticias() {
		this.noticias = new ArrayList<Noticia>();
	}
	public ListaNoticias(List<Noticia> l) {
		this.noticias = l;
	}	
	//Anyadir Noticia
	public void anyadirNoticia(Noticia p) {
		this.noticias.add(p);
	}
	
	//Eliminar Noticia
	public void quitarNoticia(Noticia p) {
		this.noticias.remove(p);
	}
	
	//Obtener noticias
	public List<Noticia> getnoticias(){
		return this.noticias;
	}
	
	public int length() {
		return this.noticias.size();
	}
}