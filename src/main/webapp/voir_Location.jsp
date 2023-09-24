<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="bdbeans.Detailslocation" %>
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
              <th scope="col">Parking</th>
               <th scope="col">Client</th>
               <th scope="col">type et Numero</th>
               <th scope="col">Date debut</th>
               <th scope="col">Date fin</th>
               <th scope="col">Montant</th>
               <th scope="col">Details</th>
            </tr>
         </thead>
         <tbody>
               <%
               
                   if(request.getAttribute("mes_locations")!=null)
                   {
                	   List<Detailslocation> locations=(List)request.getAttribute("mes_locations");
                	   for(int i=0;i<locations.size();i++)
                	   {
                		   out.println("<tr>");
                		   out.print("<td scope=row>"+locations.get(i).getPlace().getParking().getDepartement().getNomdepartement()+"</td>");
                		   out.print("<td scope=row>"+locations.get(i).getReservation().getClient().getPersonne().getPrenom()+" "+locations.get(i).getReservation().getClient().getPersonne().getNom()+"</td>");
                		   out.print("<td scope=row>"+locations.get(i).getPlace().getType()+" "+locations.get(i).getPlace().getId().getIdparking()+"</td>");
                		   out.print("<td scope=row>"+locations.get(i).getDatedebut()+"</td>");
                		   out.print("<td scope=row>"+locations.get(i).getDatefin()+"</td>");	
                		   out.print("<td scope=row>"+locations.get(i).getMontant()+" FCFA</td>");
                		   out.print("<td scope=row>");
                		    out.print("<a href=modifier_Location?id_location="+locations.get(i).getId().getIdlocation()+">");
                		     out.print("<button class='btn btn-outline-success col-sm-3'>Modifier</button>");
                		     out.print("</a>");
                		     out.print("<a onclick='return liberer();' href=liberer_Place?id_place="+locations.get(i).getPlace().getId().getIdplace()+"&&id_parking="+locations.get(i).getPlace().getParking().getIdparking()+">");
                		     out.print("<button class='btn btn-outline-primary col-sm-5'id=fin>finir location</button>");
                		     out.print("</a>");
                		     out.print("<a onclick='return confirmer();' href=supprimer_Location?id_location="+locations.get(i).getId().getIdlocation()+">");
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
    <script  src="control.js"></script>
    <script type="text/javascript">
    function confirmer() 
    {
    	return confirm("Voulez vous vraiment confirmer la suppression de cette location ?");
    }
    function liberer() 
    {
    	return confirm("Voulez vous vraiment merquer cette place libre ?");
    }
    var fin=document.getElementById('fin');
    fin.addEventListener("click",function(e)
    {
	   	fin.innerHTML="FINI";
	   	fin.style.backgroundColor="red";
	   	fin.style.color="white";
    },false);
    </script>
</body>
</html>