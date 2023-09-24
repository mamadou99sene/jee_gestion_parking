package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Place;
import bdbeans.PlaceHome;
import bdbeans.PlaceId;

/**
 * Servlet implementation class Ajout_Place
 */
@WebServlet("/ajout_Place")
public class Ajout_Place extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_Place() {
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
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			ArrayList<Parking> les_parkings=(ArrayList<Parking>) new ParkingHome().getAllParkingsUniques();
			request.setAttribute("les_parkings", les_parkings);
			RequestDispatcher disp=request.getRequestDispatcher("/ajout_Place.jsp");
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
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		if(session.getValue("id_gerant")!=null&&!request.getParameter("prix").isEmpty()&&!request.getParameter("type").isEmpty()&&
				!request.getParameter("etat").isEmpty()&&!request.getParameter("id_parking").isEmpty())
		{
			BigInteger prix=BigInteger.valueOf(Long.parseLong(request.getParameter("prix")));
			String type=request.getParameter("type");
			String etat=request.getParameter("etat");
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			Parking parking=new ParkingHome().getParkingById(id_parking);
			ArrayList<Place>les_places=(ArrayList<Place>) new PlaceHome().getAllPlacesUniques();
			int id_dernierPlace=les_places.get(les_places.size()-1).getId().getIdplace();
			PlaceId placeId=new PlaceId();
			placeId.setIdparking(id_parking);
			placeId.setIdplace(id_dernierPlace+1);
			Place place=new Place();
			place.setId(placeId);
			place.setEtat(etat);
			place.setPrix(prix);
			place.setParking(parking);
			place.setType(type);
			new PlaceHome().persist(place);
			String succes="Ajout de la place effectué avec succes";
			request.setAttribute("succes", succes);
			//parking.setNombreplace(parking.getNombreplace()+1);
			//new ParkingHome().update(parking);
		}
		else
		{
			String avertissement="veuillez remplir correctement les informations demandées";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
