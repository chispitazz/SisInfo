import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectDB{
	
Connection con=null;
	
	public connectDB() {
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
		return cont != null;
	}
	
	
	

	public void realizarQuery(string query, Object...param) {
		PreparedStatement stmt = null;
		//ResultSet rs = null;
		try {
			
			stmt = con.prepareStatement(query);
			for(int i = 0; i<params.length; i++) {
				stmt.setObject(i+1, params[i]);
			}
			
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	
	
	public void realizarQuery(string query, Object...param) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			for(int i = 0; i<params.length; i++) {
				stmt.setObject(i+1, params[i]);
			}
			int resultado = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
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