package com.marcin.AnagramSolver.DatabaseSetup;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.marcin.AnagramSolver.Application.WordSet;

/**
 * Class saves all entries to the database.
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
public class BaseDump {
	
	private static Map<String, List<String>> map = WordParser.readWords3();

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(WordSet.class)
				.buildSessionFactory();
		
		Session session;
		
		try {
			for(String s : map.keySet()) {
				session = factory.getCurrentSession();
				session.beginTransaction();
				String wordSet = BaseDump.mapPairs(map.get(s));
				WordSet wordBase = new WordSet(0, s, wordSet);			
				session.save(wordBase);
				session.getTransaction().commit();
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
	/**
	 * 
	 * @param list all possible anagrams mapped to a given alphabetized word
	 * @return result string of these anagrams
	 */
	public static String mapPairs(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s).append(" ");
		}
		return sb.toString();
	}
}