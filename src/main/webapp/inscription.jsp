<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bdbeans.Personne" %>
<%@ page import="bdbeans.Reservation" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="ISO-8859-1">
    
    <meta name="theme-name" content="quixlab" />
  
    <title></title>
    <!-- Favicon icon -->
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

    <!--*******************
        Preloader start
    ********************-->
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
	                                    if(request.getAttribute("eRRorMes")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("eRRorMes");
	                                    	out.println("<p class='text-danger'>"+message+"</p>");
	                                    }
	                                %>
	                                <%
	                                    if(request.getAttribute("logError")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("logError");
	                                    	out.println("<p class='text-danger'>"+message+"</p>");
	                                    }
	                                %>
	                                <%
	                                    if(request.getAttribute("inscriptionValide")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("inscriptionValide");
	                                    	out.println("<p class='text-success font-weight-bold'>"+message+"</p>");
	                                    }
	                                %>
                                    <form class="form-valide" action="inscription" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-username">Prenom <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-username" name="prenom" placeholder="Saisir votre prenom" required="required">
                                                <span id="prenom_mq"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="nom">Nom <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="nom" name="nom" placeholder="Saisir votre nom" required="required">
                                                <span id="nom_mq"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="adresse">Adresse <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Saisir votre adresse">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="email">Email <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="email" class="form-control" id="email" name="email" placeholder="Saisir votre e-mail" required="required">
                                                <span id="email_mq"></span>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="telephone">Telephone <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="telephone" required="required">
                                                <span id="telephone_mq"></span>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="numero_cni">Numero catre d'identite <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="numero_cni" name="numero_cni" placeholder="numero carte d'identite">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="login">Login<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="login" name="login" placeholder="Saisir votre login" required="required">
                                                <span id="login_mq"></span>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <div class="col-lg-8 ml-auto">
                                                <button type="submit" class="btn btn-outline-success col-sm-9" id="envoi">S'inscrire</button>
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
     <script src="control.js"></script>   
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>
</body>
</html>