package com.marcin.AnagramSolver.Application;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class constructs the Hibernate ORM' SessionFactory singleton object
 * in the eager initialization mode.
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
public class HibernateUtility {

	private static SessionFactory sessionFactory;
	
	private HibernateUtility() {
	}
	
	/**
	 * Public method returning the SessionFactory singleton object.
	 * @return SessionFactory singleton object
	 */
	public static SessionFactory getInstance() {
		if(sessionFactory == null) {
			synchronized (SessionFactory.class) {
				if(sessionFactory == null) {
					sessionFactory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(WordSet.class)
							.buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}	
}
