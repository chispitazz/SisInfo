package aplicacionWeb;

import java.util.List;
import java.util.LinkedList;
import aplicacionWeb.Anonimo;
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
            preparedStatement.setString(1,  Anonimo.getNombre());
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
	                	//(String nombre, String correo, String carrera, String grupo,Integer anyoMatricula)
	                    Anonimo = new Anonimo(resultSet.getString("nombre"),resultSet.getString("correo"),
	                    		resultSet.getString("carrera"),resultSet.getString("grupo"),
	                    		Integer.parseInt(resultSet.getString("anyoMatricula")));
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
