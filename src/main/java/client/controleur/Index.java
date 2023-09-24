package client.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdbeans.Personne;
import bdbeans.PersonneHome;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Index() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(Cookie cookie:cookies)
			{
				if(cookie.getName().equals("login"))
				{
					request.setAttribute("login", cookie.getValue());
				}
			}
		}
		RequestDispatcher disp=request.getRequestDispatcher("/index.jsp");
		disp.include(request, response);
		//this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!request.getParameter("login").isEmpty()&&!request.getParameter("password").isEmpty())
		{
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			Personne personne=new Personne();
			personne=new PersonneHome().connexion(login, password);
			if(personne!=null)
			{
				Cookie cookie=new Cookie("login",login);
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
				if(personne.getProfil().equals("admin"))
				{
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(600);
					session.setAttribute("id_admin", personne.getIdpersonne());
					response.sendRedirect("/gestion_parking/accueil");
				}
				else if(personne.getProfil().equals("gerant"))
				{
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(600);
					session.setAttribute("id_gerant", personne.getIdpersonne());
					response.sendRedirect("/gestion_parking/accueil_Gerant");
				}
				else
				{
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(600);
					session.setAttribute("id_client", personne.getIdpersonne());
					response.sendRedirect("/gestion_parking/accueil_Client");
				}
			}
			else
			{
				String message="Login ou mot de passe incorrecte !!!";
				request.setAttribute("message", message);
				//response.sendRedirect("/gestion_parking/index");
			}
		}
		doGet(request,response);
	}

}
