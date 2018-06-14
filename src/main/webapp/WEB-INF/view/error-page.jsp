<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
</head>
<body>

	<h1>
		<strong>Welcome to the English Word-Anagramator</strong>
	</h1>

	<form:form action="processForm" modelAttribute="wordset">		
		Enter letters to find a word: <form:input path="userInput"/>	
	</form:form>
	
	<a href="http://www.onet.pl">Onet</a>

</body>
</html>