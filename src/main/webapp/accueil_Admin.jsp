<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="bdbeans.Personne" %>
<%@ page import="bdbeans.Reservation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    
    <!-- theme meta -->
    <meta name="theme-name" content="quixlab" />
  
    <title></title>
     <link rel='icon' type='image/png' sizes='16x16' href='images/favicon.png'>
    <!-- Pignose Calender -->
    <link href='./plugins/pg-calendar/css/pignose.calendar.min.css' rel='stylesheet'>
    <!-- Chartist -->
    <link rel='stylesheet' href='./plugins/chartist/css/chartist.min.css'>
    <link rel='stylesheet' href='./plugins/chartist-plugins-tooltips/css/chartist-plugins-tooltip.css'>
    <!-- Custom Stylesheet -->
    <link href='css/style.css' rel='stylesheet'>
    

</head>

<body>
 <div class="content-body">

            <div class="container-fluid mt-3">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-1">
                            <div class="card-body">
                                <h3 class="card-title text-white">Parkings</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">
                                    <%
	                                if(request.getAttribute("nombre_parking")!=null)
	                                {
	                                	int nombreParking=(int)request.getAttribute("nombre_parking");
	                                	out.println(nombreParking);
	                                }
                                %></h2>
                                    <p class="text-white mb-0"><%out.println(new Date().toGMTString().substring(0,17)); %></p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-car"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-2">
                            <div class="card-body">
                                <h3 class="card-title text-white">Gerants</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">
                                    <%
	                                if(request.getAttribute("nombre_gerant")!=null)
	                                {
	                                	int nombregerant=(int)request.getAttribute("nombre_gerant");
	                                	out.println(nombregerant);
	                                }
                                  %>
                                    </h2>
                                    <p class="text-white mb-0"><%out.println(new Date().toGMTString().substring(0,17)); %></p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-money"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-3">
                            <div class="card-body">
                                <h3 class="card-title text-white">Clients</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">
                                     <%
	                                if(request.getAttribute("nombre_client")!=null)
	                                {
	                                	int nombreclient=(int)request.getAttribute("nombre_client");
	                                	out.println(nombreclient);
	                                }
                                  %>
                                    </h2>
                                    <p class="text-white mb-0"><%out.println(new Date().toGMTString().substring(0,17)); %></p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-users"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-4">
                            <div class="card-body">
                                <h3 class="card-title text-white">Reservations a ce jour</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">
                                     <%
	                                if(request.getAttribute("nombre_reservation")!=null)
	                                {
	                                	int nombrereservation=(int)request.getAttribute("nombre_reservation");
	                                	out.println(nombrereservation);
	                                }
                                  %>
                                    </h2>
                                    <p class="text-white mb-0"><%out.println(new Date().toGMTString().substring(0,17)); %></p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-heart"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="text-center">
                                    <img src="./images/user/form-user.png" class="rounded-circle" alt="">
                                    <h5 class="mt-3 mb-1">
                                    <%
	                                if(request.getAttribute("dernieres_reservations")!=null)
	                                {
	                                	ArrayList<Reservation> dernieres=(ArrayList<Reservation>)request.getAttribute("dernieres_reservations");
	                                	out.println(dernieres.get(0).getClient().getPersonne().getPrenom()+" "+dernieres.get(0).getClient().getPersonne().getNom());
	                              
                                    out.print("</h5>");
                                    out.print("</<p class='m-0'>"+dernieres.get(0).getDepartement().getNomdepartement()+"</p>");  
                                    }
	                               %>
                                    <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="text-center">
                                    <img src="./images/user/form-user.png" class="rounded-circle" alt="">
                                    <h5 class="mt-3 mb-1">
                                    <%
	                                if(request.getAttribute("dernieres_reservations")!=null)
	                                {
	                                	ArrayList<Reservation> dernieres=(ArrayList<Reservation>)request.getAttribute("dernieres_reservations");
	                                	out.println(dernieres.get(1).getClient().getPersonne().getPrenom()+" "+dernieres.get(1).getClient().getPersonne().getNom());
	                              
                                    out.print("</h5>");
                                    out.print("</<p class='m-0'>"+dernieres.get(1).getDepartement().getNomdepartement()+"</p>");  
                                    }
	                               %>
                                    <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="text-center">
                                    <img src="./images/users/7.jpg" class="rounded-circle" alt="">
                                    <h5 class="mt-3 mb-1">
                                    <%
	                                if(request.getAttribute("dernieres_reservations")!=null)
	                                {
	                                	ArrayList<Reservation> dernieres=(ArrayList<Reservation>)request.getAttribute("dernieres_reservations");
	                                	out.println(dernieres.get(2).getClient().getPersonne().getPrenom()+" "+dernieres.get(2).getClient().getPersonne().getNom());
	                              
                                    out.print("</h5>");
                                    out.print("</<p class='m-0'>"+dernieres.get(2).getDepartement().getNomdepartement()+"</p>");  
                                    }
	                               %>
                                    <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="text-center">
                                    <img src="./images/users/1.jpg" class="rounded-circle" alt="">
                                    <h5 class="mt-3 mb-1">
                                    <%
	                                if(request.getAttribute("dernieres_reservations")!=null)
	                                {
	                                	ArrayList<Reservation> dernieres=(ArrayList<Reservation>)request.getAttribute("dernieres_reservations");
	                                	out.println(dernieres.get(3).getClient().getPersonne().getPrenom()+" "+dernieres.get(3).getClient().getPersonne().getNom());
	                              
                                    out.print("</h5>");
                                    out.print("</<p class='m-0'>"+dernieres.get(3).getDepartement().getNomdepartement()+"</p>");  
                                    }
	                               %>
                                    <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                
                
                <div class="row">
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-facebook">
                                    <span class="s-icon"><i class="fa fa-facebook"></i></span>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">89k</h4>
                                            <p class="m-0">Amis</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">119k</h4>
                                            <p class="m-0">Abonnés</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-linkedin">
                                    <span class="s-icon"><i class="fa fa-linkedin"></i></span>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">89k</h4>
                                            <p class="m-0">Amis</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">119k</h4>
                                            <p class="m-0">Abonnés</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-googleplus">
                                    <span class="s-icon"><i class="fa fa-google-plus"></i></span>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">89k</h4>
                                            <p class="m-0">Amis</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">119k</h4>
                                            <p class="m-0">Abonnés</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-twitter">
                                    <span class="s-icon"><i class="fa fa-twitter"></i></span>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">89k</h4>
                                            <p class="m-0">Amis</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">119k</h4>
                                            <p class="m-0">Abonnés</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- #/ container -->
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
        
        
        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; FREE PARK <a href="https://themeforest.net/user/quixlab">L3 Informatique</a> 2022</p>
            </div>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
     <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
    
   

</body>

</html>
