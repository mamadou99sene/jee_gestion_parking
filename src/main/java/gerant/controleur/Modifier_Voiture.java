package gerant.controleur;

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

import bdbeans.Voiture;
import bdbeans.VoitureHome;

/**
 * Servlet implementation class Modifier_Voiture
 */
@WebServlet("/modifier_Voiture")
public class Modifier_Voiture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_Voiture() {
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
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			int id_Voiture=Integer.parseInt(request.getParameter("id_voiture"));
			Voiture voiture=new VoitureHome().findVoitureByID(id_Voiture);
			request.setAttribute("immatriculation", voiture.getImmatriculation());
			request.setAttribute("id_voiture", voiture.getIdvoiture());
			request.setAttribute("marque", voiture.getMarque());
			request.setAttribute("model", voiture.getModel());
			request.setAttribute("serie", voiture.getSerie());
			RequestDispatcher disp=request.getRequestDispatcher("/modifications_Voitures.jsp");
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
		if(!request.getParameter("immatriculation").isEmpty()&&!request.getParameter("marque").isEmpty()&&
				!request.getParameter("model").isEmpty()&&!request.getParameter("serie").isEmpty()&&!request.getParameter("id_voiture").isEmpty()&&
				session.getValue("id_gerant")!=null)
		{
			int id_voiture=Integer.parseInt(request.getParameter("id_voiture"));
			String immatriculation=request.getParameter("immatriculation");
			String marque=request.getParameter("marque");
			String model=request.getParameter("model");
			String serie=request.getParameter("serie");
			Voiture voiture=new VoitureHome().findVoitureByID(id_voiture);
			voiture.setImmatriculation(immatriculation);
			voiture.setMarque(marque);
			voiture.setModel(model);
			voiture.setSerie(serie);
			new VoitureHome().update(voiture);
			response.sendRedirect("/gestion_parking/details_Voitures");
		}
		else
		{
			String avertissement="Veuillez remplir toutes les informations demandées svp";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
