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
 * Home object for domain model class Region.
 * @see bdbeans.Region
 * @author Hibernate Tools
 */
public class RegionHome {

	private static final Log log = LogFactory.getLog(Region.class);
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

	public  Region connexion(String login) {
		Session session=null;
		if (null == login ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Region.class);
			crit.add(Restrictions.eq("login", login.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Region user = (Region)o;//sous-classement
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
	public List<Region> getAllRegions(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Region.class);
		//crit.add(Restrictions.eq("categorie", "Region".trim()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Region> res=(ArrayList<Region>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Region  findRegionByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Region.class);
			crit.add(Restrictions.eq("idregion", id));

			Region region = (Region)crit.uniqueResult();
			if (region==null){session.close();return null;}
			else {session.close();return region;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	public  Region findIfNumCarteExiste(String login) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Region.class);
			crit.add(Restrictions.eq("login", login.trim()));

			Region user = (Region)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Region findIfEmailExiste(String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Region.class);
			crit.add(Restrictions.eq("email", email.trim()));

			Region user = (Region)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Region findIfTelephoneCarteExiste(String telephone) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Region.class);
			crit.add(Restrictions.eq("telephone", telephone.trim()));

			Region user = (Region)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Region findIfNumCarteExistePourAutrePersonne(String login, int idpers) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Region.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.ne("idpersonne", idpers));
			Region user = (Region)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public void persist(Region transientInstance) {
		log.debug("persisting Region instance");
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
	public void update(Region transientInstance) {
		log.debug("update Region instance");
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
	public void delete(Region transientInstance) {
		log.debug("deleting Region instance");
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
	public List<Region> findByExample(Region instance) {
		log.debug("finding Region instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Region.class);
			List<Region> results = (List<Region>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstanceRegion() {
		Session session=null;
		log.debug("finding Region instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Region.class);
			List<Region> results = (List<Region>)crit.list();
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
	public List<Region> getAllregionsUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Region";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Region> xx=(List<Region>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
}
