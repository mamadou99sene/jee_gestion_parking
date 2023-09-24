package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Detailslocation;
import bdbeans.DetailslocationHome;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Place;
import bdbeans.PlaceHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Voir_Location
 */
@WebServlet("/voir_Location")
public class Voir_Location extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voir_Location() {
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
		if(session.getValue("id_gerant")!=null)
		{
			List<Detailslocation> locations=new DetailslocationHome().getAllDetailslocationsUniques();
			System.out.println(locations.size());
			if(locations.size()>0)
			{
				request.setAttribute("mes_locations", locations);
			}
			else
			{
				String mes_loction="Aucune location en cours";
				request.setAttribute("mes_loction", mes_loction);
			}
			RequestDispatcher disp=request.getRequestDispatcher("/voir_Location.jsp");
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
