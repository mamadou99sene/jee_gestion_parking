<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bdbeans.Reservation" %>
<%@ page import="java.util.List" %>
<%@ page import="bdbeans.Place" %>
<%@ page import="bdbeans.Parking" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
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
            <!-- row -->

            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-validation">
	                                <%
	                                    if(request.getAttribute("avertissement")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("avertissement");
	                                    	out.println("<p class='text-danger'>"+message+"</p>");
	                                    }
	                                %>
	                                <%
	                                    if(request.getAttribute("insertion")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("insertion");
	                                    	out.println("<p class='text-success'>"+message+"</p>");
	                                    }
	                                %>
                                    <form class="form-valide" action="ajouter_Location" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="date_debut">Date de debut<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="date" class="form-control" id="date_debut" name="date_debut" placeholder="Saisir la date de debut de la location" required="required">
                                                <span id="date_dm"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="date_fin">Date de fin <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="date" class="form-control" id="date_fin" name="date_fin" placeholder="Saisir la date de fin pour la location" required="required">
                                                <span id="date_fm"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="montant">Montant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="number" class="form-control" id="montant" name="montant" placeholder="Saisir le montant total pour cette location" required="required">
                                                <span id="montant_m"></span>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_parking">Selectionner le parking <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_parking" class="form-select">
										           <option value="">Selectionner le parking</option>
											           <%
											            if(request.getAttribute("parkingOf_cuurentGerant")!=null)
												        {
												           List<Parking> allparking=(List)request.getAttribute("parkingOf_cuurentGerant");
												           for(int i=0;i<allparking.size();i++)
												           {
												        	   out.println("<option value="+allparking.get(i).getIdparking()+">"+allparking.get(i).getDepartement().getNomdepartement()+" "+allparking.get(i).getIdparking()+"</option>");
												           }
												         }
											           %>
										        </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner la place <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_place" class="form-select">
										           <option value="">Selectionner la place</option>
											           <%
											            if(request.getAttribute("les_place_libres")!=null)
												        {
												           List<Place> mes_places=(List<Place>)request.getAttribute("les_place_libres");
												           for(int i=0;i<mes_places.size();i++)
												           {
												        	   out.println("<option value="+mes_places.get(i).getId().getIdplace()+"> type: "+mes_places.get(i).getType()+" etat: "+mes_places.get(i).getEtat()+"</option>");
												           }
												         }
											           %>
										        </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner la reservation <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_reservation" class="form-select">
										           <option value="">Selectionner la reservation</option>
											           <%
											            if(request.getAttribute("reservationvalideBycurrentGerant")!=null)
												        {
												           List<Reservation> mes_reservations=(List<Reservation>)request.getAttribute("reservationvalideBycurrentGerant");
												           for(int i=0;i<mes_reservations.size();i++)
												           {
												        	   out.println("<option value="+mes_reservations.get(i).getIdreservation()+">"+mes_reservations.get(i).getClient().getPersonne().getPrenom()+" "+mes_reservations.get(i).getClient().getPersonne().getNom()+" CNI:"+mes_reservations.get(i).getClient().getPersonne().getNumerocarteidentite()+"</option>");
												           }
												         }
											           %>
										        </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-lg-8 ml-auto">
                                                <button type="submit" class="btn btn-outline-success" id="envoi">Enregister</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #/ container -->
        </div>
 
     <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; FREE PARK <a href="">L3 Informatique</a> 2022</p>
            </div>
        </div>
        <script src="control_location.js"></script>
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>  
 

</body>
</html>