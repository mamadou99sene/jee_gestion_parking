<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Region" %>
<%@ page import="bdbeans.Departement" %>
<%@ page import="bdbeans.DepartementHome" %>
<%@ page import="java.util.ArrayList" %>
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
	                                    if(request.getAttribute("modif")!=null)
	                                    {
	                                    	String message=(String)request.getAttribute("modif");
	                                    	out.println("<p class='text-success'>"+message+"</p>");
	                                    }
	                                %>
                                  <form class="form-valide" action="modification" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="email">Email <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="email" class="form-control" id="email" name="email" placeholder="Saisir l'email du parking" value=${email }>
                                                <input type="hidden" name="id_parking"  class="form-control" value=${id_parking }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="telephone">Telephone <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="Saisir le numero de telephone" value=${telephone }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="nombreplace">Le nombre de place <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="number" class="form-control" id="nombreplace" name="nombreplace" placeholder="Saisir le nombre de place" value=${nombreplace }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="heure_ouv">Heure d'ouverture <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="time" class="form-control" id="heure_ouv" name="heure_ouv" placeholder="Saisir l'heure d'ouverture du parking" value=${heure_ouverture }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="heure_ferm">Heure de fermeture <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="time" class="form-control" id="heure_ferm" name="heure_ferm" placeholder="Saisir l'heure de fermeture du parking" value=${heure_fermeture }>
                                            </div>
                                        </div>
                                       
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="nombregerant">Nombre de gerant(s) <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="number" class="form-control" id="nombregerant" name="nombregerant" placeholder="Saisir le nombre de gerant du parking" value=${nombre_gerant }>
                                            </div>
                                        </div>
                                         <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner la Region <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="etat" class="form-select">
										              <option value="">Selectionner l'etat du parking</option>
											         <option value="ferme">fermé</option>
                                                     <option value="ouvert">ouvert</option>
												</select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner la Region <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="region" class="form-select">
										           <option value="">Selectionner la region du parking</option>
											         <%
									                   if(request.getAttribute("region")!=null)
									                   {
									                	   Region region=(Region)request.getAttribute("region");
									                	   out.println(" <option value="+region.getIdregion()+">"+region.getNomregion()+"</option>");
									                   }
									                %>  
												</select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner le departement <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="departement" class="form-select">
										           <option value="">Selectionner le departement du parking</option>
											        <%
									                   if(request.getAttribute("region")!=null)
									                   {
									                	   Region region=(Region)request.getAttribute("region");
									                	   ArrayList<Departement> departement=(ArrayList<Departement>)new DepartementHome().getAllDepartementsUniques(region.getIdregion());
									                	   for(int i=0;i<departement.size();i++)
									                	   {
									                		   out.println(" <option value="+departement.get(i).getId().getIddepartement()+">"+departement.get(i).getNomdepartement()+"</option>");
									                	   }
									                   }
									                %>
												</select>
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