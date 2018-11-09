package Serlvets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacionWeb.dao.CartelResumenDAO;
import aplicacionWeb.vo.CartelResumen;
import aplicacionWeb.vo.Profesor;

/**
 * Servlet implementation class verEntregas
 */
@WebServlet("/verEntregas")
public class verEntregas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verEntregas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		if(hs.getAttribute("Usuario") == null || !(hs.getAttribute("Usuario") instanceof Profesor)) {
			request.getRequestDispatcher("/Acceso").forward(request, response);
		}else {
		
			List<CartelResumen> carteles = new CartelResumenDAO().listaResumenes();
			request.setAttribute("ListaResumenes", carteles);
			request.getRequestDispatcher("/verEntregas.html").forward(request, response);
		}
	}

}
