<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="nk-sidebar">           
            <div class="nk-nav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Tableau de bord</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-speedometer menu-icon"></i><span class="nav-text">Administration</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="accueil_Gerant">Accueil</a></li>
                            <!-- <li><a href="./index-2.html">Home 2</a></li> -->
                        </ul>
                    </li>
                    
                    <li class="nav-label">Reservations</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-note menu-icon"></i><span class="nav-text">gestions des reservations</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="voir_Reservations">reservations gérées</a></li>
                            <li><a href="reservation_Nonencore_Gere">reservations non gérées</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Locations</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-note menu-icon"></i><span class="nav-text">gestions des locations</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="ajouter_Location">Ajouter une location</a></li>
                            <li><a href="voir_Location">Details des locations</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Places de mon parking</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-menu menu-icon"></i><span class="nav-text">gestion place</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="ajout_Place">Ajouter une place</a></li>
                            <li><a href="voir_place">Details des places</a></li>

                        </ul>
                    </li>
                    <li class="nav-label">Voitures</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-notebook menu-icon"></i><span class="nav-text">gestion des des voitures</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="ajout_Voiture">Ajouter une voiture</a></li>
                            <li><a href="details_Voitures">Details des voitures</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Mon compte</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-note menu-icon"></i><span class="nav-text">gestion de mon compte</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="changement_mdp">changer mon mot de passe</a></li>
                            <li><a href="deconnexion">Se deconnecter</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

</body>
</html>