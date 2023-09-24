<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bdbeans.Gerant" %>
    <%@ page import="java.util.Date" %>
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
                     
						     <div class="container">
						       <div class="text-black font-family-cambria bg-light p-2 mt-3 border rounded-pill">
						        <%
						        if(request.getAttribute("details_gerant")!=null)
						        {
						     	   Gerant gerant=(Gerant)request.getAttribute("details_gerant");
						     	   String prenom=gerant.getPersonne().getPrenom();
						     	   String nom=gerant.getPersonne().getNom();
						     	   String telephone=gerant.getPersonne().getTelephone();
						     	   String email=gerant.getPersonne().getEmail();
						     	   String adresse=gerant.getPersonne().getAdresse();
						     	   Date dateembauche=gerant.getDateembauche();
						     	   String region=gerant.getParking().getDepartement().getRegion().getNomregion();
						     	   String departement=gerant.getParking().getDepartement().getNomdepartement();
						     	   String horaire=gerant.getHoraire().getJours();
						     	   String heure_debut=gerant.getHoraire().getHeuredebut();
						     	   String heure_fin=gerant.getHoraire().getHeurefin();
						     	   out.println("<p>Prenom: "+prenom+"</p>");
						     	   out.println("<p>Nom: "+nom+"</p>");
						     	   out.println("<p>Telephone: "+telephone+"</p>");
						     	   out.println("<p>Email: "+email+"</p>");
						     	   out.println("<p>Adresse: "+adresse+"</p>");
						     	   out.println("<p>Date d'embauche: "+dateembauche+"</p>");
						     	   out.println("<p>Region du parking "+region+"</p>");
						     	   out.println("<p>departement du parking: "+departement+"</p>");
						     	   out.println("<p>Jour de travail: "+horaire+"</p>");
						     	   out.println("<p>heure d'ouverture: "+heure_debut+"</p>");
						     	   out.println("<p>heure de fermeture: "+heure_fin+"</p>");
						     	  out.println("<a href=tel:"+telephone+" class='btn btn-outline-success col-sm-2'>Appeler le gerant</a>");
						        }
						        %>
						        </div>
						     </div>
                           </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #/ container -->

        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; gestion Parking <a href="">L3 Informatique</a> 2022</p>
            </div>
        </div>
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>
</body>
</html>