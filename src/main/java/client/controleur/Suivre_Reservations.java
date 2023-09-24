package client.controleur;

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

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.ReservationHome;
import bdbeans.Reservation;

/**
 * Servlet implementation class Suivre_Reservations
 */
@WebServlet("/suivre_Reservations")
public class Suivre_Reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suivre_Reservations() {
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
		if(session.getValue("id_client")!=null)
		{
			this.getServletContext().getRequestDispatcher("/Header_Client").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_personne=(int)session.getValue("id_client");
			Client client=null;
			List<Client> mes_clients=new ClientHome().getAllClientsUniques();
			for(int i=0;i<mes_clients.size();i++)
			{
				if(mes_clients.get(i).getId().getIdpersonne()==id_personne)
				{
					client=mes_clients.get(i);
				}
			}
			List<Reservation> res_client=new ReservationHome().suivreReservationClient(client);
			if(res_client.size()>0)
			{
				request.setAttribute("mes_reservations_deja_gere", res_client);
			}
			else
			{
				String message="Vous n'avez effectué aucune reservation dèja géré par nos agents!!!";
				request.setAttribute("message", message);
			}
			
			RequestDispatcher disp=request.getRequestDispatcher("/suivre_Reservations.jsp");
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
