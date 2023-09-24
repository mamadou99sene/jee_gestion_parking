/**
 * 
 */
 var immatriculation=document.getElementById('immatriculation');
 var marque=document.getElementById('marque');
 var model=document.getElementById('model');
 var serie=document.getElementById('serie');
 var envoi=document.getElementById('envoi');
 var immatriculation_m=document.getElementById('immatriculation_m');
 var marque_m=document.getElementById('marque_m');
 var model_m=document.getElementById('model_m');
  var serie_m=document.getElementById('serie_m');
 envoi.addEventListener('click',function(e)
 {
	if(immatriculation.validity.valueMissing)
	{
		  e.preventDefault();
		  immatriculation_m.textContent="saisir l'immatriculation";
          immatriculation_m.style.color="red";
          immatriculation_m.style.fontStyle="italic";
          immatriculation.style.border="1px solid red";
	}
	
	if(marque.validity.valueMissing)
	{
		  e.preventDefault();
		  marque_m.textContent="donner la marque";
          marque_m.style.color="red";
          marque_m.style.fontStyle="italic";
          marque.style.border="1px solid red";
	}
	if(model.validity.valueMissing)
	{
		  e.preventDefault();
		  model_m.textContent="donner le model";
          model_m.style.color="red";
          model_m.style.fontStyle="italic";
          model.style.border="1px solid red";
	}
	if(serie.validity.valueMissing)
	{
		  e.preventDefault();
		  serie_m.textContent="donner la serie";
          serie_m.style.color="red";
          serie_m.style.fontStyle="italic";
          serie.style.border="1px solid red";
	}
},false);