/**
 * 
 */
 var prenom=document.getElementById('val-username');
 var prenom_m=document.getElementById('prenom_mq');
 var envoi=document.getElementById('envoi');
 var nom=document.getElementById('nom');
 var nom_m=document.getElementById('nom_mq');
 var email=document.getElementById('email');
 var email_m=document.getElementById('email_mq');
 var telephone=document.getElementById('telephone');
 var telephone_m=document.getElementById('telephone_mq');
 var login=document.getElementById('login');
 var login_m=document.getElementById('login_mq');
 envoi.addEventListener('click',function(e)
 {
	if(prenom.validity.valueMissing)
	{
		  e.preventDefault();
          prenom_m.textContent="Saisissez votre prenom";
          prenom_m.style.color="red";
          prenom_m.style.fontStyle="italic";
          prenom.style.border="1px solid red";
	}
	if(nom.validity.valueMissing)
	{
		  e.preventDefault();
          nom_m.textContent="Saisissez votre nom";
          nom_m.style.color="red";
          nom_m.style.fontStyle="italic";
          nom.style.border="1px solid red";
	}
	if(email.validity.valueMissing)
	{
		  e.preventDefault();
          email_m.textContent="Saisissez votre email";
          email_m.style.color="red";
          email_m.style.fontStyle="italic";
          email.style.border="1px solid red";
	}
	if(telephone.validity.valueMissing)
	{
		  e.preventDefault();
          telephone_m.textContent="telephone manquant";
          telephone_m.style.color="red";
          telephone_m.style.fontStyle="italic";
          telephone.style.border="1px solid red";
	}
	if(login.validity.valueMissing)
	{
		  e.preventDefault();
          login_m.textContent="login manquant";
          login_m.style.color="red";
          login_m.style.fontStyle="italic";
          login.style.border="1px solid red";
	}
	
},false);