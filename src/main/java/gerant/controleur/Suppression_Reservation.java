package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.PersonneHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Suppression_Reservation
 */
@WebServlet("/suppression_Reservation")
public class Suppression_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppression_Reservation() {
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
			if(!request.getParameter("id_reservation").isEmpty())
			{
				int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
				Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
				new ReservationHome().delete(reservation);
				String objet="Validation de reservation";
				String pwd="oqzjtvzbrtutfahg";
				/*String from="senemamadou1999@gmail.com";
				String email=reservation.getClient().getPersonne().getEmail();
				String prenom=reservation.getClient().getPersonne().getPrenom();
				String nom=reservation.getClient().getPersonne().getNom();
				String ville=reservation.getDepartement().getNomdepartement();
				String date=reservation.getDatereservation().toGMTString();
				String heure=reservation.getHeurereservation();
				String message="Bonjour "+prenom+" "+nom+" \n Votre reservation de place effectuée le "+date+
						" à "+heure+" dans notre parking de la ville de "+ville+" a été validée avec succes.\n "
						+ "Vous pouvez acceder a notre application en utilisant le lient: "
						+ "http://localhost:8080/gestion_parking/index";
				new PersonneHome().sendMail(from, pwd,email, objet, message);*/
				response.sendRedirect("/gestion_parking/voir_TousReservations");
			}	
		}
		else if(session.getValue("id_gerant")!=null)
		{
			if(!request.getParameter("id_reservation").isEmpty())
			{
				int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
				Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
				new ReservationHome().delete(reservation);
				response.sendRedirect("/gestion_parking/voir_Reservations");
			}
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
