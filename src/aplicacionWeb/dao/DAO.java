package aplicacionWeb.dao;

import java.sql.SQLException;
import java.util.Properties;

import jdbc.JDBCTemplate;
import jdbc.MySQLConfiguration;



public class DAO{
	
	JDBCTemplate mysql = null;
	Properties prop = null;
	public DAO() {
		try {
			prop = new Properties();
			mysql = new JDBCTemplate(new MySQLConfiguration("localhost",
					"3306","retosecologicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"),
					"root","lsc##849##SM");
			mysql.connect();
			System.out.println("Conectado a " + mysql);
		
		}catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public boolean conectado() throws SQLException {
		return mysql != null && mysql.conectado();		 
	}
	
	
	public boolean conectarDAO() {
		try {
			if(mysql==null) {
				mysql.connect();
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public boolean desconectarDAO() {
	    try {
	    	if (mysql != null) {
	    		mysql.disconnect();
	    	}
	    	return true;
	    } catch (Exception e) { 
	       	return false;
        }
	}
}