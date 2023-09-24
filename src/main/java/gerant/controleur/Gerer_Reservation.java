package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Gerer_Reservation
 */
@WebServlet("/gerer_Reservation")
public class Gerer_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gerer_Reservation() {
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
		if(session.getValue("id_gerant")!=null&&!request.getParameter("id_reservation").isEmpty())
		{
		    int id_personne=(int)session.getValue("id_gerant");
		    int id_reservation=Integer.parseInt(request.getParameter("id_reservation"));
		    Gerant gerant=null;
		    List<Gerant> les_gerants=new GerantHome().getAllGerantsUniques();
		    for(int i=0;i<les_gerants.size();i++)
		    {
		    	if(les_gerants.get(i).getId().getIdpersonne()==id_personne)
		    	{
		    		gerant=les_gerants.get(i);
		    	}
		    }
		    Reservation reservation=new ReservationHome().findReservationByID(id_reservation);
		    reservation.setGerant(gerant);
		    new ReservationHome().update(reservation);
		    response.sendRedirect("/gestion_parking/reservation_Nonencore_Gere");
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
