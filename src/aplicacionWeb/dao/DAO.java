package aplicacionWeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO{
	
	Connection con=null;
	
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if(con==null) 
				con=DriverManager.getConnection("jdbc:mysql://localhost"); //no se como es
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean conectado() {
		if(con != null) return false;
		else
			try {
				return !con.isClosed();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
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