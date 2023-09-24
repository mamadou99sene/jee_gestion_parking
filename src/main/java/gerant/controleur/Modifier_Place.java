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

import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Place;
import bdbeans.PlaceHome;
import bdbeans.PlaceId;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Modifier_Place
 */
@WebServlet("/modifier_Place")
public class Modifier_Place extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_Place() {
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
		if(session.getValue("id_gerant")!=null&&!request.getParameter("id_place").isEmpty()&&!request.getParameter("id_parking").isEmpty())
		{
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_place=Integer.parseInt(request.getParameter("id_place"));
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			PlaceId placeId=new PlaceId();
			placeId.setIdplace(id_place);
			placeId.setIdparking(id_parking);
			Place place=new PlaceHome().findPlaceID(placeId);
			int id_personne= (int) session.getValue("id_gerant");
			ArrayList<Parking> list_parking=(ArrayList<Parking>) new ParkingHome().getAllParkingsUniques();
			request.setAttribute("les_parkings", list_parking);
			request.setAttribute("id_place", id_place);
			request.setAttribute("prix", place.getPrix());
			//ArrayList<Place> les_places=(ArrayList<Place>) new PlaceHome().getAllPlaces();
			RequestDispatcher disp=request.getRequestDispatcher("/modifier_Place.jsp");
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
		if(!request.getParameter("prix").isEmpty()&&!request.getParameter("type").isEmpty()&&!request.getParameter("etat").isEmpty()&&
				!request.getParameter("id_parking").isEmpty()&&session.getValue("id_gerant")!=null&&!request.getParameter("id_place").isEmpty())
		{
			BigInteger prix=BigInteger.valueOf(Long.parseLong(request.getParameter("prix")));
			String type=request.getParameter("type");
			String etat=request.getParameter("etat");
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			int id_place=Integer.parseInt(request.getParameter("id_place"));
			PlaceId placeId=new PlaceId();
			placeId.setIdplace(id_place);
			placeId.setIdparking(id_parking);
			Place place=new PlaceHome().findPlaceID(placeId);
			Parking parking=new ParkingHome().getParkingById(id_parking);
			place.setEtat(etat);
			place.setId(placeId);
			place.setType(type);
			place.setPrix(prix);
			place.setParking(parking);
			new PlaceHome().update(place);
			String message="Modification effectuée avec succes";
			request.setAttribute("modification", message);
			
		}
		else
		{
			String avertissement="Veuillez saisir toutes les informations demandées svp!!!!";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
