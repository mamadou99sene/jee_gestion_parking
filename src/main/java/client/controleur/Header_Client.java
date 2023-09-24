package client.controleur;

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
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Header_Client
 */
@WebServlet("/Header_Client")
public class Header_Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header_Client() {
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
			int id_personne=(int)session.getValue("id_client");
			Personne personne=new PersonneHome().getPersonneById(id_personne);
			Client client=null;
			ArrayList<Client> nos_clients=(ArrayList<Client>) new ClientHome().getAllClients();
			for(int i=0;i<nos_clients.size();i++)
			{
				if(nos_clients.get(i).getId().getIdpersonne()==id_personne)
				{
				  client=nos_clients.get(i);	
				}
			}
			request.setAttribute("prenom_client", personne);
			request.setAttribute("reservation_clientNV", new ReservationHome().getReservationNonValidePourClient(client).size());
			RequestDispatcher disp=request.getRequestDispatcher("/header_Client.jsp");
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
