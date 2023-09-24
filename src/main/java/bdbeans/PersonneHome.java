 package bdbeans;
// Generated 2 nov. 2022, 16:22:46 by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*; 

import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Personne.
 * @see bdbeans.Personne
 * @author Hibernate Tools
 */
public class PersonneHome {

	private static final Log log = LogFactory.getLog(PersonneHome.class);
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

	public  Personne connexion(String login,String password) {
		Session session=null;
		if (null == login ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.and(Restrictions.eq("password", password.trim())));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Personne user = (Personne)o;//sous-classement
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
	public List<Personne> getAllPersonnes(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Personne.class);
		//crit.add(Restrictions.eq("nom", "SENE".trim()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Personne> res=(ArrayList<Personne>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Personne  findPersonneByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("idpersonne", id));

			Personne user = (Personne)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	public  Personne findIfLoginExiste(String login) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));

			Personne user = (Personne)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Personne findIfEmailExiste(String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("email", email.trim()));

			Personne user = (Personne)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Personne findIfTelephoneCarteExiste(String telephone) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("telephone", telephone.trim()));

			Personne user = (Personne)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Personne findIfNumCarteExistePourAutrePersonne(String login, int idpers) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.ne("idpersonne", idpers));
			Personne user = (Personne)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public void persist(Personne transientInstance) {
		log.debug("persisting Personne instance");
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
	public void update(Personne transientInstance) {
		log.debug("update Personne instance");
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
	public void delete(Personne transientInstance) {
		log.debug("deleting Personne instance");
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
	public List<Personne> findByExample(Personne instance) {
		log.debug("finding Personne instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Personne.class);
			List<Personne> results = (List<Personne>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstancePersonne() {
		Session session=null;
		log.debug("finding Personne instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Personne.class);
			List<Personne> results = (List<Personne>)crit.list();
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
	public List<Personne> getAllPersonnesUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ();
	    String SQL_QUERY ="SELECT p from Personne p";// where p.idpersonne=:x";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Personne> xx=(List<Personne>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public Personne getPersonneById(int idpersonne)
	{
		Session session = sessionFactory.openSession ();
	    String SQL_QUERY ="from Personne p where idpersonne=:id";// where p.idpersonne=:x";
	    Query query = session.createQuery (SQL_QUERY);
	   query.setInteger("id", idpersonne);
	   Personne p=(Personne) query.uniqueResult();
	   session.close();
	   return p;
		
	}
	public static void sendMail(String from,String pwd,String to,String objet,String msg){
	    //Propri�t�s
	    Properties p = new Properties();
	    p.put("mail.smtp.host", "smtp.gmail.com");
	    p.put("mail.smtp.starttls.enable", "true");
	    
	    p.put("mail.smtp.starttls.required", "true");
	    p.put("mail.smtp.ssl.protocols","TLSv1.2");
	    //p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    p.put("mail.smtp.auth", "true");
	    p.put("mail.smtp.port", "587");
	    p.put("mail.smtp.ssl.trust", "*");
	    //Session
	    javax.mail.Session s = javax.mail.Session.getDefaultInstance(p,
	      new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication(from, pwd);
	      }
	    });
	    //composer le message
	    try {
	      Message m = new MimeMessage(s);
	      m.setFrom(new InternetAddress(from));
	      m.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
	      m.setSubject(objet);
	      m.setText(msg);
	      //envoyer le message
	      Transport.send(m);
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
	  }
	public static String generation_password()
    {
    	String combinaison="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    	Random rand=new Random();
    	StringBuilder password=new StringBuilder();
    	for(int i=0;i<8;i++)
    	{
    		int valeur=rand.nextInt(0,combinaison.length());
    		password=password.append(combinaison.charAt(valeur));
    	}
    	
    return password.toString();
  }
	public  Personne recuperation_mdp(String login,String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
            crit.add(Restrictions.and(Restrictions.eq("email", email.trim())));
			Personne user = (Personne)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
}
