package client.controleur;

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

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.Detailslocation;
import bdbeans.DetailslocationHome;
import bdbeans.Voiture;
import bdbeans.VoitureHome;

/**
 * Servlet implementation class Location
 */
@WebServlet("/location")
public class Location extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Location() {
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
			//this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
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
			List<Detailslocation> mes_locations=new DetailslocationHome().getAllDetailslocationsUniques();
			if(mes_locations.size()>0)
			{
				request.setAttribute("mes_locations", mes_locations);
			}
			else
			{
				String message="Nous n'avons enregistré aucune location sous votre identité!!!";
				request.setAttribute("message", message);
			}
			
			RequestDispatcher disp=request.getRequestDispatcher("/location.jsp");
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
