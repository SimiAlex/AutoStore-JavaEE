<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.Car" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  	<head>
    	<title>AutoDealer</title>		
  	</head>
  
  	<body>    
	    <h1>List of cars in your account</h1>

		<ul>
			<c:forEach var="car" items="${sessionScope.carList}" >
				<li><a href="car-details?id=${car.id}">${car.description}</a></li>
			</c:forEach>
		</ul>
		
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>