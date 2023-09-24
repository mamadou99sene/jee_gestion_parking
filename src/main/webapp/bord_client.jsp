<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bdbeans.Departement" %>
    <%@ page import="bdbeans.DepartementHome" %>
    <%@ page import="java.util.ArrayList" %>
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
                            <i class="icon-speedometer menu-icon"></i><span class="nav-text">Mon Accueil</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="accueil_Client">Accueil</a></li>
                            <!-- <li><a href="./index-2.html">Home 2</a></li> -->
                        </ul>
                    </li>
                    
                    <li class="nav-label">Reservations</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-note menu-icon"></i><span class="nav-text">espace reservations</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="suivre_Reservations">Suivre mes reservations</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Espace locations</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-menu menu-icon"></i><span class="nav-text">Suivre mes locations</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="location">Details de mes locations</a></li>

                        </ul>
                    </li>
                    <li class="nav-label">Espace voiture</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-notebook menu-icon"></i><span class="nav-text">mes voitures</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="mes_Voitures">Details des voitures</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Plus de Parkings</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-note menu-icon"></i><span class="nav-text">decouverte d'autres parking</span>
                        </a>
                        <ul aria-expanded="false">
                            <%
                            if(request.getAttribute("departements")!=null)
                            {
                            	ArrayList<Departement> departements=(ArrayList<Departement>)request.getAttribute("departements");
                            	for(int i=0;i<departements.size();i++)
                            	{
                            		out.println("<li><a href=parking_Departement?id_departement="+departements.get(i).getId().getIddepartement()+">"+departements.get(i).getNomdepartement()+"</a></li>");
                            	}
                            }
                            %>
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