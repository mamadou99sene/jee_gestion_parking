package admin.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;

/**
 * Servlet implementation class Voir_Gerant
 */
@WebServlet("/voir_Gerant")
public class Voir_Gerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voir_Gerant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		if(session.getValue("id_admin")!=null)
		{
			ArrayList<Gerant> les_gerants=(ArrayList<Gerant>) new GerantHome().getAllGerantsUniques();
			request.setAttribute("les_gerants", les_gerants);
			RequestDispatcher disp=request.getRequestDispatcher("/voir_Gerant.jsp");
			disp.include(request, response);
		}
		else
		{
			response.sendRedirect("/gestion_parking/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
