package aplicacionWeb.dao;

import java.sql.*;

public class DAO{
	
	Connection con=null;
	String SGBD = "jdbc:mysql://localhost:3306/retosecologicos";
	String user = "?user=root&password=lsc##849##SM";
	String pass = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public DAO() {
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		}catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public boolean conectado() throws SQLException {
		if(con != null) return false;
		else return !con.isClosed();
			 
	}
	
	
	public boolean conectarDAO() {
		try {
			if(con==null) {
				con=DriverManager.getConnection(SGBD+user+pass);
				return true;
			}else {
				return false;
			}
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