package aplicacionWeb.dao;

import java.util.List;
import java.util.LinkedList;
import aplicacionWeb.vo.Anonimo;
import java.sql.*;

public class AnonimoDAO extends DAO{
	Connection con=null;
	
	public void insertarAnonimo(Anonimo Anonimo) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Anonimo VALUES (?,?,?,? , ?)");
            //
            preparedStatement.setString(1,  Integer.toString(Anonimo.getIdAnonimo()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Anonimo> select() {
	        List<Anonimo> Anonimos = new LinkedList<Anonimo>();
	         try {
	                Statement statement = con.createStatement();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM Anonimo"); 
	                 
	                Anonimo Anonimo = null;
	                while(resultSet.next()){
	                	//(int idAnonimo, int anyoNacimiento, String correo, String nick, String ocupacion, int puntos)
	                    Anonimo = new Anonimo(Integer.parseInt(resultSet.getString("idAnonimo")),                   		
	                    		Integer.parseInt(resultSet.getString("anyoNacimiento")),resultSet.getString("correo"),
	                    		resultSet.getString("nick"),resultSet.getString("ocupacion"),
	                    		Integer.parseInt(resultSet.getString("puntos")), resultSet.getString("password")
	                    		);
	                    Anonimos.add(Anonimo);   

	                }
	                resultSet.close();
	                statement.close();
	                 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            System.out.println(Anonimos);
	            return Anonimos;
	    }
		
}
