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

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.ClientId;
import bdbeans.Gerant;
import bdbeans.GerantHome;

/**
 * Servlet implementation class Details_Client
 */
@WebServlet("/details_Client")
public class Details_Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_Client() {
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
		if(session.getValue("id_admin")!=null&&!request.getParameter("id_client").isEmpty()&&!request.getParameter("id_personne").isEmpty())
		{
			int id_personne=Integer.parseInt(request.getParameter("id_personne"));
			int id_client=Integer.parseInt(request.getParameter("id_client"));
			//ClientId clientId=new ClientId();
			//clientId.setIdclient(id_client);
			//clientId.setIdpersonne(id_personne);
			//request.setAttribute("client", new ClientHome().findClientByID(clientId));
			Client client=null;
			List<Client> clients=new ClientHome().getAllClientsUniques();
			for(int i=0;i<clients.size();i++)
			{
				if(clients.get(i).getId().getIdpersonne()==id_personne)
				{
					client=clients.get(i);
				}
			}
			request.setAttribute("client", client);
			RequestDispatcher disp=request.getRequestDispatcher("/details_Client.jsp");
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
