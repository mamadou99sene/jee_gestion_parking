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

import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.GerantId;
import bdbeans.Personne;
import bdbeans.PersonneHome;

/**
 * Servlet implementation class SuppressionGerant
 */
@WebServlet("/suppressionGerant")
public class SuppressionGerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionGerant() {
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
		if(session.getValue("id_admin")!=null&&!request.getParameter("id_gerant").isEmpty())
		{
			int id_gerant=Integer.parseInt(request.getParameter("id_gerant"));
			ArrayList<Gerant> les_gerants=(ArrayList<Gerant>) new GerantHome().getAllGerants();
			for(int i=0;i<les_gerants.size();i++)
			{
				if(les_gerants.get(i).getId().getIdgerant()==id_gerant)
				{
					Personne personne=new PersonneHome().findPersonneByID(les_gerants.get(i).getId().getIdpersonne());
					new GerantHome().delete(les_gerants.get(i));
					new PersonneHome().delete(personne);	
				}
			}
			this.getServletContext().getRequestDispatcher("/voir_Gerant").forward(request, response);
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
