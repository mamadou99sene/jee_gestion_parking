package admin.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import bdbeans.Horaire;
import bdbeans.HoraireHome;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;

/**
 * Servlet implementation class ModificationGerant
 */
@WebServlet("/modificationGerant")
public class ModificationGerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationGerant() {
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
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			Gerant gerant=null;
		   int id_gerant=Integer.parseInt(request.getParameter("id_gerant"));
		   ArrayList<Gerant> mes_gerants=(ArrayList<Gerant>) new GerantHome().getAllGerantsUniques();
		   for(int i=0;i<mes_gerants.size();i++)
		   {
			   if(mes_gerants.get(i).getId().getIdgerant()==id_gerant)
			   {
				   gerant=mes_gerants.get(i);
			   }
		   }
		   request.setAttribute("id_personne", gerant.getId().getIdpersonne());
		   request.setAttribute("id_gerant", gerant.getId().getIdgerant());
		   request.setAttribute("prenom", gerant.getPersonne().getPrenom());
		   request.setAttribute("nom", gerant.getPersonne().getNom());
		   request.setAttribute("email", gerant.getPersonne().getEmail());
		   request.setAttribute("telephone", gerant.getPersonne().getTelephone());
		   request.setAttribute("adresse", gerant.getPersonne().getAdresse());
		   request.setAttribute("num_cni", gerant.getPersonne().getNumerocarteidentite());
		   request.setAttribute("embauche", gerant.getDateembauche());
		   request.setAttribute("parking", new ParkingHome().getAllParkingsUniques());
		   request.setAttribute("horaire", new HoraireHome().getAllhoraires());
		   request.setAttribute("login", gerant.getPersonne().getLogin());
		   RequestDispatcher disp=request.getRequestDispatcher("/modificationGerant.jsp");
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
		if(!request.getParameter("id_gerant").isEmpty()&&!request.getParameter("nom").isEmpty()&&
				!request.getParameter("prenom").isEmpty()&&!request.getParameter("email").isEmpty()&&
				!request.getParameter("telephone").isEmpty()&&!request.getParameter("numero_cni").isEmpty()&&
				!request.getParameter("id_parking").isEmpty()&&!request.getParameter("id_horaire").isEmpty()&&
				!request.getParameter("login").isEmpty())
		{
			int id_gerant=Integer.parseInt(request.getParameter("id_gerant"));
			int id_personne=Integer.parseInt(request.getParameter("id_personne"));
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String email=request.getParameter("email");
			String adresse=request.getParameter("adresse");
			Date date=Date.valueOf(request.getParameter("date_embauche"));
			String telephone=request.getParameter("telephone");
			String num_cni=request.getParameter("numero_cni");
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			int id_horaire=Integer.parseInt(request.getParameter("id_horaire"));
			String login=request.getParameter("login");
			ArrayList<Gerant>allgerant=(ArrayList<Gerant>) new GerantHome().getAllGerants();
			GerantId gerantId=new GerantId();
			gerantId.setIdgerant(id_gerant);
			gerantId.setIdpersonne(id_personne);
			Gerant gerant=new GerantHome().findGerantByID(gerantId);
			Personne personne=new PersonneHome().getPersonneById(gerant.getId().getIdpersonne());
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setEmail(email);
			personne.setAdresse(adresse);
			personne.setTelephone(telephone);
			personne.setNumerocarteidentite(num_cni);
			personne.setLogin(login);
			new PersonneHome().update(personne);
			
			Horaire horaire=new HoraireHome().findHoraireByID(id_horaire);
			Parking parking=new ParkingHome().findParkingByID(id_parking);
			gerant.setHoraire(horaire);
			gerant.setParking(parking);
			gerant.setPersonne(personne);
			gerant.setDateembauche(date);
			new GerantHome().update(gerant);
			String succes="Modifications des informations du gerant effectuée avec succes";
			request.setAttribute("succes", succes);
		}
		else
		{
			String avertissement="veuillez remplir les informations demandées SVP!!!";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
