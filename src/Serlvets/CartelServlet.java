package Serlvets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacionWeb.dao.CartelDAO;
import aplicacionWeb.dao.NoticiaDAO;
import aplicacionWeb.vo.ListaNoticias;

/**
 * Servlet implementation class Cartel
 */
@WebServlet("/Cartel")
public class CartelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		// coger el cartel con la fecha de publicación más cercana a la actual
				CartelDAO cartelDAO= new CartelDAO();
				
				cartelDAO.conectarDAO();
				
				Cartel	c = cartelD.selectbyID(1);	// que id uso??
		
				request.setAttribute("cartel", c);
				//redireccionar
				
				
		
		
	}

}
