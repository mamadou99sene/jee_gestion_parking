/**
 * 
 */
 var login=document.getElementById('login');
 var email=document.getElementById('email');
 var envoi=document.getElementById('envoi');
 var login_m=document.getElementById('login_mq');
 var email_m=document.getElementById('email_mq');
 envoi.addEventListener('click',function(e)
 {
	if(login.validity.valueMissing)
	{
		e.preventDefault();
		login_m.textContent="login manquant!";
        login_m.style.color="red";
        login_m.style.fontStyle="italic";
         login.style.border="1px solid red";
	}
	if(email.validity.valueMissing)
	{
		e.preventDefault();
		email_m.textContent="email manquant!";
        email_m.style.color="red";
        email_m.style.fontStyle="italic";
         email.style.border="1px solid red";
	}
},false);