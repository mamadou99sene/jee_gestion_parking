package admin.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.ClientId;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;
import bdbeans.Voiture;
import bdbeans.VoitureHome;

/**
 * Servlet implementation class SuppressionClient
 */
@WebServlet("/suppressionClient")
public class SuppressionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionClient() {
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
		if(session.getValue("id_admin")!=null&&!request.getParameter("id_client").isEmpty()&&
				!request.getParameter("id_personne").isEmpty())
		{
			int id_personne=Integer.parseInt(request.getParameter("id_personne"));
			int id_client=Integer.parseInt(request.getParameter("id_client"));
			ClientId clientId=new ClientId();
			clientId.setIdclient(id_client);
			clientId.setIdpersonne(id_personne);
			Client client=new ClientHome().findClientByID(clientId);
			Personne personne=new PersonneHome().getPersonneById(client.getId().getIdpersonne());
			ArrayList<Voiture>les_voitures=(ArrayList<Voiture>) new VoitureHome().getAllVoitures();
			for(int i=0;i<les_voitures.size();i++)
			{
				if(les_voitures.get(i).getClient().getId().getIdclient()==client.getId().getIdclient())
				{
					new VoitureHome().delete(les_voitures.get(i));
				}
			}
			ArrayList<Reservation>les_reservations=(ArrayList<Reservation>) new ReservationHome().getAllReservationsUniques();
			for(int i=0;i<les_reservations.size();i++)
			{
				if(les_reservations.get(i).getClient().getId().getIdclient()==id_client)
				{
					new ReservationHome().delete(les_reservations.get(i));
				}
			}
			new ClientHome().delete(client);
			new PersonneHome().delete(personne);
			this.getServletContext().getRequestDispatcher("/voir_Clients").forward(request, response);
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
