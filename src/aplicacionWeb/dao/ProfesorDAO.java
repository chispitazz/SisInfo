package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import aplicacionWeb.vo.Profesor;

public class ProfesorDAO {
	Connection con=null;
	
	
	public void insertarProfesor(Profesor profesor) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1,  profesor.getNombre());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Profesor> select() {
	        List<Profesor> profesores = new LinkedList<Profesor>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM hmkcode.persons"); 
	                 
	                Profesor profesor = null;
	                while(resultSet.next()){
	                	//(String nombre, String correo,String departamento, String despacho, 
	        			//String sitioWeb,boolean administrador)
	                    profesor = new Profesor(resultSet.getString("nombre"),resultSet.getString("correo"),
	                    		resultSet.getString("departamento"),resultSet.getString("despacho"),
	                    		resultSet.getString("sitioWeb"),Boolean.parseBoolean(resultSet.getString("anyoMatricula")));
	                    profesores.add(profesor);   

	                }
	                resultSet.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(profesores);
	            return profesores;
	    }
	
}
