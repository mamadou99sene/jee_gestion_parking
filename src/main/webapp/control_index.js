/**
 * 
 */
 var login=document.getElementById('login');
 var password=document.getElementById('password');
  var submit=document.getElementById('submit');
  submit.addEventListener('click',function(e)
  {
	if(login.validity.valueMissing)
	{
		 e.preventDefault();
         login.style.border="1px solid red";
	}
	if(password.validity.valueMissing)
	{
		 e.preventDefault();
         password.style.border="1px solid red";
	}
},false);