package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import aplicacionWeb.vo.Pregunta;

public class PreguntaDAO {
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
	
	public void insertarPregunta(Pregunta pregunta) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1,  pregunta.getQuestion());//clave??
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Pregunta> select() {
	        List<Pregunta> preguntas = new LinkedList<Pregunta>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM retosecologicos.preguntas"); 
	                 
	                Pregunta pregunta = null;
	                while(resultSet.next()){
	                	//(String q, String answer, String op1, String op2, String op3, String op4)
	                    pregunta = new Pregunta(resultSet.getString("question"),resultSet.getString("respuesta"),
	                    		resultSet.getString("op1"),resultSet.getString("op2"),
	                    		resultSet.getString("op3"),resultSet.getString("op4"));
	                    preguntas.add(pregunta);   

	                }
	                resultSet.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(preguntas);
	            return preguntas;
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
