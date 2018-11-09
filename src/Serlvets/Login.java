package Serlvets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacionWeb.dao.*;
import aplicacionWeb.vo.*;

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
	 * Llama a doPost
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void errorConect(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("IntentosConnect", 1);
		try {
			request.getRequestDispatcher("/Acceso.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Excepcion Acceso.jsp con errores " + e.getMessage());
		}
	}
	
	
	
	/** 
	 * Loguea con la informacion wn los Parametros "usuario" y "pasword" si usuario existe en la BBDD con la misma "password"
	 * En caso contrario, redirecciona a AccesoError
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "resource" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Auto generado, Que hace getwriter? 	
		//			response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getSession().getAttribute("Usuario") != null) {
			request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
		}
		HttpSession hs = request.getSession();
		if(request.getParameter("usuario") == null || request.getParameter("password") == null) {
			errorConect(request, response);
		}else {
			//Existe usuario y contraseña. 
			String correo = (String) request.getParameter("usuario");
			String[] tokens = correo.split("@");
			
			if(tokens[0] == null) {
				//usuario mal insertado
				//Redireccion a Accesor ERROR
				errorConect(request, response);
			}else {
				try {
					//Buscar en BBDD
					String ps =  (String) request.getParameter("password");
					System.out.println("input Password = " + (String) request.getParameter("password"));
					Alumno alumno = null;
					Profesor profesor = null;
					Anonimo anonimo = null;
					if(tokens.length > 1 && tokens[1].equals("unizar.es")) {
						alumno = new AlumnoDAO().buscarAlumnoID(tokens[0]);
						profesor = new ProfesorDAO().buscarProfesorID(correo);
					}else {
						anonimo = new AnonimoDAO().buscarAnonimoID(correo);
					}
					if(alumno!=null && alumno.verificarAlumno(Integer.parseInt(tokens[0]), ps)) {
						//Si es alumno
						hs.setAttribute("Usuario", alumno);
						hs.setAttribute("TipoConexion", alumno.tipoConect());
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
						
					}else if( profesor!=null && profesor.verificarProfesor(correo, ps)){
						// Si es profesor
						hs.setAttribute("Usuario", profesor);
						hs.setAttribute("TipoConexion", profesor.tipoConect());
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
						
					}else if( anonimo !=null && anonimo.verificarAnonimo(correo, ps)){
						//Si es anonimo
						hs.setAttribute("Usuario", anonimo);
						hs.setAttribute("TipoConexion", anonimo.tipoConect());
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
					}else {
						errorConect(request, response);
					}
				} catch (SQLException e) {
					System.out.println("SQL EXCEPTION: " + e.getMessage() + " " + e.getErrorCode());
					errorConect(request, response);
				}
				
			}
		}
	
	}
		
}
