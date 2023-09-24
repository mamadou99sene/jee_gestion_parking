package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Date;
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
import bdbeans.DetailslocationId;
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
 * Servlet implementation class Ajouter_Location
 */
@WebServlet("/ajouter_Location")
public class Ajouter_Location extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_Location() {
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
			int id_personne=(int)session.getValue("id_gerant");
			List<Gerant> list_gerant=new GerantHome().getAllGerantsUniques();
			Gerant le_gerant=null;
			for(int i=0;i<list_gerant.size();i++)
			{
				if(list_gerant.get(i).getId().getIdpersonne()==id_personne)
				{
					le_gerant=list_gerant.get(i);
				}
			}
			List<Place> louables=new PlaceHome().getPlaceLouable(le_gerant.getParking());
			List<Reservation> valideBY_currentGerant=new ReservationHome().getReservationsvalideByGerant(le_gerant);
			List<Parking> parkingOf_cuurentGerant=new ParkingHome().getParkingsByIdDepartement(le_gerant.getParking().getDepartement());
			request.setAttribute("les_place_libres", louables);
			request.setAttribute("reservationvalideBycurrentGerant", valideBY_currentGerant);
			request.setAttribute("parkingOf_cuurentGerant", parkingOf_cuurentGerant);
			RequestDispatcher disp=request.getRequestDispatcher("/ajout_Location.jsp");
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
		if(session.getValue("id_gerant")!=null&&!request.getParameter("date_debut").isEmpty()&&!request.getParameter("date_fin").isEmpty()&&
				!request.getParameter("montant").isEmpty()&&!request.getParameter("id_parking").isEmpty()&&!request.getParameter("id_place").isEmpty()&&
				!request.getParameter("id_reservation").isEmpty())
			
		{
			Date date_debut=Date.valueOf(request.getParameter("date_debut"));
			Date date_fin=Date.valueOf(request.getParameter("date_fin"));
			BigInteger montant=BigInteger.valueOf(Long.parseLong(request.getParameter("montant")));
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			int id_place=Integer.parseInt(request.getParameter("id_place"));
			int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
			//Parking parking=new ParkingHome().getParkingById(id_parking);
			PlaceId placeId=new PlaceId();
			placeId.setIdplace(id_place);
			placeId.setIdparking(id_parking);
			Place place=new PlaceHome().findPlaceID(placeId);
			Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
			Detailslocation location=new Detailslocation();
			location.setDatedebut(date_debut);
			location.setDatefin(date_fin);
			location.setMontant(montant);
			location.setPlace(place);
			location.setReservation(reservation);
			DetailslocationId detail=new DetailslocationId();
			List<Detailslocation> mes_locations=new DetailslocationHome().getAllDetailslocationsUniques();
			int id_dernierlocation=mes_locations.get(mes_locations.size()-1).getId().getIdlocation();
			detail.setIdlocation(id_dernierlocation+1);
			detail.setIdparking(id_parking);
			detail.setIdplace(id_place);
			detail.setIdreservation(id_reservation);
			location.setId(detail);
			new DetailslocationHome().persist(location);
			place.setEtat("occup�e");
			new PlaceHome().update(place);
			String insertion="Ajout de la location effectu� avec succes";
			request.setAttribute("insertion", insertion);
		}
		else
		{
			String avertissement="Veuillez remplir tous les champs marqu�s obligatoires!!!";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
