package com.wipro.srs.util.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wipro.srs.controller.AdministratorController;

	 
	public class HibernateUtil {
		
		static Logger log=Logger.getLogger(AdministratorController.class.getName());	
	 
		 private static final SessionFactory sessionFactory = buildSessionFactory();
		 
		    private static SessionFactory buildSessionFactory() {
		        try {
		            // Create the SessionFactory from hibernate.cfg.xml
		            return new Configuration().
		                    configure().buildSessionFactory();
		        }
		        catch (Throwable ex) {
		            // Make sure you log the exception, as it might be swallowed
		           log.info("Session creation error at HibernateUtil "+ex);
		            throw new ExceptionInInitializerError(ex);
		        }
		    }
			public static SessionFactory getSessionFactory()
			{
				return sessionFactory;
			}

	 
		public static void shutdown() {
			// Close caches and connection pools
			getSessionFactory().close();
		}
	 
	}


