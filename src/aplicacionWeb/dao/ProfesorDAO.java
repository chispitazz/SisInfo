package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import aplicacionWeb.vo.Alumno;
import aplicacionWeb.vo.Profesor;

public class ProfesorDAO extends DAO{

	public Profesor buscarProfesorID(String correo) throws SQLException {
		Statement statement = mysql.crearSentencia();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM Profesor WHERE correo=" + correo);
	    Profesor pr = null;
	    if(resultSet.next()) {
	    	System.out.println(resultSet.getInt("idProfesor"));
	    	System.out.println(resultSet.getString("correo")); 
	    	System.out.println(resultSet.getInt("Departamento"));
	    	System.out.println(resultSet.getInt("SitioWeb"));
	    	System.out.println(resultSet.getString("password"));
	    	System.out.println(resultSet.getString("nombre"));
	    	System.out.println(resultSet.getString("despacho")); 
		    pr = new Profesor(resultSet.getString("nombre"), resultSet.getString("correo"), resultSet.getString("departamento"), resultSet.getString("despacho"), resultSet.getString("sitioWeb"),
		    		resultSet.getBoolean("administrador")/*(resultSet.getInt("administrador") == 1)*/,resultSet.getString("password"));
	    }
	    
	    return pr;
	    		
	}
	
	/**
	 * Inserta en una base de datos MySQL un profesor
	 * @param profesor
	 */
	
	public void insertarProfesor(Profesor profesor) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = mysql.prepararSentencia("INSERT INTO profesor  (correo, nombre, password, departamento, sitioWeb, Despacho, administrador) VALUES (?,?,?,?,?,?,?)");
            int i = 0;
            preparedStatement.setString(i++,profesor.getCorreo());
            preparedStatement.setString(i++,profesor.getNombre());
            preparedStatement.setString(i++,profesor.getPassword());
            preparedStatement.setString(i++,profesor.getDepartamento());
            preparedStatement.setString(i++,profesor.getSitioWeb());
            preparedStatement.setString(i++,profesor.getDespacho());
            if(profesor.isAdministrador()) {
            	preparedStatement.setInt(i++, 1);
            }else {
            	preparedStatement.setInt(i++,0);
            }
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Profesor> GetListaProfesores() {
	        List<Profesor> profesores = new LinkedList<Profesor>();
	         try {
	                Statement statement = mysql.crearSentencia();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM profesor"); 
	                 
	                Profesor profesor = null;
	                while(resultSet.next()){
	                	//(String nombre, String correo,String departamento, String despacho, 
	        			//String sitioWeb,boolean administrador)
	                    profesor = new Profesor(resultSet.getString("nombre"), resultSet.getString("correo"), resultSet.getString("departamento"), resultSet.getString("despacho"), resultSet.getString("sitioWeb"),
	                 		    		resultSet.getBoolean("administrador")/*(resultSet.getInt("administrador") == 1)*/,resultSet.getString("password"));
	                 	
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
