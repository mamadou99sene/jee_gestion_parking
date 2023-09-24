<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="bdbeans.Reservation" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
     <div class="container">
       <table class="table table-bordered table-striped mt-5">
         <thead>
            <tr>
               <th scope="col">Client </th>
               <th scope="col">Region</th>
               <th scope="col">Departement</th>
               <th scope="col">Date</th>
               <th scope="col">Heure</th>
               <th scope="col">etat</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
	          <%
			     if(request.getAttribute("message")!=null)
			        {
			           String message=(String)request.getAttribute("message");
			           out.println("<strong class='text-danger'>"+message+"</p>");
			       }
			   %>
               <%
               
                   if(request.getAttribute("res_non_gere")!=null)
                   {
                	   List<Reservation> reservations=(List)request.getAttribute("res_non_gere");
                	   for(int i=0;i<reservations.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+reservations.get(i).getClient().getPersonne().getPrenom()+" "+reservations.get(i).getClient().getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getDepartement().getRegion().getNomregion()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getDepartement().getNomdepartement()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getDatereservation()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getHeurereservation()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getEtat()+"</td>");
                		   out.print("<td scope=row>");
                		   out.print("<a href=gerer_Reservation?id_reservation="+reservations.get(i).getIdreservation()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-5'>gerer</button>");
                		    out.print("</a>");
                		    out.print("<a onclick='return confirmer();' href=suppression_Reservation?id_reservation="+reservations.get(i).getIdreservation()+">");
               		     out.print("<button class='btn btn-outline-danger col-sm-5'>supprimer</button>");
               		    out.print("</a>");
                		   out.print("</td>");
                		   out.println("</tr>");
                	   }
                   }else if(request.getParameter("message")!=null)
                   {
                	   String message=(String) request.getParameter("message");
                	   out.println(message);
                   }
               %>
         </tbody>
       </table>
       <%
     if(request.getAttribute("non_gere")!=null)
     {
    	 String mes=(String)request.getAttribute("non_gere");
    	 out.println("<p class='text-danger font-weight-bold'>"+mes+"</p>");
     }
     %>
    </div>
    <script type="text/javascript">
    function confirmer() 
    {
    	return confirm("Voulez vous vraiment confirmer la suppression de cette reservation non encore gérée ?");
    }
    </script>
    
</body>
</html>