/**
 * 
 */
 function getXhR()
 {
	var xhr=new XMLHttpRequest();
    return xhr;
}
function envoi(nom)
{
	var xhr=getXhR();
	xhr.onreadystatechange=function()
	{
		if(xhr.readyState==4&&xhr.status==200)
		{
			document.getElementById("nomdep").innerHTML = xhr.responseText;
		}
		else
		{
			document.getElementById("nomdep").innerHTML ="Erreur: code d etat " + xhr.status + " " + xhr.statusText;
		}
		
	};
	var url="serveurAjax?nomdepartement="+nom;
	xhr.open("GET",url,true);
	xhr.send(null);
}