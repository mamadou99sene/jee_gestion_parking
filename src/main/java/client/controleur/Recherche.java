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

import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
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
		if(session.getAttribute("id_client")!=null&&!request.getParameter("recherche").isEmpty())
		{
			this.getServletContext().getRequestDispatcher("/Header_Client").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			String nomdepartement=request.getParameter("recherche");
			List<Departement> departements=new DepartementHome().getDepartementsByName(nomdepartement);
			List<Parking> parkings=null;
			for(int i=0;i<departements.size();i++)
			{
				parkings=new ParkingHome().getParkingsByIdDepartement(departements.get(i));
			}
			if(parkings.size()>0)
			{
				System.out.println(parkings.size());
				request.setAttribute("les_parkings", parkings);
			}
			else
			{
				String message="Aucun parking pour ce nom de departement n'est trouvé";
				request.setAttribute("messagErr", message);
			}
			RequestDispatcher disp=request.getRequestDispatcher("/recherche.jsp");
			disp.include(request, response);
		}
		else
		{
			response.sendRedirect("/gestion_parking/index");
		}
	}

}
