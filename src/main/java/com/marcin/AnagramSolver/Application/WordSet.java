package com.marcin.AnagramSolver.Application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Class mapping POJO to the relational database.
 * Each instance of the class holds a keyword called {@link #alphabetizedWord} 
 * mapping to a string consisting of a list of its anagrams {@link #mappedAnagrams}.
 * 
 * @author dream-tree
 * @version 2.00, June 2018
 */
@Entity
@Table(name="word_base")
@Component
public class WordSet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * Points if a given key-value pair (alphabetized word and all of its anagrams) 
	 * is an original database entry or is added by the user.
	 * Original database entry cannot be deleted.
	 * <ul>
	 * <li> 0 means an original database entry</li>
	 * <li> 1 means a database entry added by user</li>
	 * </ul>
	 * Note: Any feature using this field is not developed yet.
	 */
	@Column(name="marker")
	private int marker;
	
	/**
	 * An alphabetized word (key).
	 * Alphabetized means that all chars of a given word were lexicographically sorted.
	 * New string created in that way is called an alphabetized word.
	 */
	@Column(name="alphabetized_word")
	private String alphabetizedWord;
	
	/**
	 * String of anagrams mapped to a given alphabetized word (value).
	 */
	@Column(name="mapped_anagrams")
	private String mappedAnagrams;
		
	public WordSet() {
	}
	
	public WordSet(int marker, String alphabetizedWord, String mappedAnagrams) {
		this.marker = marker;
		this.alphabetizedWord = alphabetizedWord;
		this.mappedAnagrams = mappedAnagrams;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarker() {
		return marker;
	}

	public void setMarker(int marker) {
		this.marker = marker;
	}

	public String getAlphabetizedWord() {
		return alphabetizedWord;
	}

	public void setAlphabetizedWord(String alphabetizedWord) {
		this.alphabetizedWord = alphabetizedWord;
	}

	public String getMappedAnagrams() {
		return mappedAnagrams;
	}

	public void setMappedAnagrams(String mappedAnagrams) {
		this.mappedAnagrams = mappedAnagrams;
	}

	@Override
	public String toString() {
		return "WordSet [id=" + id + ", marker=" + marker + ", alphabetizedWord=" + alphabetizedWord
				+ ", mappedAnagrams=" + mappedAnagrams + "]";
	}
}	