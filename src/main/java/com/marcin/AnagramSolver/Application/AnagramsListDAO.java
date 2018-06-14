package com.marcin.AnagramSolver.Application;

/**
 * Base interface for CRUD operations and common queries.
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
public interface AnagramsListDAO {

	/**
	 * Gets all matching words from the database that are anagrams of the user query string.
	 * @param alphabetizedWord string of letters from user query sorted lexicographically
	 * @return string of anagrams
	 */
	public String getAnagramsList(String alphabetizedWord);
	
}
