<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="bdbeans.Place" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Pignose Calender -->
    <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
 <div class="content-body">

            <div class="row page-titles mx-0">
                <div class="col p-md-0">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
                    </ol>
                </div>
            </div>

            <div class="container-fluid">
                   <div class="container">
       <table class="table table-bordered table-striped mt-5">
         <thead>
            <tr onclick="return confirm('ligne cliqué');">
               <th scope="col">Numero</th>
               <th scope="col">type de place</th>
               <th scope="col">Prix</th>
               <th scope="col">Etat</th>
               <th scope="col">Action</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("places_of_Parking")!=null)
                   {
                	   ArrayList<Place> les_places=(ArrayList)request.getAttribute("places_of_Parking");
                	   if(les_places.size()>0)
                	   {
                		   for(int i=0;i<les_places.size();i++)
                    	   {
                    		   out.println("<tr>");
                    		   out.print("<td scope=row>"+les_places.get(i).getId().getIdplace()+"</td>");
                    		   out.print("<td scope=row>"+les_places.get(i).getType()+"</td>");
                    		   out.print("<td scope=row class='bg-danger text-white font-weight-bold'>"+les_places.get(i).getPrix()+" FCFA</td>");
                    		   out.print("<td scope=row class='bg-success text-white'>"+les_places.get(i).getEtat()+"</td>");
                    		   
                    		   out.print("<td scope=row>");
                    		   out.print("<a onclick='return reserver();' href=reservation?id_place="+les_places.get(i).getId().getIdplace()+">");
                    		     out.print("<button class='btn btn-outline-success col-sm-5'>Reserver</button>");
                    		    out.print("</a>");
                    		   out.print("</td>");
                    		   out.println("</tr>");
                    	   }
                	   }
                	   else
                	   {
                		   out.println("<p class='text-danger font-weight-bold'>Aucune place pour ce parking!!!!</p>");
                	   }
                	   
                   }
               %>
         </tbody>
       </table>
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

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>
    <script type="text/javascript">
    function reserver() 
    {
    	return confirm("Voulez vous vraiment confirmer la demande de reservation pour cette place ?");
    }
    
    </script>
</body>
</html>