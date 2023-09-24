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

import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.DepartementId;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Region;
import bdbeans.RegionHome;

/**
 * Servlet implementation class Addparking
 */
@WebServlet("/addparking")
public class Addparking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addparking() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		if(session.getValue("id_admin")!=null)
		{
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			RegionHome regionhome=new RegionHome();
			ArrayList <Region>regions=(ArrayList) regionhome.getAllRegions();
			
			request.setAttribute("regions",regions);
			this.getServletContext().getRequestDispatcher("/addparking.jsp").include(request, response);
		}
		else
		{
			response.sendRedirect("/gestion_parking/index");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(); 
		if(session.getValue("id_admin")!=null&& !request.getParameter("email").isEmpty()&&!request.getParameter("telephone").isEmpty()
				&&!request.getParameter("region").isEmpty()&&!request.getParameter("departement").isEmpty()
				&&!request.getParameter("heure_ouverture").isEmpty()&&!request.getParameter("heure_fermeture").isEmpty())
		{
			int id_admin=(int) session.getValue("id_admin");
			String email=request.getParameter("email");
		    String telephone=request.getParameter("telephone");
		    int idregion=Integer.parseInt(request.getParameter("region"));
		    int iddepartement=Integer.parseInt(request.getParameter("departement"));
		    String heure_ouverture=request.getParameter("heure_ouverture");
		    String heure_fermeture=request.getParameter("heure_fermeture");
		    String etat=request.getParameter("etat");
		    int nombre_place=Integer.parseInt(request.getParameter("nombreP"));
		    int nombre_gerant=Integer.parseInt(request.getParameter("nombreG"));
		    DepartementId departementId=new DepartementId();
		    departementId.setIdregion(idregion);
		    departementId.setIddepartement(iddepartement);
		    Departement departement=new Departement();
		    departement.setId(departementId);
		    Parking parking=new Parking();
		    parking.setEmail(email);
		    parking.setTetephone(telephone);
		    parking.setHeureoverture(heure_ouverture);
		    parking.setHeurefermeture(heure_fermeture);
		    parking.setNombregerant(nombre_gerant);
		    parking.setNombreplace(nombre_place);
		    parking.setEtat(etat);
		    parking.setDepartement(departement);
		    new ParkingHome().persist(parking);
		    String succes="Ajout parking effectué avec success";
		    request.setAttribute("ajout", succes);
		    
		}
		else
		{
			String avertissement="veuillez remplir correctement les informations demandées";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request,response);
	}
	

}
