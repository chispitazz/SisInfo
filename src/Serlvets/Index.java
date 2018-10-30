package Serlvets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacionWeb.dao.NoticiaDAO;
import aplicacionWeb.vo.ListaNoticias;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int tipoConexion = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		if(sesion.getAttribute("Profesor") != null) {
			this.tipoConexion = 3;
		}else if(sesion.getAttribute("Alumno") != null) {
			this.tipoConexion = 2;
		}else if(sesion.getAttribute("Anonimo") != null) {
			this.tipoConexion = 1;
		}else {
			this.tipoConexion = 0;
		}
		NoticiaDAO nDAO = new NoticiaDAO();
		try {
		for(int i = 0; i<20 && !nDAO.conectado(); i++) {
			nDAO.conectarDAO();
		}
		if(!nDAO.conectado()) {
			System.out.println("error al conectar con la BBDD");
		}else {
		
	//		System.out.println("QUE PASAAAAAAAAAAA");
			ListaNoticias ultimasNoticias = nDAO.getListaNoticias();
			request.setAttribute("Noticas", ultimasNoticias);
			//getServletConfig().getServletContext().getRequestDispatcher().forward(request,response);
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
		}
		}catch(SQLException e) {
			System.out.println("imosible conectar" + e.getMessage());
		}
		
		//???response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

}
