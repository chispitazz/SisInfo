package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import aplicacionWeb.vo.Cartel;
import aplicacionWeb.vo.Pregunta;

public class CartelDAO extends DAO {
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
	
	public void insertarCartel(Cartel cartel) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1,  cartel.getTitulo());	//no se cual es la clave
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Cartel> select() {
	        List<Cartel> carteles = new LinkedList<Cartel>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM hmkcode.persons"); 
	                 
	                Cartel cartel = null;
	                Pregunta pregunta=null;
	                while(resultSet.next()){
	                	//(String title, String txt, String rt)
	                    cartel = new Cartel(resultSet.getString("titulo"),resultSet.getString("texto"),
	                    		resultSet.getString("reto"));
	                    pregunta=null;//seleccionear pregunta del cartel de la BD
	                    cartel.setPregunta(pregunta);
                  	                    
	                    carteles.add(cartel);   

	                }
	                resultSet.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(carteles);
	            return carteles;
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
