/**
 * 
 */
 var prix=document.getElementById('prix');
 var prix_m=document.getElementById('prix_m');
 var submit=document.getElementById('submit');
 submit.addEventListener('click',function(e)
{
	if(prix.validity.valueMissing)
	{
		  e.preventDefault();
		  prix_m.textContent="saisir le prix";
          prix_m.style.color="red";
          prix_m.style.fontStyle="italic";
          prix.style.border="1px solid red";
	}
},false);