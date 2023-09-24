package bdbeans;
// Generated 2 nov. 2022, 16:22:46 by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Detailslocation.
 * @see bdbeans.Detailslocation
 * @author Hibernate Tools
 */
public class DetailslocationHome {

	private static final Log log = LogFactory.getLog(Detailslocation.class);
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

	public  Detailslocation connexion(String login) {
		Session session=null;
		if (null == login ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Detailslocation.class);
			crit.add(Restrictions.eq("login", login.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Detailslocation user = (Detailslocation)o;//sous-classement
			session.close();
			return user;
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			// Critical errors : database unreachable, etc.
			return null;
		}
		/*finally{
			session.close();
		}*/
	}
	@SuppressWarnings("unchecked")
	public List<Detailslocation> getDetailslocations(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Detailslocation.class);
		//crit.add(Restrictions.eq("categorie", "Enseignant".trim()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Detailslocation> res=(ArrayList<Detailslocation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Detailslocation  findLocationByID(DetailslocationId id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Detailslocation.class);
			crit.add(Restrictions.eq("id", id));

			Detailslocation user = (Detailslocation)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	public  Detailslocation findIfNumCarteExiste(String login) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Detailslocation.class);
			crit.add(Restrictions.eq("login", login.trim()));

			Detailslocation user = (Detailslocation)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Detailslocation findIfEmailExiste(String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Detailslocation.class);
			crit.add(Restrictions.eq("email", email.trim()));

			Detailslocation user = (Detailslocation)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Detailslocation findIfTelephoneCarteExiste(String telephone) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Detailslocation.class);
			crit.add(Restrictions.eq("telephone", telephone.trim()));

			Detailslocation user = (Detailslocation)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Detailslocation findIfNumCarteExistePourAutreDetailslocation(String login, int iddetailslocation) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Detailslocation.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.ne("idpersonne", iddetailslocation));
			Detailslocation user = (Detailslocation)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public void persist(Detailslocation transientInstance) {
		log.debug("persisting Detailslocation instance");
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
	public void update(Detailslocation transientInstance) {
		log.debug("update Detailslocation instance");
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
	public void delete(Detailslocation transientInstance) {
		log.debug("deleting Detailslocation instance");
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
	public List<Detailslocation> findByExample(Detailslocation instance) {
		log.debug("finding Detailslocation instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Detailslocation.class);
			List<Detailslocation> results = (List<Detailslocation>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstanceDetailslocation() {
		Session session=null;
		log.debug("finding Detailslocation instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Detailslocation.class);
			List<Detailslocation> results = (List<Detailslocation>)crit.list();
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
	public List<Detailslocation> getAllDetailslocationsUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Detailslocation order by datefin DESC";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Detailslocation> xx=(List<Detailslocation>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public List<Detailslocation> getDetailslocationsPourClient(Client client){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Detailslocation.class);
		crit.add(Restrictions.eq("reservation", client.getReservations()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Detailslocation> res=(ArrayList<Detailslocation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	//Pour permettre a un client de ne voir que les reservations qui le concerne
	public List<Detailslocation> client_Suivrelocations(Client client){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Detailslocation.class);
		crit.add(Restrictions.eq("reservation", client.getReservations()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Detailslocation> res=(ArrayList<Detailslocation>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	
}
