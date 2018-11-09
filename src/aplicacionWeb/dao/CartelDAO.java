package aplicacionWeb.dao;

import java.sql.Connection;
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
	
	public void insertarCartel(Cartel cartel) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            //instert id_Carteles
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
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM retosecologicos.carteles"); 
	                ResultSet resultSetP=null;  
	                Cartel cartel = null;
	                Pregunta pregunta=null;
	                while(resultSet.next()){
	                	//(String title, String txt, String rt,int id)
	                
	                    cartel = new Cartel(resultSet.getString("Titulo"),resultSet.getString("Texto"),
	                    		resultSet.getString("Reto"),Integer.parseInt(resultSet.getString("idCarteles")));
	                    
	                  //seleccionear pregunta del cartel de la BD
	                     resultSetP = statement.executeQuery("SELECT * FROM retosecologicos.preguntas WHERE id_Cartel =" 
	                    									+ cartel.getId() ); 
	                    
	                    pregunta=new Pregunta( resultSetP.getString("question"),resultSetP.getString("respuesta"),
	                    		resultSetP.getString("op1"),resultSetP.getString("op2"),
	                    		resultSetP.getString("op3"),resultSetP.getString("op4"));
	                    		
	                    
	                    
	                    cartel.setPregunta(pregunta);
                  	                    
	                    carteles.add(cartel);   

	                }
	                resultSet.close();
	                resultSetP.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(carteles);
	            return carteles;
	    }	
	 
	 	public Cartel selectbyID(int ID) {
	 		Cartel c=null;
	 		try {
                Statement statement = con.createStatement();
                //Introducir select correcto
                ResultSet resultSet = statement.executeQuery("SELECT * FROM retosecologicos.carteles WHERE idCarteles = "
                		+ ID); 
                ResultSet resultSetP=null;  
                Pregunta pregunta=null;
                
                c = new Cartel(resultSet.getString("Titulo"),resultSet.getString("Texto"),
                		resultSet.getString("Reto"),Integer.parseInt(resultSet.getString("idCarteles")));
                
                resultSetP = statement.executeQuery("SELECT * FROM retosecologicos.preguntas WHERE id_Cartel =" 
						+ c.getId() ); 

				pregunta=new Pregunta( resultSetP.getString("question"),resultSetP.getString("respuesta"),
				resultSetP.getString("op1"),resultSetP.getString("op2"),
				resultSetP.getString("op3"),resultSetP.getString("op4"));

				c.setPregunta(pregunta);

                resultSet.close();
                resultSetP.close();
                statement.close();
                 
            } catch (SQLException e) {
                e.printStackTrace();
            }
			
	 		return c;
	 	} 
}
