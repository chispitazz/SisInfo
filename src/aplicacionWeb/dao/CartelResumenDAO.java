package aplicacionWeb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import aplicacionWeb.vo.CartelResumen;

public class CartelResumenDAO extends DAO{
	
	public void insertarCartelResumen(CartelResumen cartelR) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = mysql.prepararSentencia("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1, Integer.toString(cartelR.getIdCartel()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<CartelResumen> listaResumenes() {
	        List<CartelResumen> cartelesR = new LinkedList<CartelResumen>();
	         try {
	                Statement statement = mysql.crearSentencia();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT idCarteles, grupo_autor, Titulo, Nota, Votos, FechaPublicacion, Tema, FROM carteles LIMIT 100"); 
	                
	                CartelResumen cartelR = null;
	                while(resultSet.next()){
	                    cartelR = new CartelResumen(resultSet.getInt("grupo_autor"), resultSet.getString("tema"), resultSet.getInt("Nota"), 
	                    		resultSet.getString("Titulo"), resultSet.getInt("idCarteles"), resultSet.getDate("FechaPublicacion"));
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
