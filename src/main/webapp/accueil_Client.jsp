<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
    pageEncoding='ISO-8859-1'%>
    <%@ page import="bdbeans.Parking" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='ISO-8859-1'>
<title>Insert title here</title>
    <link rel='icon' type='image/png' sizes='16x16' href='images/favicon.png'>
    <!-- Pignose Calender -->
    <link href='./plugins/pg-calendar/css/pignose.calendar.min.css' rel='stylesheet'>
    <!-- Chartist -->
    <link rel='stylesheet' href='./plugins/chartist/css/chartist.min.css'>
    <link rel='stylesheet' href='./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css'>
    <!-- Custom Stylesheet -->
    <link href='css/style.css' rel='stylesheet'>
</head>
<body>
   <div class="content-body" style="z-index: 0;">
       <div class="container-fluid mt-3">
          <div class="row" style="z-index: 0;">	
		  <%
		  if(request.getAttribute("les_parkings")!=null)
		  {
			  ArrayList<Parking> les_parkings=(ArrayList<Parking>)request.getAttribute("les_parkings");
			  for(int i=0;i<les_parkings.size();i++)
			  {

				   out.println("<div class='col-lg-4 col-sm-6' style='z-index: 0;'>");
							out.println("<div class='card gradient-1'>");
								out.println("<div class='card-body'>");
								  out.println("<a href=details_Parking?id_parking="+les_parkings.get(i).getIdparking()+">");
									out.println("<h3 class='card-title text-white'>Parking à "+les_parkings.get(i).getDepartement().getNomdepartement()+"</h3>");
										out.println("<div class='d-inline-block'>");
										   out.println("<h2 class='text-white'></h2>");
											  out.println("<p class='text-white mb-0'>"+les_parkings.get(i).getNombreplace()+" place(s)</p>");
											out.println("</div>");
										  out.println("<span class='float-right display-5 opacity-5'><i class='fa fa-car'></i></span>");
										 out.println("</a>");
										 out.println("</div>");
							 out.println("</div>");
						out.println("</div>");
				 
			  }
		  }
		  %>
		  </div>
		 </div>
	  </div>
       <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; FREE PARK <a href="">L3 Informatique</a> 2022</p>
            </div>
        </div>
     <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
    
  
</body>
</html>