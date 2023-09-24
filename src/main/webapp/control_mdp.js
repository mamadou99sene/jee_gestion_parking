/**
 * 
 */
 var password=document.getElementById('password');
 var vpassword=document.getElementById('vpassword');
  var inc=document.getElementById('incorrespondance');
 var envoi=document.getElementById('envoi');
 var email=document.getElementById('email');
 envoi.addEventListener('click',function(e)
 {
	if(password.value!=vpassword.value)
	{
		e.preventDefault();
		  inc.textContent="vos mot de passes ne correspondent pas";
          inc.style.color="red";
          inc.style.fontStyle="italic";
        vpassword.style.border="1px solid red";
	}
	if(password.validity.valueMissing)
	{
		password.style.border="1px solid red";
	}
	if(vpassword.validity.valueMissing)
	{
		vpassword.style.border="1px solid red";
	}
	if(email.validity.valueMissing)
	{
		email.style.border="1px solid red";
	}
},false);