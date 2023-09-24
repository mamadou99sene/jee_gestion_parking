package admin.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.DepartementHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.ReservationHome;

/**
 * Servlet implementation class Tableau_Bord
 */
@WebServlet("/tableau_Bord")
public class Tableau_Bord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tableau_Bord() {
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
			RequestDispatcher disp=request.getRequestDispatcher("/tableau_Bord.jsp");
			disp.include(request, response);
		}
		else if(session.getValue("id_gerant")!=null)
		{
			
			RequestDispatcher disp=request.getRequestDispatcher("/bord_gerant.jsp");
			disp.include(request, response);
		}
		else if(session.getValue("id_client")!=null)
		{
			request.setAttribute("departements",new DepartementHome().getAllDepartements());
			RequestDispatcher disp=request.getRequestDispatcher("/bord_client.jsp");
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
