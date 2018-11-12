package aplicacionWeb.dao;

import aplicacionWeb.vo.Alumno;

import java.sql.*;
import java.util.*;

public class AlumnoDAO extends DAO{
	
	@SuppressWarnings("finally")
	public Alumno buscarAlumnoID(String idAlumno) throws SQLException {
		Alumno al = null;
		try {
			int id = Integer.parseInt(idAlumno);
			System.out.println(id);
			Statement statement = mysql.crearSentencia();
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM alumno WHERE idAlumno=" + idAlumno); 
		    if(resultSet.next()) {
		    	System.out.println(resultSet.getInt("idAlumno"));
		    	System.out.println(resultSet.getString("correo")); 
		    	System.out.println(resultSet.getInt("carrera"));
		    	//System.out.println(resultSet.getInt("anyoMatricula"));
		    	System.out.println(resultSet.getString("password"));
		    	System.out.println(resultSet.getString("nombre"));
		    	al =new Alumno(resultSet.getInt("idAlumno"),"aa",resultSet.getInt("carrera"),0,1023,resultSet.getString("password"), resultSet.getString("nombre")); 
			    
		    }
		}catch(NumberFormatException e){
			System.out.println("ID no correcto");
		}finally {
			return al;
		}
 		
	}
	
	public void insertarAlumno(Alumno alumno) {
        try {
        	//Cambiar insert por el de la tabla correcto
        	//insert into alumno (idalumno, correo, nombre, Password, ano_matricula, Carrera) values(747325, "eaao", "21234", 13/02/1991, 412)
            PreparedStatement preparedStatement = mysql.prepararSentencia("INSERT INTO	retosecologicos.alumno VALUES"
            		+ "("+Integer.toString(alumno.getId()) + ","+ alumno.getCorreo()+","+alumno.getNombre()+","
            		+ "pass??" + "," + Integer.toString(alumno.getAnyoMatricula()) + ","
            		+ alumno.getCarrera() +" )");
            // falta como insertar contraseña
            
            //
            preparedStatement.setString(1, Integer.toString(alumno.getId()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	 public List<Alumno> select() {
	        List<Alumno> alumnos = new LinkedList<Alumno>();
	         try {
	                Statement statement = mysql.crearSentencia();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM hmkcode.persons"); 
	                 
	                Alumno alumno = null;
	                while(resultSet.next()){
	                	//String nombre, String correo, int carrera, int grupo, int anyoMatricula, String password
	                    alumno = new Alumno(resultSet.getString("nombre"),resultSet.getString("correo"),
	                    		Integer.parseInt(resultSet.getString("carrera")),Integer.parseInt(resultSet.getString("grupo")),
	                    		Integer.parseInt(resultSet.getString("anyoMatricula")),
	                    		resultSet.getString("Password"));
	                    alumnos.add(alumno);   

	                }
	                resultSet.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(alumnos);
	            return alumnos;
	    }

	
	
}
