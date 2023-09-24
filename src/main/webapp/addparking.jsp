<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bdbeans.Region" %>
<%@ page import="bdbeans.Departement" %>
<%@ page import="bdbeans.DepartementHome" %>
<%@ page import="bdbeans.DepartementId" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
	<link rel="stylesheet" type="text/css" href="style/css/addparking.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                                    <div class="container">
									    <div class="card">
									        <div class="form">
									            <div class="left-side">
									                <div class="left-heading">
									                    <h3>Ajout parking</h3>
									                </div>
									                <div class="steps-content">
									                    <h3>Partie<span class="step-number">1</span></h3>
									                    
									                </div>
									                <ul class="progress-bar">
									                    <li class="active">Informations du parking</li>
									                    <li>Informations complementaires</li>
									                </ul>
									                
									
									                
									            </div>
									            <div class="right-side">
									               <form action="addparking" method="post">
										                 <div class="main active">
										                    <small><i class="fa fa-smile-o"></i></small>
										                    <div class="text">
										                        <h2>Les informations du parking</h2>
										                        <p>saisissez ici les informations relatives au parking</p>
										                    </div>
										                    <div class="input-text">
										                        <div class="input-div">
										                            <input type="text" required require id="user_name" name="email">
										                            <span>email</span>
										                        </div>
										                        <div class="input-div"> 
										                            <input type="text" required name="telephone">
										                            <span>telephone</span>
										                        </div>
										                    </div>
										                    <div class="input-text">
										                        <div class="input-div">
										                            <input type="text" required require name="nombreP">
										                            <span>Nombre place</span>
										                        </div>
										                        <div class="input-div">
										                            <input type="text" required require name="nombreG">
										                            <span>Nombre gerants</span>
										                        </div>
										                    </div>
										                    <div class="input-text">
										                        <div class="input-div">
										                            <select name="region">
										                                <option value="">Selectionner la region</option>
										                                <%if(request.getAttribute("regions")!=null)
										                                	{
										                                	  ArrayList<Region> regions=(ArrayList)request.getAttribute("regions");
										                                	  int idregion=0;
										                                	  for(int i=0;i<regions.size();i++)
										                                	  {
										                                		  out.println("<option value="+regions.get(i).getIdregion()+">"+regions.get(i).getNomregion()+"</option>");
										                                		  idregion=regions.get(i).getIdregion();
										                                	  }
										                                	
										                                	
										                                out.println("</select>");
										                        
										                                out.println("</div>");
										                                out.println("<div class=\"input-div\">");
										                            
										                                out.println("<select name=\"departement\">");
										                                out.println("<option value=''>Selectioner le departement</option>");
										                                for(int i=0;i<regions.size();i++)
										                                {
										                                	ArrayList <Departement> departements=(ArrayList<Departement>) new DepartementHome().getAllDepartementsUniques(regions.get(i).getIdregion());
										                                	DepartementId departementId=new DepartementId();
										                                	for(int j=0;j<departements.size();j++)
										                                	{
										                                		
												                                departementId.setIddepartement(departements.get(j).getId().getIddepartement());
												                                departementId.setIdregion(regions.get(i).getIdregion());
												                                Departement departement=new Departement();
												                                departement.setId(departementId);
												                                //departement.getId().getIddepartement();
												                                out.println("<option value="+departement.getId().getIddepartement()+">"+departements.get(j).getNomdepartement()+"</option>");
												                                
										                                	}
										                                	
										                                }
										                               /* ArrayList <Departement> departements=(ArrayList<Departement>) new DepartementHome().getAllDepartementsUniques(idregion);
									                                	DepartementId departementId=new DepartementId();
									                                	for(int j=0;j<departements.size();j++)
									                                	{
									                                		
											                                departementId.setIddepartement(departements.get(j).getId().getIddepartement());
											                                departementId.setIdregion(idregion);
											                                Departement departement=new Departement();
											                                departement.setId(departementId);
											                                //departement.getId().getIddepartement();
											                                out.println("<option value="+departement.getId().getIddepartement()+">"+departements.get(j).getNomdepartement()+"</option>");
											                                
									                                	}*/
										                                out.println(" </select>");
										                              }
										                                %>
										                        </div>
										                    </div>
										                    <div class="buttons">
										                        <button class="next_button">Suivant</button>
										                    </div>
										                </div>
										                <div class="main">

										                    <small><i class="fa fa-smile-o"></i></small>
										                    <div class="text">
										                        <h2>Informations complementaire du parking</h2>
										                        <p>saisissez les informations restantes</p>
										                    </div>
										                    <div class="input-text">
										                        <div class="input-div">
										                            <input type="text" required require name="heure_ouverture" type="time">
										                            <span>heure d'ouverture</span>
										                        </div>
										                        <div class="input-div"> 
										                            <input type="text" required type="time" name="heure_fermeture">
										                            <span>heure fermeture</span>
										                        </div>
										                    </div>
										                    <div class="input-text">
										                        <div class="input-div">
										                            <select name="etat">
										                              <option value="">Selectionner l'etat du parking</option>
										                              <option value="fermé">Fermé</option>
										                              <option value="ouvert">Ouvert</option>
										                            </select>
										                            
										                        </div>
										                    </div>
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
										                   
										                    <div class="buttons button_space">
										                        <button class="back_button" type="reset">Precedent</button>
										                        <button class="next_button" type="submit">Envoyer</button>
										                    </div>
										                </div>
									               </form>
									            </div>
									        </div>
									    </div>
									</div>
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
<script type="text/javascript" src="style/javascript/addparking.js">

</script>
</html>