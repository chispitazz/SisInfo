package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO{
	
	Connection con=null;
	String SGBD = "jdbc:mysql://localhost:3306/retosecologicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user = "root";
	String pass = "lsc##849##SM";
	public DAO() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
			if(con==null) 
				con=DriverManager.getConnection(SGBD,user,pass); //no se como es
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}

	public boolean conectado() throws SQLException {
		if(con != null) return false;
		else return !con.isClosed();
			 
	}
	
	
	public boolean conectarDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if(con==null) 
				con=DriverManager.getConnection("jdbc:mysql://localhost"); //no se como es
			return true;
		}catch(ClassNotFoundException e) {
			return false;
		}catch(SQLException e) {
			return false;
		}
	}
	
	public boolean desconectarDAO() {
	    try {
	    	if (con != null) {
	    		con.close();
	    	}
	    	return true;
	    } catch (Exception e) { 
	       	return false;
        }
	}
}