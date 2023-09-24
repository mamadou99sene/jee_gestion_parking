<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/css/styleindex.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css"> 
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
 
</style>
</head>
<body>
   <div class="container">
     <div class="card "> 
        <div class="form"> 
            <div class="left-side col-sm-4">
	             <span></span>
	             <span></span> 
	             <span></span> 
	             <span></span> 
             </div> 
             <div class="right-side col-sm-8">
	               <div class="signin_form s_form ">
	                                <%
										if(request.getAttribute("message")!=null)
										  {
										    String message=(String)request.getAttribute("message");
										    out.println("<span class='text-danger font-weight-bold'>"+message+"</span");
										  }
									  %>
		                 <div class="login">
		                    <h2>connexion</h2>    
		                 </div> 
		                 <form action="index" method="post">
			                  <div class="input_text"> 
			                          <input type="text" id="login" placeholder="Login" name="login" required="required"
			                          <%
			                          if(request.getAttribute("login")!=null)
			                          {
			                        	  String login=(String)request.getAttribute("login");
			                        	  out.println("value="+login);
			                          }
			                          %>
			                          >
			                          <i class="fa fa-user"></i> 
			                  </div> 
			                  <div class="input_text">
			                      <input class="signin_pass" type="password" name="password" placeholder="Mot de passe" id="password" required="required"> 
			                      <i class="fa fa-lock"></i> 
			                      <i class="fa fa-eye-slash"></i> 
			                  </div> 
			                  <div class="login_btn"> 
			                      <button class="login_button" type="submit" id="submit">Se connecter</button> 
			                  </div> 
			                  <div class="forgot">
			                       <p>Vous avez oublié: 
			                             <a href="mdp_oublie">Votre mot de passe</a> ?
			                             
			                       </p> 
			                  </div> 
			                  <div class="create margin">
			                      <a href="inscription" class="create_acc">Creer votre compte <i class="fa fa-long-arrow-right"></i></a> 
			                  </div> 
		                 </form>
	               </div> 
	               
              </div> 
           </div> 
      </div>
</div>
</body>
<script type="text/javascript" src="control_index.js"></script>
<script type="text/javascript" src="style/javascript/index_js.js"></script>
</html>