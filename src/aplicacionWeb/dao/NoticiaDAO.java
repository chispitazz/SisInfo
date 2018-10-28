package aplicacionWeb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import aplicacionWeb.vo.Noticia;

public class NoticiaDAO extends DAO{
	
	private int noticiasHaMostradar = 100;
	
	public NoticiaDAO() {
		super();
	}
	public void insertarNoticia(Noticia noticia) throws SQLException {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1,  noticia.titulo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
	}
	 public List<Noticia> getListaNoticias() {
	        List<Noticia> noticias = new LinkedList<Noticia>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = null;
	               resultSet = statement.executeQuery("SELECT * FROM noticias LIMIT 100");
	               
	 
	               
	                while(resultSet.next()){
	                	//(String titulo, String noticia)
	                	Noticia noticia  = new Noticia(resultSet.getString("titulo"),resultSet.getString("noticia"));
	                    noticias.add(noticia);   

	                }
	                resultSet.close();
	                statement.close();
	         	}catch (SQLException e) {
	                e.printStackTrace();
	         	}
			return noticias;
	    }
	
}
