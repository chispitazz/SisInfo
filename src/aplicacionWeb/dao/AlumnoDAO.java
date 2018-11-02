package aplicacionWeb.dao;

import java.util.List;
import java.util.LinkedList;
import aplicacionWeb.vo.Alumno;

import java.sql.*;

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
        	//insert into alumno (idalumno, nombre, Password, ano_matricula, carrera) values(747325, "eaao", "21234", 13/02/1991, 412)
            PreparedStatement preparedStatement = mysql.prepararSentencia("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1, Integer.toString(alumno.getIdAlumno()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	/*//TODO: rehacer con el nuevo DAO
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
	                    		Integer.parseInt(resultSet.getString("anyoMatricula")),
	                    		Integer.parseInt(resultSet.getString("idAlumno")));
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
*/
	
	
}
