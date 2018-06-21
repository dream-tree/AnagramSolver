package com.marcin.AnagramSolver.Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * DAO class implementing the {@link AnagramsListDAO} interface
 * for CRUD operations and common queries.
 * This implementation uses the Hibernate ORM framework.
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
@Repository
public class AnagramsListDAOImpl implements AnagramsListDAO {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAnagramsList(String alphabetizedWord) {		
		SessionFactory sessionFactory = HibernateUtility2.getInstance();			
		Session session = sessionFactory.getCurrentSession();
		WordSet wordSet = null;
		try {
			session.beginTransaction();	
			wordSet = (WordSet) session.createQuery("from WordSet where alphabetizedWord ='"
					+ alphabetizedWord + "'").getSingleResult();			
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}		
		// '\n' avoids white spaces to prevent splitting the result string 
		// into separate words in further processing
		return wordSet == null ? "Nothing\nwas\nfound" : wordSet.getMappedAnagrams();
	}
}