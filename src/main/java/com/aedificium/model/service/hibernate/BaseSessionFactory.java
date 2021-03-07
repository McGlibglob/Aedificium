package com.aedificium.model.service.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseSessionFactory {
	


	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
    private static SessionFactory sf;

    public BaseSessionFactory() {
    }
    
    public static Configuration getConfig() {
    	Configuration config = new Configuration();
    	config.configure();
    	return config;
    }//End of getConfig() method
    
    private static SessionFactory getSessionFactory() {
    	try {
        	Configuration config = getConfig();
            sf = config
                    .buildSessionFactory();

        } catch (Exception e) {
            throw new HibernateException ("Failed to create Session Factory");
        }
    	return sf;
    }//End of getConfig() method
    
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sf == null) {
                sf = getSessionFactory();
            }
            session = (sf != null) ? sf.openSession() : null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    
    public static void closeFactory() throws HibernateException {
        closeSessionAndFactory();
    }

    public static void closeSessionAndFactory() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }

        if (sf != null) {
            sf.close();
            sf = null;
        }
    }//End of closeSessionAndFactory
    
    public void createObject(Object object) {
    	
    	try {
    	Session session = BaseSessionFactory.getSession();
		Transaction transx = session.beginTransaction();
		session.save(object);
		transx.commit();
    	}catch(HibernateException e) {
    		throw new HibernateException ("Could not write to database.");
    	}
		finally {
    	BaseSessionFactory.closeSessionAndFactory();
		}
    }//End of createObject();
    
    public void deleteObject(Object object) {
    	try {
    	Session session = BaseSessionFactory.getSession();
		Transaction transx = session.beginTransaction();
		session.delete(object);
		transx.commit();
    	}catch(HibernateException e) {
    		throw new HibernateException ("Could not write to database.");
    	}
		finally {
    	BaseSessionFactory.closeSessionAndFactory();
		}
    	
    }//End of deleteObject().
    



}//End of BaseSessionFactory class
