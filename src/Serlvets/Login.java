package Serlvets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacionWeb.dao.AlumnoDAO;
import aplicacionWeb.vo.Alumno;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "resource" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Auto generado, Que hace getwriter? 	
		//			response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs = request.getSession();
		if(request.getParameter("usuario") == null || request.getParameter("password") == null) {
			//TODO: REDIRECT error
			System.out.println("Sin usuario");
			//TODO: REDIRECT error
			System.out.println("Sin contase�a");
		}else {
			//Existe usuario y contraseña. 
			//Se busca Buscar en BD
			String correo = (String) request.getParameter("usuario");
			String[] tokens = correo.split("@");
			//Scanner input = new Scanner().useDelimiter("@");
			if(tokens[0] == null) {
				//TODO: redireccion error
			}else {
				//if(tokens[1] != null)
				//		String servidorMail = tokens[1];
				try {
					System.out.println("input Password = " + (String) request.getParameter("password"));
					Alumno alumno = new AlumnoDAO().buscarAlumnoID(tokens[0]);
					if( alumno!=null && alumno.verificarAlumno(Integer.parseInt(tokens[0]), (String) request.getParameter("password"))) {
						hs.setAttribute("Alumno", alumno);
						request.setAttribute("TipoConexion", alumno.tipoConect());
						//TODO: realizar Perfil.jsp
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
					}else {
						//TODO: Error con usuario o contraseña
					}
				} catch (SQLException e) {
					// TODO redireccionar Error conexion
				}
				
			}
		}
	
	}
		
}
