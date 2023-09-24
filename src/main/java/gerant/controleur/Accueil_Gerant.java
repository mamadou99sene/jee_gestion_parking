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

import bdbeans.ClientHome;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.ParkingHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Accueil_Gerant
 */
@WebServlet("/accueil_Gerant")
public class Accueil_Gerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil_Gerant() {
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
			int id_personne=(int) session.getValue("id_gerant");
			Personne personne=new PersonneHome().getPersonneById(id_personne);
			ArrayList<Gerant> gerants=(ArrayList<Gerant>) new GerantHome().getAllGerantsUniques();
			Gerant gerant=null;
			for(int i=0;i<gerants.size();i++)
			{
				if(gerants.get(i).getId().getIdpersonne()==id_personne)
				{
					gerant=gerants.get(i);
				}
			}
			request.setAttribute("nombre_place", gerant.getParking().getNombreplace());
			request.setAttribute("nombre_reservation", gerant.getReservations().size());
		    request.setAttribute("horaire", gerant.getHoraire());
		    List<Reservation> reserv_dernier_client=new ReservationHome().getReservationsvalideByGerant(gerant);
		    if(reserv_dernier_client.size()>=4)
		    {
		    	request.setAttribute("clients_reservation_gerees", reserv_dernier_client);
		    }
		    
			RequestDispatcher disp=request.getRequestDispatcher("/accueil_Gerant.jsp");
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
