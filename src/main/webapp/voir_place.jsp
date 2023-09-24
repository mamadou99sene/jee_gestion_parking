<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="bdbeans.Place" %>
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
               <th scope="col">Numero</th>
               <th scope="col">Type place</th>
               <th scope="col">Etat</th>
               <th scope="col">Prix</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("place_of_myParking")!=null)
                   {
                	   List<Place> my_place=(List)request.getAttribute("place_of_myParking");
                	   for(int i=0;i<my_place.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+my_place.get(i).getId().getIdplace()+"</td>");
                		   out.print("<td scope=row>"+my_place.get(i).getType()+"</td>");
                		   out.print("<td scope=row>"+my_place.get(i).getEtat()+"</td>");
                		   out.print("<td scope=row>"+my_place.get(i).getPrix()+" FCFA</td>");		   
                		   out.print("<td scope=row>");
                		   out.print("<a href=modifier_Place?id_place="+my_place.get(i).getId().getIdplace()+"&&id_parking="+my_place.get(i).getParking().getIdparking()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-4'>Modifier</button>");
                		     out.print("<a onclick='return confirmer();' href=suppressionPlace?id_place="+my_place.get(i).getId().getIdplace()+"&&id_parking="+my_place.get(i).getParking().getIdparking()+">");
                		     out.print("<button class='btn btn-outline-danger col-sm-4'>Supprimer</button>");
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
    	return confirm("Voulez vous vraiment confirmer la suppression de cette place ?");
    }
    </script>
</body>
</html>