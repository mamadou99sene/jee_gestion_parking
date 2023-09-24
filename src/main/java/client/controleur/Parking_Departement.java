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

import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.DepartementId;
import bdbeans.Parking;
import bdbeans.ParkingHome;

/**
 * Servlet implementation class Parking_Departement
 */
@WebServlet("/parking_Departement")
public class Parking_Departement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parking_Departement() {
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
		if(session.getValue("id_client")!=null&&!request.getParameter("id_departement").isEmpty())
		{
			this.getServletContext().getRequestDispatcher("/Header_Client").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_personne=(int) session.getValue("id_client");
			int id_departement=Integer.parseInt(request.getParameter("id_departement"));
			Departement departement=null;
			ArrayList<Departement>departements=(ArrayList<Departement>) new DepartementHome().getAllDepartements();
			for(int i=0;i<departements.size();i++)
			{
				if(departements.get(i).getId().getIddepartement()==id_departement)
				{
					departement=departements.get(i);
				}
			}
			ArrayList<Parking> les_parkings_du_dep=(ArrayList<Parking>) new ParkingHome().getParkingsByIdDepartement(departement);
			if(les_parkings_du_dep.size()>0)
			{
				request.setAttribute("les_parkings_du_dep", les_parkings_du_dep);
			}
			else
			{
				String messagErr="Il n'existe pas de parking pour ce departement";
				request.setAttribute("messagErr", messagErr);
				
			}
			RequestDispatcher disp=request.getRequestDispatcher("/parking_Departement.jsp");
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
