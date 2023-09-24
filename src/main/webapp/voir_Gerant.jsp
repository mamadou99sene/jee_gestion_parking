<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Gerant" %>
<%@ page import="bdbeans.Departement" %>
<%@ page import="bdbeans.DepartementHome" %>
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
               <th scope="col">Prenom</th>
               <th scope="col">Nom</th>
               <th scope="col">Email</th>
               <th scope="col">Telephone</th>
               <th scope="col">Parking</th>
               <th scope="col">Horaire</th>
               <th scope="col">Date d'embauche</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("les_gerants")!=null)
                   {
                	   ArrayList<Gerant> les_gerants=(ArrayList)request.getAttribute("les_gerants");
                	   for(int i=0;i<les_gerants.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getPersonne().getPrenom()+"</td>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getPersonne().getEmail()+"</td>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getPersonne().getTelephone()+"</td>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getParking().getDepartement().getNomdepartement()+"</td>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getHoraire().getJours()+"</td>");
                		   out.print("<td scope=row>"+les_gerants.get(i).getDateembauche()+"</td>");
                		   
                		   out.print("<td scope=row>");
                		   out.print("<a href=details_Gerant?id_gerant="+les_gerants.get(i).getId().getIdgerant()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-4'>details</button>");
                		    out.print("</a>");
                		    out.print("<a href=modificationGerant?id_gerant="+les_gerants.get(i).getId().getIdgerant()+">");
                		     out.print("<button class='btn btn-outline-primary col-sm-4'>modifier</button>");
                		    out.print("</a>");
                		     out.print("<a onclick='return confirmer();' href=suppressionGerant?id_gerant="+les_gerants.get(i).getId().getIdgerant()+">");
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
    	return confirm("Voulez vous vraiment confirmer la suppression de ce gerant ?");
    }
    </script>
</body>
</html>