<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bdbeans.Parking" %>
<%@ page import="bdbeans.Horaire" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Departement" %>
<%@ page import="bdbeans.ParkingHome" %>
<%@ page import="bdbeans.HoraireHome" %>
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
	                                    if(request.getAttribute("succes")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("succes");
	                                    	out.println("<p class='text-success'>"+message+"</p>");
	                                    }
	                                %>
                                    <form class="form-valide" action="modificationGerant" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="nom">Nom du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" name="nom" class="form-control" placeholder="Saisir le nom du gerant" value=${nom }>
                                                <input type="hidden" name="id_gerant" class="form-control" value=${id_gerant }>
                                                 <input type="hidden" name="id_personne" class="form-control" value=${id_personne }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="prenom">Prenom du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" name="prenom" class="form-control" placeholder=Saisir le prenom du gerant" value=${prenom }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="email">Email du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="email" name="email" class="form-control" placeholder="Saisir l'email du gerant" value=${email }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="telephone">Telephone du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="tel" name="telephone" class="form-control" placeholder=" saisir le numero de telephone du gerant" value=${telephone }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="adresse">Adresse du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" name="adresse" class="form-control" placeholder=" Saisir l'adresse du gerant" value=${adresse }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="numero_cni">Numero carte d'identite du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" name="numero_cni" class="form-control" placeholder="Numero carte d'identité nationale du gerant" value=${num_cni }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="date_embauche">Date d'embauche du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="date" name="date_embauche" class="form-control" placeholder="date d'embauche du gerant" value=${embauche }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner le parking <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_parking" class="form-select">
										           <option value="">Selectionner le parking du gerant</option>
											           <%
											            if(request.getAttribute("parking")!=null)
												        {
												           ArrayList<Parking> allparking=(ArrayList)request.getAttribute("parking");
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
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner l'horaire du gerant <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_horaire" class="form-select">
										           <option value="">Selectionner l'horaire du gerant</option>
								                  <%
										            if(request.getAttribute("horaire")!=null)
											        {
											           ArrayList<Horaire> allhoraire=(ArrayList)request.getAttribute("horaire");
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
                                            <label class="col-lg-4 col-form-label" for="login">Login du gerant<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" name="login" class="form-control" placeholder="le login du gerant" value=${login }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-lg-8 ml-auto">
                                                <button type="submit" class="btn btn-outline-success">Enregister les modifications</button>
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
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>  
</body>
</html>