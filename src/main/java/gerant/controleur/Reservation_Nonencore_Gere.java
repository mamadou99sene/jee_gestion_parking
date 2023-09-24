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

import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Reservation_Nonencore_Gere
 */
@WebServlet("/reservation_Nonencore_Gere")
public class Reservation_Nonencore_Gere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation_Nonencore_Gere() {
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
			int id_personne=(int)session.getValue("id_gerant");
			Gerant gerant=null;
			List<Gerant> gerants=new GerantHome().getAllGerantsUniques();
			for(int i=0;i<gerants.size();i++)
			{
				if(gerants.get(i).getId().getIdpersonne()==id_personne)
				{
					gerant=gerants.get(i);
				}
			}
			List<Reservation> res_non_gere=new ReservationHome().getAllReservationsNonGere(gerant);
			if(res_non_gere.size()>0)
			{
				request.setAttribute("res_non_gere", res_non_gere);
			}
			else
			{
				String non_gere="Aucune reservation non encore gérée pour votre parking";
				request.setAttribute("non_gere", non_gere);
			}
			
			RequestDispatcher disp=request.getRequestDispatcher("/reservation_Nonencore_Gere.jsp");
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
