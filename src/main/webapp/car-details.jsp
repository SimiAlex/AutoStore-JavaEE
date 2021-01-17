<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.Car" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.FavouriteCar" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl" %>
<%@ page import="javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  	<head>
    	<title>AutoDealer</title>		
  	</head>
   
  	<body>    
        <jsp:include page="header.jsp"/>    
        <h1> ${myCar.make} ${myCar.model} </h1>
		   
        <ul>    
		    <li>Year: ${myCar.year}</li>
            <li>Price: ${myCar.price}</li>
            <li>Fuel Type: ${myCar.fuelType}</li>
            <li>Body Type: ${myCar.bodyType}</li>
            <li>Mileage: ${myCar.mileage}</li>
        </ul>
        

        <form action="addToFavourites" method="POST">
            <input type="hidden" name="carId" value="${myCar.id}">
            <input type="submit" value="Add to favorites">
        </form>

        <!-- update and delete options -->        
		<br>
        
        <form action="update-car" method="POST">
            <input type="hidden" name="carId" value="${myCar.id}">
            <input type="submit" value="Update car">
        </form>

        <form action="delete-car" method="POST">
            <input type="hidden" name="carId" value="${myCar.id}">
            <input type="submit" value="Delete car">
        </form>

        <!-- link to homepage -->
        <br>
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>