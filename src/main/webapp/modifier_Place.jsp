<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bdbeans.Parking" %>
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
	                                  if(request.getAttribute("modification")!=null)
	                                  {
	                                  	String message=(String)request.getAttribute("modification");
	                                  	out.println("<p class='text-success'>"+message+"</p>");
	                                  }
	                                %>
                                    <form class="form-valide" action="modifier_Place" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-username">Prix <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-username" name="prix" placeholder="Saisir le prix" value=${prix }>
                                                <input type="hidden" name="id_place" value=${id_place }>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="type">Selectionner le type <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="type" class="form-select">
										           <option value="">Selectionner le type</option>
										           <option value="poids lourd">Poids lourd</option>
										           <option value="particulier">Particulier</option>
										           <option value="deux roues">Deux roues</option>
										        </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="etat">Selectionner l'etat <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="etat" class="form-select">
										           <option value="">Selectionner l'etat</option>
										           <option value="libre">libre</option>
                                                   <option value="occupée">occupée</option>
										        </select>
                                            </div>
                                        </div>
                                         <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id_parking">Selectionner le parking <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <select name="id_parking" class="form-select">
										           <option value="">Selectionner le parking</option>
										           <%
											            if(request.getAttribute("les_parkings")!=null)
												        {
												           ArrayList<Parking> les_parkings=(ArrayList)request.getAttribute("les_parkings");
												           for(int i=0;i<les_parkings.size();i++)
												           {
												        	   out.println("<option value="+les_parkings.get(i).getIdparking()+">"+les_parkings.get(i).getDepartement().getNomdepartement()+" " +les_parkings.get(i).getTetephone()+"</option>");
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