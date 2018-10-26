import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO{
	
	private connectD puntoConexion;
	
	
	public DAO() {
		puntoConexion = new connectDB();
	}
	
	public Alumno recuperarAlumno(int idAlumno) {
     try {
		Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Alumnos");
        
        
		puntoConexion.realizarQuery("SELECT * FROM Alumnos WHERE idAlumno=?" , idAlumno);
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Alumnos");
		
		resultSet.close();
        statement.close();
         
     } catch (SQLException e) {
        e.printStackTrace();
     }
	}
	
	
	
	public void insertarAlumno(Alumno alumno, Object...params) {
        try {
        	//Cambiar insert por el de la tabla correcto
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hmkcode.persons (id ,name) VALUES (NULL , ?)");
            //
            preparedStatement.setString(1,  alumno.getNombre());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}