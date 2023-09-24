<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
    pageEncoding='ISO-8859-1'%>
    <%@ page import="bdbeans.Reservation" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='ISO-8859-1'>
<title>Insert title here</title>
<link rel='icon' type='image/png' sizes='16x16' href='images/favicon.png'>
    <!-- Custom Stylesheet -->
    <link href='css/style.css' rel='stylesheet'>
</head>
<body>
 <div class='content-body'>

            <div class='row page-titles mx-0'>
                <div class='col p-md-0'>
                    <ol class='breadcrumb'>
                        <li class='breadcrumb-item'><a href='javascript:void(0)'>Dashboard</a></li>
                        <li class='breadcrumb-item active'><a href='javascript:void(0)'>Home</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->

            <div class='container-fluid'>
                <% 
                  if(request.getAttribute("mes_reservations_deja_gere")!=null)
                  {
                	List<Reservation> list=(List<Reservation>)request.getAttribute("mes_reservations_deja_gere");  
                   for(int i=0;i<list.size();i++)
                   {
                	   out.println("<div class='col-lg-12'>");
            		   out.println("<div class='card'>");
            			 out.println("<div class='card-body'>");
            		    	 out.println("<h4 class='card-title'> Reservation au parking de "+list.get(i).getDepartement().getNomdepartement()+"</h4>");
            		   		 out.println("<p class='text-muted'><code></code>");
            		   		 out.println("</p>");
            		   		 out.println("<div id='accordion-three' class='accordion'>");
            		   			out.println("<div class='card'>");
            		   				out.println("<div class='card-header'>");
            		   					out.println("<h5 class='mb-0' data-toggle='collapse' data-target='#collapseOne4' aria-expanded='true' aria-controls='collapseOne4'><i class='fa' aria-hidden='true'></i>Gerant de la reservation</h5>");
            		   				out.println("</div>");
            		   				out.println("<div id='collapseOne4' class='collapse show' data-parent='#accordion-three'>");
            		   					out.println(" <div class='card-body'>"+list.get(i).getGerant().getPersonne().getPrenom()+" "+list.get(i).getGerant().getPersonne().getNom()+"</div>");
            		   				   // out.println("<span><a clas='btn btn-outline-success' href=tel:"+list.get(i).getGerant().getPersonne().getTelephone()+"contacter gerant</a></span>");
            		   					out.println("</div>");
            		   			out.println("</div>");
            		   			out.println("<div class='card'>");
            		   		     	out.println("<div class='card-header'>");
            		   		     		out.println("<h5 class='mb-0 collapsed' data-toggle='collapse' data-target='#collapseTwo5' aria-expanded='false' aria-controls='collapseTwo5'><i class='fa' aria-hidden='true'></i> Date et heure de la reservation</h5>");
            		   		   		out.println("</div>");
            		   		   		out.println("<div id='collapseTwo5' class='collapse' data-parent='#accordion-three'>");
            		   		   			out.println("<div class='card-body'> vous avez effecuté cette reservation le "+list.get(i).getDatereservation()+" à "+list.get(i).getHeurereservation()+"</div>");
            		   		   		out.println("</div>");
            		   			out.println("</div>");
            		   			out.println("<div class='card'>");
            		   				out.println("<div class='card-header'>");
            		   					out.println("<h5 class='mb-0 collapsed' data-toggle='collapse' data-target='#collapseThree6' aria-expanded='false' aria-controls='collapseThree6'><i class='fa' aria-hidden='true'></i>Etat de votre reservation</h5>");
            		   				out.println("</div>");
            		   				out.println("<div id='collapseThree6' class='collapse' data-parent='#accordion-three'>");
            		   					out.println("<div class='card-body'> Votre reservation est "+list.get(i).getEtat()+"</div>");
            		   				out.println("</div>");
            		  			out.println(" </div>");
            			out.println("</div>");
            		out.println("</div>");
           		out.println("</div>");
       		out.println("</div>"); 
                   }
                	
                  }
                    %>
                    <%
                      if(request.getAttribute("message")!=null)
                      {
                    	  String message=(String)request.getAttribute("message");
                    	  out.println("<strong class='text-danger'>"+message+"</p>");
                      }
                    %>
                </div>
            </div>
            <!-- #/ container -->
        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; FREE PARK <a href="">L3 Informatique</a> 2022</p>
            </div>
        </div>
        
    <script src='plugins/common/common.min.js'></script>
    <script src='js/custom.min.js'></script>
    <script src='js/settings.js'></script>
    <script src='js/gleek.js'></script>
    <script src='js/styleSwitcher.js'></script>


</body>
</html>