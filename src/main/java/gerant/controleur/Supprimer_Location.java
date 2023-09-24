package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Place;
import bdbeans.PlaceHome;

/**
 * Servlet implementation class Supprimer_Location
 */
@WebServlet("/supprimer_Location")
public class Supprimer_Location extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer_Location() {
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
		if(session.getValue("id_gerant")!=null&&!request.getParameter("id_location").isEmpty())
		{
			int id_location=Integer.parseInt(request.getParameter("id_location"));
			Detailslocation location=null;
			List<Detailslocation> locations=new DetailslocationHome().getDetailslocations();
			for(int i=0;i<locations.size();i++)
			{
				if(locations.get(i).getId().getIdlocation()==id_location)
				{
					location=locations.get(i);
				}
			}
			//Place place=location.getPlace();
			//place.setEtat("libre");
			//new PlaceHome().update(place);
			new DetailslocationHome().delete(location);
			response.sendRedirect("/gestion_parking/voir_Location");
			
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
