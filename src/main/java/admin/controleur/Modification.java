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

import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.DepartementId;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.RegionHome;

/**
 * Servlet implementation class Modification
 */
@WebServlet("/modification")
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification() {
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
		if(session.getValue("id_admin")!=null&&!request.getParameter("id_parking").isEmpty())
		{
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			Parking parking=new ParkingHome().getParkingById(id_parking);
			request.setAttribute("id_parking",id_parking);
			request.setAttribute("email",parking.getEmail());
			request.setAttribute("telephone",parking.getTetephone());
			request.setAttribute("nombreplace",parking.getNombreplace());
			request.setAttribute("heure_ouverture",parking.getHeureoverture());
			request.setAttribute("heure_fermeture",parking.getHeurefermeture());
			request.setAttribute("nombre_gerant",parking.getNombregerant());
			request.setAttribute("region",parking.getDepartement().getRegion());
			request.setAttribute("id_parking",id_parking);
			RequestDispatcher disp=request.getRequestDispatcher("/modification.jsp");
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
		if(session.getValue("id_admin")!=null&& !request.getParameter("email").isEmpty()&&
		  !request.getParameter("telephone").isEmpty() && !request.getParameter("nombreplace").isEmpty()&&
		  !request.getParameter("departement").isEmpty()&&!request.getParameter("region").isEmpty()&&
		  !request.getParameter("id_parking").isEmpty())
		{
			String email=request.getParameter("email");
			String telephone=request.getParameter("telephone");
			int nombreplace=Integer.parseInt(request.getParameter("nombreplace"));
			String heure_ouverture=request.getParameter("heure_ouv");
			String heure_fermeture=request.getParameter("heure_ferm");
			int nombregerant=Integer.parseInt(request.getParameter("nombregerant"));
			String etat=request.getParameter("etat");
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			int id_departement=Integer.parseInt(request.getParameter("departement"));
			int id_region=Integer.parseInt(request.getParameter("region"));
			Parking parking=new ParkingHome().findParkingByID(id_parking);
			parking.setEmail(email);
			parking.setTetephone(telephone);
			parking.setNombreplace(nombreplace);
			parking.setHeureoverture(heure_ouverture);
			parking.setHeurefermeture(heure_fermeture);
			parking.setNombregerant(nombregerant);
			parking.setEtat(etat);
			DepartementId departementId=new DepartementId();
			departementId.setIddepartement(id_departement);
			departementId.setIdregion(id_region);
			Departement departement=null;
			ArrayList <Departement> alldepartement=(ArrayList<Departement>) new DepartementHome().getAllDepartementsUniques(id_region);
			for(int i=0;i<alldepartement.size();i++)
			{
				if(parking.getDepartement().getId().getIddepartement()==alldepartement.get(i).getId().getIddepartement())
				{
					departement=alldepartement.get(i);
				}
			}
			departement.setId(departementId);
			parking.setDepartement(departement);
			new ParkingHome().update(parking);
			String modif="Modification effectuée avec success";
			request.setAttribute("modif", modif);
		}
		else
		{
			String avertissement="Veuillez remplir correctement les informations demandées !!!";
			request.setAttribute("avertissement", avertissement);
		}
		
		doGet(request, response);
	}

}
