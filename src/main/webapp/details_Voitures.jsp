<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="bdbeans.Voiture" %>
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
               <th scope="col">Proprietaire</th>
               <th scope="col">Immatriculation</th>
               <th scope="col">Marque</th>
               <th scope="col">Model</th>
               <th scope="col">Serie</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("les_vehicules")!=null)
                   {
                	   List<Voiture> voitures=(List)request.getAttribute("les_vehicules");
                	   for(int i=0;i<voitures.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+voitures.get(i).getClient().getPersonne().getPrenom()+" "+voitures.get(i).getClient().getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+voitures.get(i).getImmatriculation()+"</td>");
                		   out.print("<td scope=row>"+voitures.get(i).getMarque()+"</td>");
                		   out.print("<td scope=row>"+voitures.get(i).getModel()+"</td>");
                		   out.print("<td scope=row>"+voitures.get(i).getSerie()+"</td>");
                		   out.print("<td scope=row>");
                		   out.print("<a href=modifier_Voiture?id_voiture="+voitures.get(i).getIdvoiture()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-5'>Modifier</button>");
                		     out.print("<a onclick='return confirmer();' href=suppressionVoiture?id_voiture="+voitures.get(i).getIdvoiture()+">");
                		     out.print("<button class='btn btn-outline-danger col-sm-5'>Supprimer</button>");
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
    	return confirm("Voulez vous vraiment confirmer la suppression de cette voiture ?");
    }
    </script>
</body>
</html>