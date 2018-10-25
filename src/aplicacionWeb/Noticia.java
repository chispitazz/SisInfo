package aplicacionWeb;
public class Noticia {

	String titulo;
	String noticia;
	String imagen;

	public Noticia(String titulo, String noticia){
		this.titulo = titulo;
		this.noticia = noticia;
	}
	
	public Noticia(String titulo, String noticia, String imagen){
		this.titulo = titulo;
		this.noticia = noticia;
		this.imagen = imagen;
	}
	
	public String titulo() {
		return this.titulo;
	}
	
	public String noticia() {
		return this.noticia;
	}
	
	public String imagen() {
		return this.imagen;
	}
}
