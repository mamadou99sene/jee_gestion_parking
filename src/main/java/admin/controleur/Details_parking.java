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

import bdbeans.Horaire;
import bdbeans.HoraireHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;

/**
 * Servlet implementation class Details_parking
 */
@WebServlet("/details_parking")
public class Details_parking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_parking() {
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
		if(session.getValue("id_admin")!=null&&!request.getParameter("id_parking").isEmpty())
		{
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			request.setAttribute("mon_parking", new ParkingHome().findParkingByID(id_parking));
			RequestDispatcher disp=request.getRequestDispatcher("/details_parking.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
