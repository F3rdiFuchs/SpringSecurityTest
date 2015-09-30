<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>LAlala</title>
	</head> 
	<body>
		<h1>Startseite</h1>
			<div>
				<sec:authorize access="isAnonymous()">
					<a href="<c:url value="/login" />">Login</a><br>
				</sec:authorize>
			</div>
			
			<div>
				<sec:authorize access="hasRole('ADMIN')" >
	            	<label><a href="#">New User</a></label><br>
	       		</sec:authorize>
       		</div>
       		
       		<div>
				<sec:authorize access="isAuthenticated()" >
	            	<label><a href="<c:url value="/logout" />">Logout</a></label><br>
	       		</sec:authorize>
       		</div>
	</body>
</html>