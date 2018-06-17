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
		<strong>Welcome to the output page.</strong>
	</h1>
	<br>
	
	<!-- Not used. -->
	<%-- <p>Found words:</p> 
	<strong>${theQueryResult}</strong>
	<br> --%>
		
	Found words:
	<ul>
		<c:forEach var="temp" items="${theQueryResult.resultSet}">
			<li>${temp}</li>
		</c:forEach>
	</ul>

	<form:form action="showForm">
		<input type="submit" value="Go back" />
	</form:form>

	<br>
	
</body>
</html>