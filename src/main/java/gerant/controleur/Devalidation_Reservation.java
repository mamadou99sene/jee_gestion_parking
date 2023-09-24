package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Devalidation_Reservation
 */
@WebServlet("/devalidation_Reservation")
public class Devalidation_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Devalidation_Reservation() {
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
			if(!request.getParameter("id_reservation").isEmpty())
			{
				int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
				Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
				reservation.setEtat("non validée");
				new ReservationHome().update(reservation);
				response.sendRedirect("/gestion_parking/voir_Reservations");
			}
		}
		else if(session.getValue("id_admin")!=null)
		{
			if(!request.getParameter("id_reservation").isEmpty())
			{
				int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
				Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
				reservation.setEtat("non validée");
				new ReservationHome().update(reservation);
				response.sendRedirect("/gestion_parking/voir_TousReservations");
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
