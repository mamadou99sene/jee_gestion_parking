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

import bdbeans.PersonneHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Validation_Reservation
 */
@WebServlet("/validation_Reservation")
public class Validation_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation_Reservation() {
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
				reservation.setEtat("valid�e");
				new ReservationHome().update(reservation);
				String objet="Validation de reservation";
				String pwd="oqzjtvzbrtutfahg";
				String from="senemamadou1999@gmail.com";
				List<Reservation> allres=new ReservationHome().getAllReservationsUniques();
				Reservation current_res=null;
				for(int i=0;i<allres.size();i++)
				{
					if(allres.get(i).getIdreservation()==id_reservation)
					{
						current_res=allres.get(i);
					}
				}
				String email=current_res.getClient().getPersonne().getEmail();
				String prenom=current_res.getClient().getPersonne().getPrenom();
				String nom=current_res.getClient().getPersonne().getNom();
				String ville=current_res.getDepartement().getNomdepartement();
				String date=current_res.getDatereservation().toGMTString().substring(0,11);
				String heure=current_res.getHeurereservation();
				String message="Bonjour "+prenom+" "+nom+" \n Votre reservation de place effectu�e le "+date+
						" � "+heure+" dans notre parking de la ville de "+ville+" a �t� valid�e avec succes.\n "
						+ "Vous pouvez acceder a notre application en utilisant le lien: "
						+ "http://localhost:8080/gestion_parking/index";
				new PersonneHome().sendMail(from, pwd,email, objet, message);
				String validation="Validation effectue� avec success, le client sera informer par email";
				
				response.sendRedirect("/gestion_parking/voir_TousReservations");
				//this.getServletContext().getRequestDispatcher("/voir_TousReservations").forward(request, response);
			}	
		}
		else if(session.getValue("id_gerant")!=null)
		{
			if(!request.getParameter("id_reservation").isEmpty())
			{
				int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
				Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
				reservation.setEtat("valid�e");
				new ReservationHome().update(reservation);
				String objet="Validation de reservation";
				String pwd="oqzjtvzbrtutfahg";
				String from="senemamadou1999@gmail.com";
				List<Reservation> allres=new ReservationHome().getAllReservationsUniques();
				Reservation current_res=null;
				for(int i=0;i<allres.size();i++)
				{
					if(allres.get(i).getIdreservation()==id_reservation)
					{
						current_res=allres.get(i);
					}
				}
				String email=current_res.getClient().getPersonne().getEmail();
				String prenom=current_res.getClient().getPersonne().getPrenom();
				String nom=current_res.getClient().getPersonne().getNom();
				String ville=current_res.getDepartement().getNomdepartement();
				String date=current_res.getDatereservation().toGMTString().substring(0,11);
				String heure=current_res.getHeurereservation();
				String message="Bonjour "+prenom+" "+nom+" \n Votre reservation de place effectu�e le "+date+
						" � "+heure+" dans notre parking de la ville de "+ville+" a �t� valid�e avec succes.\n "
						+ "Vous pouvez acceder a notre application en utilisant le lien: "
						+ "http://localhost:8080/gestion_parking/index";
				new PersonneHome().sendMail(from, pwd,email, objet, message);
				out.println("Validation effectue� avec success, le client sera informer par email");
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
