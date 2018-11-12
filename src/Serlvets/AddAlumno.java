package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aplicacionWeb.vo.Alumno;

/**
 * Servlet implementation class Acceso
 */
@WebServlet("/addAlumno")
public class AddAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

/*
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	throws IOException, ServletException {
		
		
				String nombre = request.getParameter("formNombre"); 
				String correo = request.getParameter("formCorreo"); 
				String[] tokens = correo.split("@");
				if (tokens[0]==null) {
					//correo mal insertado
					request.getRequestDispatcher("/AddAlumnoErr.html").forward(request, response);
				}				
				String grupo = request.getParameter("formGrupo"); 
				String nia = request.getParameter("formNIA"); 
				
				Alumno a =new Alumno(nombre,correo,"carrera",);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("Profesor") != null 
			|| request.getSession().getAttribute("Alumno") != null 
			|| request.getSession().getAttribute("Anonimo") != null){
			request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
			}else {
				if(request.getAttribute("IntentosConnect") != null) {
					request.setAttribute("IntentosConnect", (int)request.getAttribute("IntentosConnect")+1);
				}
				request.getRequestDispatcher("/Acceso.jsp").forward(request, response);
			}
	}
*/
}
