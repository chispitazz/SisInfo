package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacionWeb.dao.CartelDAO;
import aplicacionWeb.vo.Cartel;
import aplicacionWeb.vo.Pregunta;

/**
 * Servlet implementation class Cartel
 */
@WebServlet("/Carteles")
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
				try {
					boolean conectado= cartelDAO.conectado();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Cartel	c = cartelDAO.selectMostRecent();
				
				if(c == null) {
					Pregunta p = new Pregunta("aaaaaaaaaa", "aaaaaaa", "aaa", "oa2",
						"adsafs","opcioasdasdn4");
					c= new Cartel("sdaggas","awegwers", "WEFDqwdsd", 1);	
					c.setPregunta(p);
				}
		
				request.setAttribute("cartel", c);
				//redireccionar
				request.getRequestDispatcher("/Carteles.jsp").forward(request, response);
				
				
		
		
	}

}
