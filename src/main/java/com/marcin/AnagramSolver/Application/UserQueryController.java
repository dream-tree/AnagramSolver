package com.marcin.AnagramSolver.Application;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controllers for the application.
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
@Controller
public class UserQueryController {
	
	private QueryResult queryResult;
	private AnagramsListDAO anagramsListDAO;
	
	@Autowired
	public UserQueryController(QueryResult queryResult, AnagramsListDAO anagramsListDAO) {
		this.queryResult = queryResult;
		this.anagramsListDAO = anagramsListDAO;
	}

	/**
	 * Adds the model for holding user query data and corresponding result data (anagrams).
	 * @param words model holding user query and corresponding result data
	 */
	@RequestMapping("/showForm")
	public String showForm(Model words) {   
		words.addAttribute("theQueryResult", queryResult);  
		return "inputForm";
	}

	/**
	 * Validates user input, processes it and sets result data (anagrams).
	 * @param queryResult object holding user query data and corresponding result data (anagrams)
	 * @param thebindingResult the holder for data binder 
	 */
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("theQueryResult") QueryResult queryResult, 
			BindingResult thebindingResult) {
		if (thebindingResult.hasErrors()) {
			return "inputForm";
		}
		String alphabetized = alphabetize(queryResult.getQuery());   
		String stringOfAnagrams = anagramsListDAO.getAnagramsList(alphabetized);
		String[] setOfAnagrams = stringOfAnagrams.split(" ");
		queryResult.setResultSet(setOfAnagrams);
		return "results";
	}
		
	/**
	 * Supports check out for non-empty input in the search bar.
	 * @param dataBinder SpringFramewrok WebDataBinder object
	 */
	@InitBinder                                                                             
	public void initBinder(WebDataBinder dataBinder) {
	     StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);   
	     dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);                
	}     
	
	/**
	 * Alphabetizes every single word and converts it to lower case.
	 * Alphabetizing means that all chars of a given word are being sorted lexicographically.
	 * New string created in that way is called an alphabetized word.
	 * @param s "real" word to be alphabetized
	 * @return an alphabetized word (a "non-real" word)
	 */
	private static String alphabetize(String s) {
		char[] a = s.toLowerCase().toCharArray();
		Arrays.sort(a);
		return new String(a);
	}	
}