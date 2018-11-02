package aplicacionWeb.dao;

import java.util.List;
import java.util.LinkedList;
import aplicacionWeb.vo.Anonimo;
import aplicacionWeb.vo.Profesor;

import java.sql.*;

public class AnonimoDAO extends DAO{
	
	
	public Anonimo buscarAnonimoID(String nick) throws SQLException {
		Statement statement = mysql.crearSentencia();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM anonimo WHERE nick=" + nick);
	    Anonimo an = null;
	    if(resultSet.next()) {
	    	System.out.println(resultSet.getInt("idAnonimo"));
	    	System.out.println(resultSet.getInt("AnoNacimiento")); 
	    	System.out.println(resultSet.getString("Correo"));
	    	System.out.println(resultSet.getString("nick"));
	    	System.out.println(resultSet.getString("ocupacion"));
	    	System.out.println(resultSet.getString("password")); 
	    	System.out.println(resultSet.getInt("puntos"));
	    	
		    an = new Anonimo(resultSet.getInt("idAnonimo"),resultSet.getInt("AnoNacimiento"),
		    		resultSet.getString("Correo"),resultSet.getString("nick"),resultSet.getString("ocupacion"),
		    		resultSet.getInt("puntos"),resultSet.getString("password"));
	    }
	    return an;		
	}
	public void insertarAnonimo(Anonimo Anonimo) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = mysql.prepararSentencia("INSERT INTO Anonimo "
            						+ "(AnoNacimiento,correo,nick,ocupacion,puntos,password) "
            							+ "VALUES (?,?,?,?,?,?)");
            //
            int i = 0;
          //  preparedStatement.setInt(i++,Anonimo.getIdAnonimo());
            preparedStatement.setInt(i++, Anonimo.getAnyoNacimiento()); 
            preparedStatement.setString(i++, Anonimo.getCorreo());
            preparedStatement.setString(i++,Anonimo.getNick());
            preparedStatement.setString(i++,Anonimo.getOcupacion());
            preparedStatement.setInt(i++,Anonimo.getPuntos());
            preparedStatement.setString(i++,Anonimo.getPass());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Anonimo> select() {
	        List<Anonimo> Anonimos = new LinkedList<Anonimo>();
	         try {
	                Statement statement = mysql.crearSentencia();
	                //Introducir select correcto
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM Anonimo"); 
	                 
	                Anonimo Anonimo = null;
	                while(resultSet.next()){
	                    Anonimo = new Anonimo(resultSet.getInt("idAnonimo"),resultSet.getInt("AnoNacimiento"),
	        		    		resultSet.getString("Correo"),resultSet.getString("nick"),resultSet.getString("ocupacion"),
	        		    		resultSet.getInt("puntos"),resultSet.getString("password"));
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
