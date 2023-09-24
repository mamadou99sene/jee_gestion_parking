<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
    pageEncoding='ISO-8859-1'%>
    <%@ page import="bdbeans.Voiture" %>
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
  if(request.getAttribute("mes_voitures_enregistre")!=null)
  {
	  List<Voiture> mes_voitures=(List<Voiture>)request.getAttribute("mes_voitures_enregistre");
	  for(int i=0;i<mes_voitures.size();i++)
	  {
		  int j=i+1;
		  out.println("<div class='col-md-12'>");
			out.println("<div class='card'>");
				out.println("<div class='card-body'>");
				  out.println("<h4 class='card-title'> Voiture "+j+"</h4>");
               out.println("<div class='custom-tab-1'>");
                 out.println("<ul class='nav nav-tabs mb-3'>");
              	   out.println("<li class='nav-item'><a class='nav-link active' data-toggle='tab' href='#home"+i+"'>Immatriculation</a>");
              	   out.println("</li>");
             		   out.println(" <li class='nav-item'><a class='nav-link' data-toggle='tab' href='#profile"+i+"'>Marque</a>");
              		out.println("</li>");
             			out.println(" <li class='nav-item'><a class='nav-link' data-toggle='tab' href='#contact"+i+"'>Model</a>");
             			out.println(" </li>");
             			out.println("<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#message"+i+"'>Serie</a>");
             			out.println(" </li>");
 				out.println("</ul>");
 				out.println("<div class='tab-content'>");
 					out.println("<div class='tab-pane fade show active' id='home"+i+"' role='tabpanel'>");
 						out.println("<div class='p-t-15'>");
 							out.println("<h4>L'immatriculation</h4>");
 							out.println("<p>"+mes_voitures.get(i).getImmatriculation()+"</p>");
 				
 						out.println("</div>");
 					out.println("</div>");
 					out.println("<div class='tab-pane fade' id='profile"+i+"'>");
 						out.println("<div class='p-t-15'>");
 							out.println("<h4>La marque de votre voiture</h4>");
 							out.println("<p>"+mes_voitures.get(i).getMarque()+"</p>");
 							
 			     		out.println("</div>");
 			     		out.println("</div>");
 			     		out.println("<div class='tab-pane fade' id='contact"+i+"'>");
 			     			out.println("<div class='p-t-15'>");
 			     				out.println("<h4>Le model de votre voiture</h4>");
 			     				out.println("<p>"+mes_voitures.get(i).getModel()+"</p>");
 			     				
 			     			out.println("</div>");
 			    		out.println("</div>");
 			    		out.println("<div class='tab-pane fade' id='message"+i+"'>");
 			    			out.println("<div class='p-t-15'>");
 			    		     	out.println("<h4>La serie de votre voiture</h4>");
 			    		   		out.println("<p>"+mes_voitures.get(i).getSerie()+"</p>");
 			    		   		
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