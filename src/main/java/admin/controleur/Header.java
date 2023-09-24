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

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.ParkingHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Header
 */
@WebServlet("/header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
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
			int id_personne=(int)session.getValue("id_admin");
			Personne personne=new PersonneHome().getPersonneById(id_personne);
			request.setAttribute("personne", personne);
			request.setAttribute("non_valide", new ReservationHome().getReservationNonValide().size());
			RequestDispatcher disp=request.getRequestDispatcher("/header.jsp");
			disp.include(request, response);
		}
		else if(session.getValue("id_gerant")!=null)
		{
			int id_personne=(int)session.getValue("id_gerant");
			Personne personne=new PersonneHome().getPersonneById(id_personne);
			ArrayList<Gerant> gerants=(ArrayList<Gerant>) new GerantHome().getAllGerants();
			Gerant gerant=null;
			for(int i=0;i<gerants.size();i++)
			{
				if(gerants.get(i).getId().getIdpersonne()==id_personne)
				{
					gerant=gerants.get(i);
				}
			}
			request.setAttribute("personne", personne);
			request.setAttribute("non_valide", new ReservationHome().getReservationNonValideByGerant(gerant).size());
			RequestDispatcher disp=request.getRequestDispatcher("/header.jsp");
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
