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
 * Servlet implementation class Changement_mdp
 */
@WebServlet("/changement_mdp")
public class Changement_mdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changement_mdp() {
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
		if(session.getValue("id_admin")!=null|session.getValue("id_gerant")!=null)
		{
			this.getServletContext().getRequestDispatcher("/header").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			RequestDispatcher disp=request.getRequestDispatcher("/changement_mdp.jsp");
			disp.include(request, response);
		}
		else if(session.getValue("id_client")!=null)
		{
			this.getServletContext().getRequestDispatcher("/Header_Client").include(request, response);
			this.getServletContext().getRequestDispatcher("/tableau_Bord").include(request, response);
			RequestDispatcher disp=request.getRequestDispatcher("/changement_mdp.jsp");
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
		if(session.getValue("id_admin")!=null)
		{
			if(!request.getParameter("password").isEmpty()&&!request.getParameter("email").isEmpty()&&
					!request.getParameter("vpassword").isEmpty())
			{
				String email=request.getParameter("email");
				String vpassword=request.getParameter("vpassword");
				String password=request.getParameter("password");
				Personne pers_control=new PersonneHome().findIfEmailExiste(email);
				int id_personne=(int)session.getValue("id_admin");
				if(password.equals(vpassword)&&pers_control!=null)
				{
					Personne personne=new PersonneHome().getPersonneById(id_personne);
					personne.setPassword(password);
					new PersonneHome().update(personne);
					String prenom=personne.getPrenom();
					String nom=personne.getNom();
					String objet="Changement de mot de passe";
					String pwd="oqzjtvzbrtutfahg";
					String from="senemamadou1999@gmail.com";
					
					String message="Bonjour "+prenom+" "+nom+" \n  Votre mot de passe a été definitivement changé. "
							+ "Votre nouveau mot de passe est "+password+" . Vous pouvez utilisé ce mot de passe pour "
							+ "vous connecter a notre application en cliquant sur le lien suivant http://localhost:8080/gestion_parking/index";
					new PersonneHome().sendMail(from, pwd,email, objet, message);
					String changement="vos informations de connexion ont été changées et envoyées a l'adresse "+ email+"\n "
							+ "Veuillez vous connecter a cette adresse pour recuperer vos informations de connexion";
					request.setAttribute("changement", changement);
				}
				else
				{
					String error="Vos mot de passes ne correspondent pas ou email inexistante";
					request.setAttribute("error", error);
				}
			}
			else
			{
				String avertissement="veuillez remplir correctement les informations demandées";
				request.setAttribute("avertissement", avertissement);
			}
		}
		else if(session.getValue("id_gerant")!=null)
		{
			if(!request.getParameter("email").isEmpty()&&!request.getParameter("password").isEmpty()&&
					!request.getParameter("vpassword").isEmpty())
			{
				String email=request.getParameter("email");
				String vpassword=request.getParameter("vpassword");
				String password=request.getParameter("password");
				Personne pers_control=new PersonneHome().findIfEmailExiste(email);
				if(password.equals(vpassword)&&pers_control!=null)
				{
					int id_personne=(int)session.getValue("id_gerant");
					Personne personne=new PersonneHome().getPersonneById(id_personne);
					personne.setPassword(password);
					new PersonneHome().update(personne);
					String prenom=personne.getPrenom();
					String nom=personne.getNom();
					String objet="Changement de mot de passe";
					String pwd="oqzjtvzbrtutfahg";
					String from="senemamadou1999@gmail.com";
					
					String message="Bonjour "+prenom+" "+nom+" \n  Votre mot de passe a été definitivement changé. "
							+ "Votre nouveau mot de passe est "+password+" . Vous pouvez utilisé ce mot de passe pour "
							+ "vous connecter a notre application en cliquant sur le lien suivant http://localhost:8080/gestion_parking/index";
					new PersonneHome().sendMail(from, pwd,email, objet, message);
					String changement="vos informations de connexion ont été changées et envoyées a l'adresse "+ email+"\n "
							+ "Veuillez vous connecter a cette adresse pour recuperer vos informations de connexion";
					request.setAttribute("changement", changement);
				}
				else
				{
					String error="Vos mot de passes ne correspondent pas ou email inexistante";
					request.setAttribute("error", error);
				}
			}
			else
			{
				String avertissement="veuillez remplir correctement les informations demandées";
				request.setAttribute("avertissement", avertissement);
			}
		}
		else if(session.getValue("id_client")!=null)
		{
			if(!request.getParameter("email").isEmpty()&&!request.getParameter("password").isEmpty()&&
					!request.getParameter("vpassword").isEmpty())
			{
				String email=request.getParameter("email");
				String vpassword=request.getParameter("vpassword");
				String password=request.getParameter("password");
				Personne pers_control=new PersonneHome().findIfEmailExiste(email);
				int id_personne=(int)session.getValue("id_client");
				Personne personne=new PersonneHome().getPersonneById(id_personne);
				if(password.equals(vpassword)&&pers_control!=null&&personne.getEmail().equals(email))
				{
					personne.setPassword(password);
					new PersonneHome().update(personne);
					String prenom=personne.getPrenom();
					String nom=personne.getNom();
					String objet="Changement de mot de passe";
					String pwd="oqzjtvzbrtutfahg";
					String from="senemamadou1999@gmail.com";
					
					String message="Bonjour "+prenom+" "+nom+" \n  Votre mot de passe a été definitivement changé. "
							+ "Votre nouveau mot de passe est "+password+" . Vous pouvez utilisé ce mot de passe pour "
							+ "vous connecter a notre application en cliquant sur le lien suivant http://localhost:8080/gestion_parking/index";
					new PersonneHome().sendMail(from, pwd,email, objet, message);
					String changement="vos informations de connexion ont été changées et envoyées a l'adresse "+ email+"\n "
							+ "Veuillez vous connecter a cette adresse pour recuperer vos informations de connexion";
					request.setAttribute("changement", changement);
				}
				else
				{
					String error="Vos mot de passes ne correspondent pas ou email inexistante";
					request.setAttribute("error", error);
				}
			}
			else
			{
				String avertissement="veuillez remplir correctement les informations demandées";
				request.setAttribute("avertissement", avertissement);
			}
		}
		else
		{
			response.sendRedirect("/gestion_parking/index");
		}
		doGet(request, response);
	}

}
