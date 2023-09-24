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
import bdbeans.GerantId;
import bdbeans.Personne;
import bdbeans.PersonneHome;

/**
 * Servlet implementation class Voir_Clients
 */
@WebServlet("/voir_Clients")
public class Voir_Clients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voir_Clients() {
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
			ArrayList<Client> les_clients=(ArrayList<Client>) new ClientHome().getAllClientsUniques();
			request.setAttribute("les_clients", les_clients);
			RequestDispatcher disp=request.getRequestDispatcher("/voir_Clients.jsp");
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
