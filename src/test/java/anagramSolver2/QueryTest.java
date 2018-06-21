package anagramSolver2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.marcin.AnagramSolver.Application.HibernateUtility;
import com.marcin.AnagramSolver.Application.WordSet;

public class QueryTest {
	
	private static Session session;
	
	@BeforeClass
	public static void setUp() {		
		SessionFactory factory = HibernateUtility.getInstance();		
		session = factory.getCurrentSession();
		session.beginTransaction();
	}
	
	@Test(expected=javax.persistence.NoResultException.class)
	public void shouldThrownNoResultException1() {
		session.createQuery("from WordSet where alphabetizedWord ='read'").getSingleResult();			
				session.getTransaction().commit();
	}
	
	@Test(expected=javax.persistence.NoResultException.class)
	public void shouldThrownNoResultException2() {
		session.createQuery("from WordSet where alphabetizedWord ='yyyyy'").getSingleResult();			
				session.getTransaction().commit();
	}
	
	@Test
	public void shouldGetRightAnagrams() {
		WordSet wordSet1 = (WordSet) session.createQuery("from WordSet where alphabetizedWord ='aah'")
				.getSingleResult();
		Assert.assertEquals(wordSet1.getMappedAnagrams(), "aah aha ");
		
		WordSet wordSet2 = (WordSet) session.createQuery("from WordSet where alphabetizedWord='aelpp'")
				.getSingleResult();	
		Assert.assertEquals(wordSet2.getMappedAnagrams(), "appel apple pepla ");
		
		WordSet wordSet3 = (WordSet) session.createQuery("from WordSet where alphabetizedWord ='eenrt'")
				.getSingleResult();	
		Assert.assertEquals(wordSet3.getMappedAnagrams(), "enter rente terne treen ");
		
		WordSet wordSet4 = (WordSet) session.createQuery("from WordSet where alphabetizedWord ='aghilnsw'")
				.getSingleResult();
		Assert.assertEquals(wordSet4.getMappedAnagrams(), "shawling whalings ");
	}
	
	@AfterClass
	public static void close() {		
		session.close();
	}
}