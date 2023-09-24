<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
    pageEncoding='ISO-8859-1'%>
    <%@ page import="bdbeans.Detailslocation" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='ISO-8859-1'>
<title>Insert title here</title>
<link href='css/style.css' rel='stylesheet'>
<link href='css/style.css' rel='bootstrap.css'>
</head>
<body>
<div class="container mt-5">
 <%
  if(request.getAttribute("mes_locations")!=null)
  {
	  List<Detailslocation> locations=(List<Detailslocation>)request.getAttribute("mes_locations");
	  for(int i=0;i<locations.size();i++)
	  {
		  int j=i+1;
		  out.println("<div class='col-md-12'>");
			out.println("<div class='card'>");
				out.println("<div class='card-body'>");
				  out.println("<h4 class='card-title'>Location "+j+"</h4>");
               out.println("<div class='custom-tab-1'>");
                 out.println("<ul class='nav nav-tabs mb-3'>");
              	   out.println("<li class='nav-item'><a class='nav-link active' data-toggle='tab' href='#home"+i+"'>Parking</a>");
              	   out.println("</li>");
             		   out.println(" <li class='nav-item'><a class='nav-link' data-toggle='tab' href='#profile"+i+"'>Place</a>");
              		out.println("</li>");
             			out.println(" <li class='nav-item'><a class='nav-link' data-toggle='tab' href='#contact"+i+"'>Date debut</a>");
             			out.println(" </li>");
             			out.println("<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#message"+i+"'>Date fin</a>");
             			out.println(" </li>");
             			out.println("<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#montant"+i+"'>Montant</a>");
             			out.println(" </li>");
 				out.println("</ul>");
 				out.println("<div class='tab-content'>");
 					out.println("<div class='tab-pane fade show active' id='home"+i+"' role='tabpanel'>");
 						out.println("<div class='p-t-15'>");
 							out.println("<h4>Le departement se trouvant le parking</h4>");
 							out.println("<p>"+locations.get(i).getPlace().getParking().getDepartement().getNomdepartement()+"</p>");
 				
 						out.println("</div>");
 					out.println("</div>");
 					out.println("<div class='tab-pane fade' id='profile"+i+"'>");
 						out.println("<div class='p-t-15'>");
 							out.println("<h4>La place correspondant a votre location</h4>");
 							out.println("<p>"+locations.get(i).getPlace().getType()+" "+locations.get(i).getPlace().getId().getIdplace()+"</p>");
 							
 			     		out.println("</div>");
 			     		out.println("</div>");
 			     		out.println("<div class='tab-pane fade' id='contact"+i+"'>");
 			     			out.println("<div class='p-t-15'>");
 			     				out.println("<h4>La date de debut de votre location</h4>");
 			     				out.println("<p>"+locations.get(i).getDatedebut()+"</p>");
 			     				
 			     			out.println("</div>");
 			    		out.println("</div>");
 			    		out.println("<div class='tab-pane fade' id='message"+i+"'>");
 			    			out.println("<div class='p-t-15'>");
 			    		     	out.println("<h4>La date de fin de votre location</h4>");
 			    		   		out.println("<p>"+locations.get(i).getDatefin()+"</p>");
 			    		   		
 			     			out.println("</div>");
 			     		out.println("</div>");
 			     		out.println("<div class='tab-pane fade' id='montant"+i+"'>");
			     			out.println("<div class='p-t-15'>");
			     				out.println("<h4 class='text-danger'>Le montant totale pour cette location</h4>");
			     				out.println("<p class='text-danger'>"+locations.get(i).getMontant()+" FCFA</p>");
			     				
			     			out.println("</div>");
			    		out.println("</div>");
 				out.println("</div>");
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
    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>
</body>
</html>