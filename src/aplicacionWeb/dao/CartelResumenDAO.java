package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import aplicacionWeb.vo.CartelResumen;

public class CartelResumenDAO {
	Connection con=null;
	
	public void insertarCartelResumen(CartelResumen cartelR) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1, Integer.toString(cartelR.getIdCartel()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<CartelResumen> select() {
	        List<CartelResumen> cartelesR = new LinkedList<CartelResumen>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM hmkcode.persons"); 
	                 
	                CartelResumen cartelR = null;
	                while(resultSet.next()){
	                	//(int group, int bloque, String theme, String title)
	                    cartelR = new CartelResumen(Integer.parseInt(resultSet.getString("grupo")),
	                    		Integer.parseInt(resultSet.getString("bloque")),
	                    		resultSet.getString("tema"),resultSet.getString("titulo"),
	                    		Integer.parseInt(resultSet.getString("idCartel")));
	                    cartelesR.add(cartelR);   

	                }
	                resultSet.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(cartelesR);
	            return cartelesR;
	    }
	
}
