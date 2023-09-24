package client.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdbeans.Personne;
import bdbeans.PersonneHome;

/**
 * Servlet implementation class Mdp_oublie
 */
@WebServlet("/mdp_oublie")
public class Mdp_oublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mdp_oublie() {
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
		RequestDispatcher disp=request.getRequestDispatcher("mdp_oublie.jsp");
		disp.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!request.getParameter("email").isEmpty()&&!request.getParameter("login").isEmpty())
		{
			String email=request.getParameter("email");
			String login=request.getParameter("login");
			Personne personne=new PersonneHome().recuperation_mdp(login, email);
			if(personne!=null)
			{
				
				String password=new PersonneHome().generation_password();
				personne.setPassword(password);
				new PersonneHome().update(personne);
				String prenom=personne.getPrenom();
				String nom=personne.getNom();
				String objet="Recuperation de mot de passe";
				String pwd="oqzjtvzbrtutfahg";
				String from="senemamadou1999@gmail.com";
				String message="Bonjour "+prenom+" "+nom+" votre login est "+login+" et votre nouveau mot de passe est "
				             +password+"."+"\n Vous pouvez utliser le lien suivant pour vous connecter a notre application"+
						     ": http://localhost:8080/gestion_parking/index";
				new PersonneHome().sendMail(from, pwd,email, objet, message);
				String recuperation="vos nouvelles informations de connexion ont été envoyé a l'adresse "+ email+"\n "
						+ "Veuillez vous connecter a cette adresse pour recuperer vos informations de connexion";
				request.setAttribute("recuperation", recuperation);
			}
			else
			{
				String error="Login ou email incorrect";
				request.setAttribute("error", error);
			}
		}
		else
		{
			String message="veuillez remplir toutes les informations demandées";
			request.setAttribute("avertissement", message);
		}
		doGet(request, response);
	}

}
