package aplicacionWeb.vo;
public class Noticia {

	String titulo;
	String noticia;
	String imagen;
	String textoAlternativo;
	
	public Noticia(String titulo, String noticia){
		this.titulo = titulo;
		this.noticia = noticia;
	}
	
	public Noticia(String titulo, String noticia, String imagen){
		this.titulo = titulo;
		this.noticia = noticia;
		this.imagen = imagen;
	}

	public Noticia(String titulo, String noticia, String imagen, String alt){
		this.titulo = titulo;
		this.noticia = noticia;
		this.imagen = imagen;
		this.textoAlternativo = alt;
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
	
	public String alternativo() {
		return this.textoAlternativo;
	}
}
