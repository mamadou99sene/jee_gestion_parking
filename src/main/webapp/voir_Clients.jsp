<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Client" %>
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
            <tr onclick="return confirm('ligne cliqué');">
               <th scope="col">Prenom</th>
               <th scope="col">Nom</th>
               <th scope="col">Email</th>
               <th scope="col">Telephone</th>
               <th scope="col">Adresse du client</th>
               <th scope="col">Nombre de Reservation</th>
               <th scope="col">Nombre de voiture</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("les_clients")!=null)
                   {
                	   ArrayList<Client> les_clients=(ArrayList)request.getAttribute("les_clients");
                	   for(int i=0;i<les_clients.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+les_clients.get(i).getPersonne().getPrenom()+"</td>");
                		   out.print("<td scope=row>"+les_clients.get(i).getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+les_clients.get(i).getPersonne().getEmail()+"</td>");
                		   out.print("<td scope=row>"+les_clients.get(i).getPersonne().getTelephone()+"</td>");
                		   out.print("<td scope=row>"+les_clients.get(i).getPersonne().getAdresse()+"</td>");
                		   out.print("<td scope=rowclass='bg-success text-white'> "+les_clients.get(i).getReservations().size()+"</td>");
                		   out.print("<td scope=row>"+les_clients.get(i).getVoitures().size()+"</td>");
                		   
                		   out.print("<td scope=row>");
                		   out.print("<a href=details_Client?id_client="+les_clients.get(i).getId().getIdclient()+"&&id_personne="+les_clients.get(i).getId().getIdpersonne()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-5'>details</button>");
                		    out.print("</a>");
                		     out.print("<a onclick='return confirmer();' href=suppressionClient?id_client="+les_clients.get(i).getId().getIdclient()+"&&id_personne="+
                		    les_clients.get(i).getId().getIdpersonne()+">");
                		     out.print("<button class='btn btn-outline-danger col-sm-7'>supprimer</button>");
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
    	return confirm("Voulez vous vraiment confirmer la suppression de ce client ?");
    }
    </script>
</body>
</html>