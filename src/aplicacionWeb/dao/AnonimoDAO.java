package aplicacionWeb.dao;

import java.util.List;
import java.util.LinkedList;
import aplicacionWeb.vo.Anonimo;
import java.sql.*;

public class AnonimoDAO {
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
	
	public void insertarAnonimo(Anonimo Anonimo) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
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
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM hmkcode.persons"); 
	                 
	                Anonimo Anonimo = null;
	                while(resultSet.next()){
	                	//(int idAnonimo, int anyoNacimiento, String correo, String nick, String ocupacion, int puntos)
	                    Anonimo = new Anonimo(Integer.parseInt(resultSet.getString("idAnonimo")),                   		
	                    		Integer.parseInt(resultSet.getString("anyoNacimiento")),resultSet.getString("correo"),
	                    		resultSet.getString("nick"),resultSet.getString("ocupacion"),
	                    		Integer.parseInt(resultSet.getString("puntos"))
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
