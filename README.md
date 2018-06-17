# AnagramSolver
Web based app serving as english anagrams solver. It takes a text and finds out all possible word combinations (anagrams) using english dictionary.
User can query the database by typing a "real" word or any other sequence of letters.
Query must contain minimum 3 leters and must not contain any digit, space or any other special character (e.g. '?', '*' or '/'). Input is validated using Hibernate Validator. Search is case-insensitive.

Internally, user input is alphabetized what means that all chars of a given word/sequence of letters are being sorted lexicographically. New string created in that way is called an alphabetized word. Application looks for corresponding anagrams matching those ones saved in the database. In real it is based on key-value pairs (alphabetized word and mapped anagrams) defined and saved in the database before building the features of the actual web application. Querying the base means looking for a single alphabetized word and its mapped counterpart list of "real" words. If there is no matching result, user gets "Nothing was found" info. 

List of english words used in the database come from https://numeracy.co/artnez/word-lists/sources/enable page.
Enable is The Enhanced North American Benchmark LExicon (ENABLE) and it is word list and reference available for Scrabble players. 

----

Used technologies:
Spring MVC, Hibernate ORM, Hibenate Validator, HTML, JSP, JSTL.
Making this app I didn't mind to pay much attention to the presentation layer (no graphical bells and whistles here). The main purpose was to build a web app doing its job: it enables the user to query the database and to display the results on the page. 

---

Project #005.