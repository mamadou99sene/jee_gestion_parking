package bdbeans;
// Generated 2 nov. 2022, 16:22:46 by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Reservation.
 * @see bdbeans.Reservation
 * @author Hibernate Tools
 */
public class ReservationHome {

	private static final Log log = LogFactory.getLog(ReservationHome.class);
Session session;
	private static final SessionFactory sessionFactory= hibernate.sessionfactory.open.SessionFactoryProvider.getSessionFactory();
    
	protected SessionFactory getSessionFactory() {
	try {
		return sessionFactory;
	} catch (Exception e) {
		log.error("Could not locate SessionFactory in JNDI", e);
		throw new IllegalStateException("Could not locate SessionFactory in JNDI");
	}
}

	
	@SuppressWarnings("unchecked")
	public List<Reservation> getAllReservations(Gerant gerant){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.eq("gerant", gerant));
		crit.addOrder(Order.desc("idreservation"));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public  Reservation  findReservationByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Reservation.class);
			crit.add(Restrictions.eq("idreservation", id));

			Reservation user = (Reservation)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	
	public void persist(Reservation transientInstance) {
		log.debug("persisting Reservation instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		//new RealEncryption(.docry(transientInstance));
		ss.save(transientInstance);
		tx.commit();
		ss.close();
		log.debug("persist successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("persist failed", re);
		throw re;
	}
	}
	public void update(Reservation transientInstance) {
		log.debug("update Reservation instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(transientInstance);
		tx.commit();
		ss.close();
		log.debug("update successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("update failed", re);
		throw re;
	}
	}
	public void delete(Reservation transientInstance) {
		log.debug("deleting Reservation instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);
		tx.commit();
		ss.close();
		log.debug("delete successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("delete failed", re);
		throw re;
	}
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> findByExample(Reservation instance) {
		log.debug("finding Reservation instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Reservation.class);
			List<Reservation> results = (List<Reservation>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstanceReservation() {
		Session session=null;
		log.debug("finding Reservation instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Reservation.class);
			List<Reservation> results = (List<Reservation>)crit.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			session.close();
			return results.size();
		} catch (RuntimeException re) {
			session.close();
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List<Reservation> getAllReservationsUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Reservation order by idreservation desc";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Reservation> xx=(List<Reservation>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public List<Reservation> getReservationNonValide(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Reservation where etat=:etat";
	    Query query = session.createQuery (SQL_QUERY);
	    query.setString("etat", "non validée");
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Reservation> xx=(List<Reservation>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public List<Reservation> getReservationNonValideByGerant(Gerant gerant){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.eq("gerant", gerant));
		crit.add(Restrictions.and(Restrictions.eq("etat", "non validée")));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public List<Reservation> getReservationNonValidePourClient(Client client){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.eq("client", client));
		crit.add(Restrictions.and(Restrictions.eq("etat", "non validée")));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public List<Reservation> getAllReservationsNonGere(Gerant gerant){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.isNull("gerant"));
		crit.add(Restrictions.and(Restrictions.eq("departement", gerant.getParking().getDepartement())));
		crit.addOrder(Order.desc("idreservation"));	
		@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public List<Reservation> AdmingetAllReservation(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.isNotNull("gerant"));
		crit.addOrder(Order.desc("idreservation"));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public List<Reservation> AdmingetReservationNonGeree(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.isNull("gerant"));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public List<Reservation> suivreReservationClient(Client client){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.isNotNull("gerant"));
		crit.add(Restrictions.and(Restrictions.and(Restrictions.eq("client", client))));
		crit.addOrder(Order.desc("idreservation"));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
	public List<Reservation> getReservationsvalideByGerant(Gerant gerant){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Reservation.class);
		crit.add(Restrictions.eq("gerant", gerant));
		crit.add(Restrictions.and(Restrictions.eq("etat", "validée")));
		crit.addOrder(Order.desc("idreservation"));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			/*session.close();*/
		    List<Reservation> res=(ArrayList<Reservation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
		
	}
}
