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

import bdbeans.ClientHome;
import bdbeans.GerantHome;
import bdbeans.ParkingHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.Region;
import bdbeans.RegionHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
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
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			//int id_personne=(int)session.getValue("id_admin");
			//Personne personne=new PersonneHome().getPersonneById(id_personne);
			//request.setAttribute("personne", personne);
			request.setAttribute("non_valide", new ReservationHome().getReservationNonValide().size());
			request.setAttribute("nombre_client", new ClientHome().getAllClientsUniques().size());
			request.setAttribute("nombre_gerant", new GerantHome().getAllGerantsUniques().size());
			request.setAttribute("nombre_parking", new ParkingHome().getAllParkingsUniques().size());
			request.setAttribute("nombre_reservation", new ReservationHome().getAllReservationsUniques().size());
			ArrayList<Reservation> derniere_res=(ArrayList<Reservation>) new ReservationHome().getAllReservationsUniques();
			if(derniere_res.size()>=4)
			{
				request.setAttribute("dernieres_reservations", derniere_res);
			}
			
			RequestDispatcher disp=request.getRequestDispatcher("/accueil_Admin.jsp");
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
