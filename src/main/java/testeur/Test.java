package testeur;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import bdbeans.ClientHome;
import bdbeans.ClientId;
import bdbeans.Departement;
import bdbeans.DepartementHome;
import bdbeans.DepartementId;
import bdbeans.Detailslocation;
import bdbeans.DetailslocationHome;
import bdbeans.DetailslocationId;
import bdbeans.Gerant;
import bdbeans.GerantHome;
import bdbeans.GerantId;
import bdbeans.Parking;
import bdbeans.ParkingHome;
import bdbeans.Personne;
import bdbeans.PersonneHome;
import bdbeans.Place;
import bdbeans.PlaceHome;
import bdbeans.Region;
import bdbeans.RegionHome;
import bdbeans.Reservation;
import bdbeans.ReservationHome;
import bdbeans.Client;
public class Test {

	public static void main(String[] args) {
	BasicConfigurator.configure();
	/*Personne personne=new Personne();
	personne.setPrenom("Saliou");
	personne.setNom("ly");
	personne.setAdresse("Guediawaye");
	personne.setEmail("ly@gmail.com");
	personne.setLogin("Saliou@");
	personne.setPassword("123ly");
	personne.setProfil("gerant");
	personne.setTelephone("774567895");
	personne.setNumerocarteidentite("1145199800345");
	
	//new PersonneHome().persist(personne);
	Log log = LogFactory.getLog(Test.class);
	List<Personne> allpersonne=new PersonneHome().getAllPersonnes();
	for(int i=0;i<allpersonne.size();i++)
	{
		log.debug(allpersonne.get(i).getPrenom()+" "+allpersonne.get(i).getNom());
	}
	personne=new PersonneHome().connexion("Seck@","1235");
	if(personne!=null)
	log.debug(personne.getAdresse());
	else
		log.debug("Incorrect");
	//int nombre=new PersonneHome().countPersonne();
	//log.debug("Le nombre d'enregistrement est "+nombre);
	
	Personne personne2=new Personne();
	personne2=new PersonneHome().findIfNumCarteExistePourAutrePersonne("Senemomo@", 10);
	System.out.println(personne2.getNumerocarteidentite());
	Personne personne3=new Personne();
	personne3=new PersonneHome().findIfLoginExiste("Seck@");
	if(personne3!=null)
		{
			System.out.println("Ce login existe dèja et c'est pour "+personne3.getPrenom()+" "+personne3.getNom());
		}
	else
	{
		System.out.print("Login valide");
	}
	Region region =new Region();
	region=new RegionHome().findRegionByID(4);
	//new RegionHome().persist(region);
	DepartementId depId=new DepartementId();
	depId.setIdregion(region.getIdregion());
	Departement dep=new Departement();
	dep.setNomdepartement("Diourbel");
	dep.setRegion(region);
	//new DepartementHome().persist(dep);
	Region region=new RegionHome().findRegionByID(1);
	System.out.println(region.getNomregion());
	List<Departement> alldepartement=new DepartementHome().getAllDepartementsUniques(region.getIdregion());
	for(int i=0;i<alldepartement.size();i++)
	{
		System.out.println(alldepartement.get(i).getNomdepartement());
	}
	int nombre_client=new ClientHome().findNumberOfInstanceClient();
	System.out.println("Le nombre de client est de "+nombre_client);
	ArrayList<Client> clients=new ArrayList<Client>();
	clients=(ArrayList)new ClientHome().getAllClientsUniques();
	ClientId clientId=new ClientId();
	//int dernierid=clientId.getIdclient();
	int dernierid=clients.get(clients.size()-1).getId().getIdclient();
	System.out.println("nombre "+dernierid);
	ArrayList<Gerant> all_gerant=(ArrayList) new GerantHome().getAllGerants();
	for(int i=0;i<all_gerant.size();i++)
	{
		System.out.println(all_gerant.get(i).getPersonne().getTelephone());
	}*/
	ArrayList<Parking> allparking=(ArrayList<Parking>) new ParkingHome().getAllParkingsUniques();
	for(int j=0;j<allparking.size();j++)
	{
		System.out.println(j+" "+allparking.get(j).getDepartement().getNomdepartement());
	}
	ArrayList<Place>les_places=(ArrayList<Place>) new PlaceHome().getAllPlacesUniques();
	int id_dernierPlace=les_places.get(les_places.size()-1).getId().getIdplace();
	System.out.println(id_dernierPlace);
	GerantId id=new GerantId();
	id.setIdgerant(1);
	id.setIdpersonne(7);
	Gerant gerant=new Gerant();
	gerant.setId(id);
	/*ArrayList<Reservation> res=(ArrayList<Reservation>) new ReservationHome().getAllReservationsNonGere(gerant);
	System.out.println(res.get(0).getHeurereservation());
	/*ClientId cid=new ClientId();
	cid.setIdclient(3);
	cid.setIdpersonne(9);
	Client client=new ClientHome().findClientByID(cid);
	ArrayList<Reservation> res_cl=(ArrayList<Reservation>) new ReservationHome().getReservationNonValidePourClient(client);
	System.out.println(res_cl.size());
	ArrayList<Departement> dep=(ArrayList<Departement>) new DepartementHome().getAllDepartements();
	System.out.println(dep.size());*/
	DetailslocationId det=new DetailslocationId();
	det.setIdlocation(1);
	det.setIdparking(1);
	det.setIdplace(1);
	det.setIdreservation(1);
	ClientId clientId=new ClientId();
	clientId.setIdclient(7);
	clientId.setIdpersonne(13);
	Client client=new ClientHome().findClientByID(clientId);
	List<Detailslocation> detl=new DetailslocationHome().client_Suivrelocations(client);
	System.out.println(client.getPersonne());
	
	
	
	 }
	

}
