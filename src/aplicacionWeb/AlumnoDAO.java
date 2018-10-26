package aplicacionWeb;

import java.util.List;
import java.util.LinkedList;
import aplicacionWeb.Alumno;

import java.sql.*;

public class AlumnoDAO {
	
	Connection con=null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if(con==null) 
				con=DriverManager.getConnection("jdbc:mysql://localhost"); //no se como es
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void insertarAlumno(Alumno alumno) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1,  alumno.getNombre());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Alumno> select() {
	        List<Alumno> alumnos = new LinkedList<Alumno>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM hmkcode.persons"); 
	                 
	                Alumno alumno = null;
	                while(resultSet.next()){
	                	//(String nombre, String correo, String carrera, String grupo,Integer anyoMatricula)
	                    alumno = new Alumno(resultSet.getString("nombre"),resultSet.getString("correo"),
	                    		resultSet.getString("carrera"),resultSet.getString("grupo"),
	                    		Integer.parseInt(resultSet.getString("anyoMatricula")));
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
	
	
	
	
    public void closeConnection(){
        try {
              if (con != null) {
                  con.close();
              }
            } catch (Exception e) { 
                //no hacer nada
            }
    }
	
	
}
