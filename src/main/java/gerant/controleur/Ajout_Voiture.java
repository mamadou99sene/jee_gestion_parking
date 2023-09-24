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

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;
import bdbeans.Voiture;
import bdbeans.VoitureHome;

/**
 * Servlet implementation class Ajout_Voiture
 */
@WebServlet("/ajout_Voiture")
public class Ajout_Voiture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_Voiture() {
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
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			ArrayList<Client> allclients=(ArrayList<Client>) new ClientHome().getAllClientsUniques();
			request.setAttribute("allclients", allclients);
			RequestDispatcher disp=request.getRequestDispatcher("/ajout_Voiture.jsp");
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
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		if(session.getValue("id_gerant")!=null&&!request.getParameter("immatriculation").isEmpty()&&
				!request.getParameter("marque").isEmpty()&&!request.getParameter("model").isEmpty()&&
				!request.getParameter("serie").isEmpty()&&!request.getParameter("id_client").isEmpty())
		{
			String immatriculation=request.getParameter("immatriculation");
			String model=request.getParameter("model");
			String marque=request.getParameter("marque");
			String serie=request.getParameter("serie");
			int id_client=Integer.parseInt(request.getParameter("id_client"));
			Voiture voiture=new Voiture();
			voiture.setImmatriculation(immatriculation);
			voiture.setMarque(marque);
			voiture.setModel(model);
			voiture.setSerie(serie);
			Client client=null;
			ArrayList<Client> clients=(ArrayList<Client>) new ClientHome().getAllClientsUniques();
			for(int i=0;i<clients.size();i++)
			{
				if(clients.get(i).getId().getIdclient()==id_client)
				{
					client=clients.get(i);
				}
			}
			voiture.setClient(client);
			new VoitureHome().persist(voiture);
			String succes=" Ajout de la voiture d'immatriculation "+immatriculation+" efectué avec succes";
			request.setAttribute("succes", succes);
		}
		else
		{
			String avertissement="veuillez remplir correctement les informations demandées";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
