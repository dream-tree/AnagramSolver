package com.marcin.AnagramSolver.Application;

import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

/**
 * Class serves as a model for holding user input (query from a web form) 
 * and the corresponding result data (anagrams).
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
@Component
public class QueryResult {

	/**
	 * User input data holder.
	 */
	@NotNull
	@Pattern(regexp = "[a-zA-Z]{3,}", message="Only letters allowed (3 minimum).")
	private String query;
	
	/**
	 * User query result data holder.
	 * Used to expose reference data to a web view through the accessor method.
	 */
	private String[] resultSet;
	
	public QueryResult() {
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String[] getResultSet() {
		return resultSet;
	}

	public void setResultSet(String[] resultSet) {
		this.resultSet = resultSet;
	}

	@Override
	public String toString() {
		return Arrays.toString(resultSet);
	}	
}