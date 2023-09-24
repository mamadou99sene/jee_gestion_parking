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
 * Servlet implementation class Ajout_gerant
 */
@WebServlet("/ajout_gerant")
public class Ajout_gerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_gerant() {
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
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			ArrayList<Parking> allparking=(ArrayList<Parking>) new ParkingHome().getAllParkingsUniques();
			ArrayList<Horaire> allhoraire=(ArrayList<Horaire>) new HoraireHome().getAllhoraires();
			request.setAttribute("allparking", allparking);
			request.setAttribute("allhoraire", allhoraire);
			RequestDispatcher disp=request.getRequestDispatcher("/ajout_gerant.jsp");
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
		if(session.getValue("id_admin")!=null&&!request.getParameter("email").isEmpty()&&!request.getParameter("telephone").isEmpty()&&
				!request.getParameter("numero_cni").isEmpty()&&!request.getParameter("prenom").isEmpty()&&!request.getParameter("adresse").isEmpty()&&
			    !request.getParameter("login").isEmpty())
		{
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String email=request.getParameter("email");
			String telephone=request.getParameter("telephone");
			String adresse=request.getParameter("adresse");
			String numero_cni=request.getParameter("numero_cni");
			Date date=Date.valueOf(request.getParameter("date_embauche"));
			String login=request.getParameter("login");
			int id_parking=Integer.parseInt(request.getParameter("id_parking"));
			int id_horaire=Integer.parseInt(request.getParameter("id_horaire"));
			String password=new PersonneHome().generation_password();
			Personne personne=new Personne();
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setEmail(email);
			personne.setTelephone(telephone);
			personne.setAdresse(adresse);
			personne.setNumerocarteidentite(numero_cni);
			personne.setLogin(login);
			personne.setPassword(password);
			personne.setProfil("gerant");
			new PersonneHome().persist(personne);
			ArrayList<Gerant> allgerant=(ArrayList<Gerant>) new GerantHome().getAllGerants();
			int dernier_id=allgerant.get(allgerant.size()-1).getId().getIdgerant();
			GerantId gerantId=new GerantId();
			gerantId.setIdpersonne(personne.getIdpersonne());
			gerantId.setIdgerant(dernier_id+1);
			Horaire horaire=new HoraireHome().findHoraireByID(id_horaire);
			Parking parking=new ParkingHome().findParkingByID(id_parking);
			String codePark=parking.getEmail().substring(0,3);
			String chaine_aleatoire=new PersonneHome().generation_password().substring(0,4);
			String code=codePark.concat(chaine_aleatoire);
			Gerant gerant=new Gerant();
			gerant.setId(gerantId);
			gerant.setPersonne(personne);
			gerant.setCode(code);
			gerant.setDateembauche(date);
			gerant.setHoraire(horaire);
			gerant.setParking(parking);
			new GerantHome().persist(gerant);
			String objet="Activation de compte";
			String pwd="oqzjtvzbrtutfahg";
			String from="senemamadou1999@gmail.com";
			String message="Bonjour "+prenom+" "+nom+" votre login est "+login+" et votre mot de passe est "
			             +password+"."+" Vous pouvez utliser le lien suivant pour vous connecter a notre application"+
					     ": http://localhost:8080/gestion_parking/index";
			new PersonneHome().sendMail(from, pwd,email, objet, message);
			String ajout="Les informations de connexion du gerant ont été envoyé a l'adresse "+email+" \nVeuillez lui informer de se connecter a cette adresse pour recuperer ces informations de connexion";
			request.setAttribute("ajout", ajout);
		}
		else
		{
			String avertissement="veuillez remplir correctement les informations demandées";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request, response);
	}

}
