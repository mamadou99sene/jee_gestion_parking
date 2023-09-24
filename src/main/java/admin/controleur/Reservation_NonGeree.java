package admin.controleur;

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

import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Reservation_NonGeree
 */
@WebServlet("/reservation_NonGeree")
public class Reservation_NonGeree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation_NonGeree() {
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
			List<Reservation> reservations_non_Geree=new ReservationHome().AdmingetReservationNonGeree();
			if(reservations_non_Geree.size()>0)
			{
				request.setAttribute("reservations_Non_Geree", reservations_non_Geree);
			}
			else
			{
				String message="Aucune reservations non encore gérées pour le moment";
				request.setAttribute("message", message);
			}
			RequestDispatcher disp=request.getRequestDispatcher("/reservations_Non_Gerees.jsp");
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
