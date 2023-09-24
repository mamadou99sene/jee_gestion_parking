/**
 * 
 */
 var date_deb=document.getElementById('date_debut');
 var date_f=document.getElementById('date_fin');
 var montant=document.getElementById('montant');
 var envoi=document.getElementById('envoi');
 var date_dm=document.getElementById('date_dm');
 var date_fm=document.getElementById('date_fm');
 var montant_m=document.getElementById('montant_m');
 envoi.addEventListener('click',function(e)
 {
	if(date_deb.validity.valueMissing)
	{
		  e.preventDefault();
		  date_dm.textContent="date debut manquante";
          date_dm.style.color="red";
          date_dm.style.fontStyle="italic";
          date_deb.style.border="1px solid red";
	}
	
	if(date_f.validity.valueMissing)
	{
		  e.preventDefault();
		  date_fm.textContent="date de fin manquante";
          date_fm.style.color="red";
          date_fm.style.fontStyle="italic";
          date_f.style.border="1px solid red";
	}
	if(montant.validity.valueMissing)
	{
		  e.preventDefault();
		  montant_m.textContent="montant manquant";
          montant_m.style.color="red";
          montant_m.style.fontStyle="italic";
          montant.style.border="1px solid red";
	}
},false);
