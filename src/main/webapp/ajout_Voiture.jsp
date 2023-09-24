<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bdbeans.Client" %>
    <%@ page import="java.util.ArrayList" %>
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
                <h4>Ajout de voiture</h4>
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
                                    <form class="form-valide" action="ajout_Voiture" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="immatriculation">Immatriculation <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="immatriculation" name="immatriculation" placeholder="saisir l'immatriculation" required="required">
                                                <span id="immatriculation_m"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="nom">Marque <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="marque" name="marque" placeholder="saisir la marque de la voiture" required="required">
                                                <span id="marque_m"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="adresse">Model <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="model" name="model" placeholder="saisir le model" required="required">
                                                <span id="model_m"></span>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="email">Serie <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="serie" name="serie" placeholder="saisir la serie" required="required">
                                                <span id="serie_m"></span>
                                            </div>
                                        </div>
                                      
										 <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_client">Selectionner le client <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_client" class="form-select">
										           <option value="">Selectionner le client</option>
										           <%
										            if(request.getAttribute("allclients")!=null)
											        {
											           ArrayList<Client> allclients=(ArrayList)request.getAttribute("allclients");
											           for(int i=0;i<allclients.size();i++)
											           {
											        	   out.println("<option value="+allclients.get(i).getId().getIdclient()+">"+allclients.get(i).getPersonne().getPrenom()+" "+allclients.get(i).getPersonne().getNom()+" CNI "+allclients.get(i).getPersonne().getNumerocarteidentite()+"</option>");
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
    <script src="control_voiture.js"></script>
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="./plugins/validation/jquery.validate.min.js"></script>
    <script src="./plugins/validation/jquery.validate-init.js"></script>
</body>
</html>