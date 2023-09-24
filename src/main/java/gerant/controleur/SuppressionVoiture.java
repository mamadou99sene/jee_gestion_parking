package gerant.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Voiture;
import bdbeans.VoitureHome;

/**
 * Servlet implementation class SuppressionVoiture
 */
@WebServlet("/suppressionVoiture")
public class SuppressionVoiture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionVoiture() {
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
		if(session.getValue("id_gerant")!=null&&!request.getParameter("id_voiture").isEmpty())
		{
			int id_voiture=Integer.parseInt(request.getParameter("id_voiture"));
			Voiture voiture=new VoitureHome().findVoitureByID(id_voiture);
			new VoitureHome().delete(voiture);
			response.sendRedirect("/gestion_parking/details_Voitures");
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
