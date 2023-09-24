<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Parking" %>
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
    <div class="container-fluid">
       <table class="table table-bordered table-striped mt-5">
         <thead>
            <tr>
               <th scope="col">Email</th>
               <th scope="col">telephone</th>
               <th scope="col">Nombre de places</th>
               <th scope="col">Heure d'ouverture</th>
               <th scope="col">Heure de fermeture</th>
               <th scope="col">etat</th>
               <th scope="col">Departement</th>
               <th scope="col">Region</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("les_parkings")!=null)
                   {
                	   ArrayList<Parking> les_parkings=(ArrayList)request.getAttribute("les_parkings");
                	   for(int i=0;i<les_parkings.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getEmail()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getTetephone()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getNombreplace()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getHeureoverture()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getHeurefermeture()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getEtat()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getDepartement().getNomdepartement()+"</td>");
                		   out.print("<td scope=row>"+les_parkings.get(i).getDepartement().getRegion().getNomregion()+"</td>");
                		   out.print("<td scope=row class='col-sm-3'>");
                		   out.print("<a href=details_parking?id_parking="+les_parkings.get(i).getIdparking()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-4'>details</button>");
                		    out.print("</a>");
                		    out.print("<a href=modification?id_parking="+les_parkings.get(i).getIdparking()+">");
                		     out.print("<button class='btn btn-outline-primary col-sm-4'>modifier</button>");
                		    out.print("</a>");
                		     out.print("<a onclick='return confirmer();' href=suppression?id_parking="+les_parkings.get(i).getIdparking()+">");
                		     out.print("<button class='btn btn-outline-danger col-sm-4'>supprimer</button>");
                		     out.print("</a>");
                		   out.print("</td>");
                		   out.println("</tr>");
                	   }
                   }
               %>
         </tbody>
       </table>
    </div>
    <script type="text/javascript">
    function confirmer() 
    {
    	return confirm("Voulez vous vraiment confirmer la suppression de ce parking ?");
    }
    
    </script>
</body>
</html>