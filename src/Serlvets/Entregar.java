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
 * Servlet implementacion class Entregar
 */
@WebServlet("/Entregar")
public class Entregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Entregar() {
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
	
	/**
	 * 
	 * @param request
	 * @param response
	 * Si la sesión del alumno ha expirado o se intenta acceder sin identificarse
	 * redirecciona al usuario a la página de log in
	 */
	protected void noSesion(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("IntentosConnect", 2);
		try {
			request.getRequestDispatcher("/Acceso").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Excepcion Acceso con errores " + e.getMessage());
		}
	}
	
	/** 
	 * Permite almacenar la información y realizar la entrega de un cartel si hay un usuario
	 * registrado, existe en la base de datos, es un alumno y la información ha sido rellenada
	 * correctamente. Es decir, no hay huecos en blanco. 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "resource" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated
		// Auto generado, Que hace getwriter? 	
		//			response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs = request.getSession();
		Alumno alumno = null;
		if( hs.getAttribute("TipoConexion") != (Object) alumno.tipoConect() ) {
			//La sesión actual, si la hay, no es de tipo alumno 
			noSesion(request, response);
		}else {
			//La sesion es de tipo alumno
			String 
			//Existe usuario y contraseña. 
			String correo = (String) request.getParameter("usuario");
			String[] tokens = correo.split("@");
			
			if(tokens[0] == null) {
				//usuario mal insertado
				//Redireccion a Accesor ERROR
				noSesion(request, response);
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
						hs.setAttribute("Alumno", alumno);
						hs.setAttribute("TipoConexion", alumno.tipoConect());
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
						
					}else if( profesor!=null && profesor.verificarProfesor(correo, ps)){
						// Si es profesor
						hs.setAttribute("Profesor", profesor);
						hs.setAttribute("TipoConexion", profesor.tipoConect());
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
						
					}else if( anonimo !=null && anonimo.verificarAnonimo(correo, ps)){
						//Si es anonimo
						hs.setAttribute("Anonimo", anonimo);
						hs.setAttribute("TipoConexion", anonimo.tipoConect());
						request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
					}else {
						noSesion(request, response);
					}
				} catch (SQLException e) {
					System.out.println("SQL EXCEPTION: " + e.getMessage() + " " + e.getErrorCode());
					noSesion(request, response);
				}
				
			}
		}
	
	}
    
	
}
