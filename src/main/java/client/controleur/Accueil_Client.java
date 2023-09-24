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

import bdbeans.DepartementHome;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;

/**
 * Servlet implementation class Accueil_Client
 */
@WebServlet("/accueil_Client")
public class Accueil_Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil_Client() {
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
			int id_personne=(int) session.getValue("id_client");
			ArrayList<Parking> les_parkings=(ArrayList<Parking>) new ParkingHome().getAllParkingsUniques();
			request.setAttribute("les_parkings", les_parkings);
			RequestDispatcher disp=request.getRequestDispatcher("/accueil_Client.jsp");
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
