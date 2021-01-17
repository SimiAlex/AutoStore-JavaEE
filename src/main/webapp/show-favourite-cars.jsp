<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.Car" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.FavouriteCar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  	<head>
    	<title>AutoDealer</title>		
  	</head>
  
  	<body>    
    	<jsp:include page="header.jsp"/>    
	    <h1>Favourite cars</h1>
		<% 
			FavouriteCar fc = (FavouriteCar) session.getAttribute("favouriteCar");

			if(fc == null)
			{
				fc = new FavouriteCar();
				session.setAttribute("favouriteCar", fc);
			}  
		%> 

		<ul>
			<c:forEach items="${favouriteCar.favoriteCars}" var="car">
				<li>${car.description}</li>
			</c:forEach>
		</ul>
		<br>
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>