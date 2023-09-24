package client.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Personne;
import bdbeans.PersonneHome;

/**
 * Servlet implementation class ModifierProfile
 */
@WebServlet("/modifierProfile")
public class ModifierProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfile() {
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
			int id_personne=(int)session.getValue("id_client");
			Personne personne=new PersonneHome().findPersonneByID(id_personne);
			request.setAttribute("nom", personne.getNom());
			request.setAttribute("prenom", personne.getPrenom());
			request.setAttribute("telephone", personne.getTelephone());
			request.setAttribute("adresse", personne.getAdresse());
			RequestDispatcher disp=request.getRequestDispatcher("/modifierProfile.jsp");
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
		if(session.getValue("id_client")!=null&&!request.getParameter("nom").isEmpty()&&!request.getParameter("prenom").isEmpty()&&
				!request.getParameter("adresse").isEmpty()&&!request.getParameter("telephone").isEmpty())
		{
			int id_personne=(int)session.getValue("id_client");
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String telephone=request.getParameter("telephone");
			String adresse=request.getParameter("adresse");
			Personne personne=new PersonneHome().getPersonneById(id_personne);
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setTelephone(telephone);
			personne.setAdresse(adresse);
			new PersonneHome().update(personne);
			String modification="La modification de vos informations a été éffectuée avec succes";
			request.setAttribute("modification", modification);
		}
		else
		{
			String message="Veuillez saisir toutes les information demandées svp";
			request.setAttribute("avertissement", message);
		}
		doGet(request, response);
	}

}
