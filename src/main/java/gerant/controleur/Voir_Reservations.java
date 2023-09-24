package gerant.controleur;

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
import bdbeans.ClientId;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Voir_Reservations
 */
@WebServlet("/voir_Reservations")
public class Voir_Reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voir_Reservations() {
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
			int id_personne= (int) session.getValue("id_gerant");
			Gerant gerant=null;
			ArrayList<Gerant> gerants=(ArrayList<Gerant>) new GerantHome().getAllGerantsUniques();
			for(int i=0;i<gerants.size();i++)
			{
				if(gerants.get(i).getId().getIdpersonne()==id_personne)
				{
					gerant=gerants.get(i);
				}
			}
			ArrayList<Reservation>les_reservations=(ArrayList<Reservation>) new ReservationHome().getAllReservations(gerant);
			if(les_reservations.size()==0)
			{
				String message="Aucune reservation à gerer en ce moment";
				request.setAttribute("message", message);
			}
			else
			{
				request.setAttribute("les_reservations", les_reservations);
			}
			
			RequestDispatcher disp=request.getRequestDispatcher("/voir_Reservations.jsp");
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
