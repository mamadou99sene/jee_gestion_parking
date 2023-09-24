<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Reservation" %>
<%@ page import="bdbeans.DepartementHome" %>
<%@ page import="bdbeans.DepartementId" %>
<%@ page import="bdbeans.Departement" %>
<%@ page import="bdbeans.RegionHome" %>
<%@ page import="bdbeans.Region" %>
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
               <th scope="col">Gerant </th>
               <th scope="col">Region</th>
               <th scope="col">Departement</th>
               <th scope="col">Client</th>
               <th scope="col">Date</th>
               <th scope="col">Heure</th>
               <th scope="col">etat</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("les_reservations")!=null)
                   {
                	   ArrayList<Reservation> reservations=(ArrayList)request.getAttribute("les_reservations");
                	   for(int i=0;i<reservations.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+reservations.get(i).getGerant().getPersonne().getPrenom()+" "+reservations.get(i).getGerant().getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getDepartement().getRegion().getNomregion()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getDepartement().getNomdepartement()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getClient().getPersonne().getPrenom()+" "+reservations.get(i).getClient().getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getDatereservation()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getHeurereservation()+"</td>");
                		   out.print("<td scope=row>"+reservations.get(i).getEtat()+"</td>");
                		   out.print("<td scope=row>");
                		   if(reservations.get(i).getEtat().equals("non validée"))
                		   {
                			out.print("<a onclick='return valider();' href=validation_Reservation?id_reservation="+reservations.get(i).getIdreservation()+">");
                  		     out.print("<button class='btn btn-outline-success col-sm-4'>valider</button>");
                  		    out.print("</a>");
                		   }else
                		   {
                			 out.print("<a onclick='return devalider();' href=devalidation_Reservation?id_reservation="+reservations.get(i).getIdreservation()+">");
                  		       out.print("<button class='btn btn-outline-warning col-sm-4'>devalider</button>");
                  		     out.print("</a>");
                		   }
                		    out.print("<a href=tel:"+reservations.get(i).getClient().getPersonne().getTelephone()+">");
                		     out.print("<button class='btn btn-outline-primary col-sm-4'>contacter</button>");
                		    out.print("</a>");
                		     out.print("<a onclick='return confirmer();' href=suppression_Reservation?id_reservation="+reservations.get(i).getIdreservation()+">");
                		     out.print("<button class='btn btn-outline-danger col-sm-4'>supprimer</button>");
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
    </div>
    <script type="text/javascript">
    function confirmer() 
    {
    	return confirm("Voulez vous vraiment confirmer la suppression de cette reservation ?");
    }
    function valider() 
    {
    	return confirm("Voulez vous vraiment valider cette reservation ?");
    }
    function devalider() 
    {
    	return confirm("Voulez vous vraiment annuler la validation de cette reservation ?");
    }
    </script>
</body>
</html>