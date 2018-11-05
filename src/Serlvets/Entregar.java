package Serlvets;

import java.util.List;

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
	 * 
	 * @param request
	 * @param response
	 * @param tipo Indica el tipo de error que se ha dado:
	 * 				1 = No hay titulo
	 * 				2 = No hay informacion
	 * 				3 = No hay pregunta
	 * 				4 = Faltan opciones
	 * 				5 = No hay reto
	 */
	protected void errores (HttpServletRequest request, HttpServletResponse response, int tipo ) {
		request.setAttribute("TipoError", tipo);
		try {
			request.getRequestDispatcher("/Entregar").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Excepcion Acceso.jsp con errores " + e.getMessage());
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
		if( (int) hs.getAttribute("TipoConexion") != alumno.tipoConect() ) {
			//La sesión actual, si la hay, no es de tipo alumno 
			noSesion(request, response);
		}
		else {
			//La sesion es de tipo alumno
			String titulo = "";
			String texto = "";
			String reto = "";
			String pregunta = "";
			String opcionI = "";
			String opcionII = "";
			String opcionIII = "";
			String opcionIV = "";
			String respuesta = "";
			//Se dan valores a los atributos utilizados
			//Dar valor a título
			if (request.getParameter("title") != null) {
				titulo = (String) request.getParameter("title");
			}
			else {
				errores(request, response, 1);
			}
			//Dar valor al texto
			if (request.getParameter("information") != null) {
				titulo = (String) request.getParameter("information");
			}
			else {
				errores(request, response, 2);
			}
			//Dar valor a la pregunta
			if (request.getParameter("quest") != null) {
				titulo = (String) request.getParameter("quest");
			}
			else {
				errores(request, response, 3);
			}
			//Dar valor a las opciones
			int preguntas = 0;
			if (request.getParameter("opt1") != null) {
				opcionI = request.getParameter("opt1");
				preguntas++;
			}
			if (request.getParameter("opt2") != null) {
				opcionII = request.getParameter("opt2");
				preguntas++;
			}
			if (request.getParameter("opt3") != null) {
				opcionIII = request.getParameter("opt3");
				preguntas++;
			}
			if (request.getParameter("opt4") != null) {
				opcionIV = request.getParameter("opt4");
				preguntas++;
			}
			//Si no hay más de dos opciones, error
			if (preguntas < 2) {
				errores(request, response, 4);
			}
			//Asignar valor a respuesta
			if (request.getParameter("corr1") != null) {
				respuesta = opcionI;
			}
			else if (request.getParameter("corr2") != null) {
				respuesta = opcionII;
			}
			else if (request.getParameter("corr3") != null) {
				respuesta = opcionIII;
			}
			else if (request.getParameter("corr4") != null) {
				respuesta = opcionIV;
			}			
			//Asginar valor al reto
			if (request.getParameter("deal") != null) {
				reto = request.getParameter("deal");
			}
			else {
				errores(request, response, 5);
			}
			
			//Crear los objetos y subirlos a la base de datos
			Pregunta preg = new Pregunta(pregunta, respuesta, opcionI, opcionII, opcionIII, opcionIV);
			Cartel cartel = new Cartel(titulo, texto, reto);
			cartel.setPregunta(preg);
		}
	}
	
}
