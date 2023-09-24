package hibernate.sessionfactory.open;

import org.hibernate.SessionFactory;
import bd.session.factory.configure.HibernateUtil;


public final class SessionFactoryProvider {
    private static final SessionFactory sessionFactory;
    static {
             sessionFactory =HibernateUtil.configureSessionFactory();// new Configuration().configure().buildSessionFactory();
           }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private SessionFactoryProvider() {
    }
}
