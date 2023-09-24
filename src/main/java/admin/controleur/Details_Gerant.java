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

/**
 * Servlet implementation class Details_Gerant
 */
@WebServlet("/details_Gerant")
public class Details_Gerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_Gerant() {
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
			ArrayList<Gerant> gerants=(ArrayList<Gerant>) new GerantHome().getAllGerantsUniques();
			Gerant gerant=null;
			for(int i=0;i<gerants.size();i++)
			{
				if(gerants.get(i).getId().getIdgerant()==id_gerant)
				{
					request.setAttribute("details_gerant", gerants.get(i));
				}
			}
			RequestDispatcher disp=request.getRequestDispatcher("/details_Gerant.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
