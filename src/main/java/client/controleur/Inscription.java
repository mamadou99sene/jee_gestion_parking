package client.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;

import bdbeans.Client;
import bdbeans.ClientHome;
import bdbeans.ClientId;
import bdbeans.Personne;
import bdbeans.PersonneHome;


@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Inscription() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/inscription.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		if(!request.getParameter("prenom").isEmpty()&&!request.getParameter("telephone").isEmpty()&&
				!request.getParameter("email").isEmpty()&&!request.getParameter("login").isEmpty()&&
				!request.getParameter("adresse").isEmpty()&&!request.getParameter("login").isEmpty())
		{
			BasicConfigurator.configure();
			String prenom=request.getParameter("prenom");
			String nom=request.getParameter("nom");
			String adresse=request.getParameter("adresse");
			String email=request.getParameter("email");
			String telephone=request.getParameter("telephone");
			String numero_cni=request.getParameter("numero_cni");
			String login=request.getParameter("login");
			String password=new PersonneHome().generation_password();
	
			Personne pers_control=new Personne();
			pers_control=new PersonneHome().findIfLoginExiste(login);
			if(pers_control==null)
			{
				pers_control=new PersonneHome().findIfEmailExiste(email);
				if(pers_control==null)
				{
					Personne personne=new Personne();
					personne.setPrenom(prenom);
					personne.setNom(nom);
					personne.setAdresse(adresse);
					personne.setTelephone(telephone);
					personne.setEmail(email);
					personne.setNumerocarteidentite(numero_cni);
					personne.setLogin(login);
					personne.setPassword(password);
					personne.setProfil("client");
					new PersonneHome().persist(personne);
					int id_personne=personne.getIdpersonne();
					ArrayList<Client> clients=new ArrayList<Client>();
					clients=(ArrayList)new ClientHome().getAllClientsUniques();
					ClientId clientId=new ClientId();
					//ici on recupere l'id du dernier client
					int dernierid_client=clients.get(clients.size()-1).getId().getIdclient();
					clientId.setIdpersonne(id_personne);
					//pour le nouveau inscrit, on prend le dernier id au niveau des clients et on y ajoute 1 pour l'affecter au nouveau inscrit
					clientId.setIdclient(dernierid_client+1);
					Client client=new Client();
					client.setId(clientId);
					client.setPersonne(personne);
					new ClientHome().persist(client);
					String objet="Activation de compte";
					String pwd="oqzjtvzbrtutfahg";
					String from="senemamadou1999@gmail.com";
					String message="Bonjour "+prenom+" "+nom+" votre login est "+login+" et votre mot de passe est "
					             +password+"."+" Vous pouvez utliser le lien suivant pour vous connecter a notre application"+
							     ": http://localhost:8080/gestion_parking/index";
					new PersonneHome().sendMail(from, pwd,email, objet, message);
					String inscriptionValide="vos information de connexion ont été envoyé a l'adresse "+ email+"\n "
							+ "Veuillez vous connecter a cette adresse pour recuperer vos informations de connexion";
					request.setAttribute("inscriptionValide", inscriptionValide);
				}
				else
				{
					String eRRorMes="Email deja existant, veuillez donner une autre adresse e-mail";
					request.setAttribute("eRRorMes", eRRorMes);
				}
			}
			else
			{
				String logError="Ce login existe deja, veillez choisir un autre login svp";
				request.setAttribute("logError", logError);
			}
		}
		else
		{
			String avertissement="veuillez remplir correctement les informations demandées";
			request.setAttribute("avertissement", avertissement);
		}
		doGet(request,response);
	}

}
