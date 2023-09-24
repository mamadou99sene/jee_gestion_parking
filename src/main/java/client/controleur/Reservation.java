package client.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.GerantId;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Place;
import bdbeans.PlaceHome;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
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
		if(session.getValue("id_client")!=null&&!request.getParameter("id_place").isEmpty()&&session.getValue("id_departement")!=null)
		{
			//this.getServletContext().getRequestDispatcher("/Header_Client").include(request, response);
			//this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_place=Integer.parseInt(request.getParameter("id_place"));
			Place place=null;
			ArrayList<Place> les_places=(ArrayList<Place>) new PlaceHome().getAllPlacesUniques();
			for(int i=0;i<les_places.size();i++)
			{
				if(les_places.get(i).getId().getIdplace()==id_place)
				{
					place=les_places.get(i);
				}
			}
			int id_personne=(int) session.getValue("id_client");
			Client le_client=null;
			ArrayList<Client> les_clients=(ArrayList<Client>) new ClientHome().getAllClients();
			for(int i=0;i<les_clients.size();i++)
			{
				if(les_clients.get(i).getId().getIdpersonne()==id_personne)
				{
					le_client=les_clients.get(i);
				}
			}
			int id_departement=(int) session.getValue("id_departement");
			System.out.println(id_departement);
			Departement departement=null;
			ArrayList<Departement> departements=(ArrayList<Departement>) new DepartementHome().getAllDepartements();
			for(int i=0;i<departements.size();i++)
			{
				if(departements.get(i).getId().getIddepartement()==id_departement)
				{
					departement=departements.get(i);
				}
			}
			bdbeans.Reservation reservation=new bdbeans.Reservation();
			reservation.setClient(le_client);
			reservation.setEtat("non validée");
			reservation.setDepartement(departement);
			reservation.setDatereservation(new Date());
			reservation.setHeurereservation(LocalTime.now().toString().substring(0, 8));
		    new ReservationHome().persist(reservation);
		    String demande="BRAVO";
		    request.setAttribute("demande", demande);
		    String heure=reservation.getHeurereservation();
        	String message="Bonjour, votre demande de reservation de place éffectuée à "+heure+"\n a été envoyé avec succes. Une notification vous sera envoyé \n"
        			+ "lors de la validation de votre reservation";
		    request.setAttribute("reservation_envoye", message);
		    RequestDispatcher disp=request.getRequestDispatcher("/reservation.jsp");
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
		doGet(request, response);
	}

}
