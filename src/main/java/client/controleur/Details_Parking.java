package client.controleur;

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

import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.PlaceHome;

/**
 * Servlet implementation class Details_Parking
 */
@WebServlet("/details_Parking")
public class Details_Parking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_Parking() {
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
		if(session.getValue("id_client")!=null&&!request.getParameter("id_parking").isEmpty())
		{
			this.getServletContext().getRequestDispatcher("/Header_Client").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			Parking parking=new ParkingHome().getParkingById(id_parking);
			int id_departement=parking.getDepartement().getId().getIddepartement();
			HttpSession session_dep=request.getSession();
			session.setAttribute("id_departement", id_departement);
			request.setAttribute("places_of_Parking", new PlaceHome().getPlacesByIdParking(parking));
			RequestDispatcher disp=request.getRequestDispatcher("/detail_ParkingClient.jsp");
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
