<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bdbeans.Parking" %>
    <%@ page import="bdbeans.Horaire" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="bdbeans.Departement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.css">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
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
	                                    if(request.getAttribute("ajout")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("ajout");
	                                    	out.println("<strong class='text-success'>"+message+"</strong>");
	                                    }
	                                %>
                                    <form class="form-valide" action="ajout_gerant" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="nom">Nom <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="nom" name="nom" placeholder="Saisir le nom" required="required">
                                                <span id="nom_mq"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="prenom">Prenom <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Saisir le prenom" required="required">
                                                <span id="prenom_mq"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="email">Email <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="email" class="form-control" id="email" name="email" placeholder="Saisir l'adresse mail" required="required">
                                                <span id="email_mq"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="telephone">Telephone <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="telephone" name="telephone" placeholder="Saisir le numero de telephone" required="required">
                                                <span id="telephone_mq"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="adresse">Adresse <span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Saisir l'adresse">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="numero_cni">Numero carte d'identite <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="numero_cni" name="numero_cni" placeholder="Saisir le numero de carte d'identite nationale">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="date_embauche">Date d'embauche <span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="date" class="form-control" id="date_embauche" name="date_embauche" placeholder="Saisir la date d'embauche">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner le parking <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_parking" class="form-select" id="parking">
										           <option value="">Selectionner le parking</option>
											           <%
											            if(request.getAttribute("allparking")!=null)
												        {
												           ArrayList<Parking> allparking=(ArrayList)request.getAttribute("allparking");
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
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner l'horaire <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_horaire" class="form-select" id="horaire">
										           <option value="">Selectionner l'horaire du gerant</option>
											           <%
											           if(request.getAttribute("allhoraire")!=null)
												        {
												           ArrayList<Horaire> allhoraire=(ArrayList)request.getAttribute("allhoraire");
												           for(int i=0;i<allhoraire.size();i++)
												           {
												        	   out.println("<option value="+allhoraire.get(i).getIdhoraire()+">"+allhoraire.get(i).getJours()+" "+allhoraire.get(i).getHeuredebut()+" "+allhoraire.get(i).getHeurefin()+"</option>");
												           }
												         }
											           %>
										        </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="login">Login <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="login" name="login" placeholder="Saisir le login du gerant" required="required">
                                                <span id="login_mq"></span>
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
    <script src="controlGerant.js"></script>
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>  
 
</body>
</html>