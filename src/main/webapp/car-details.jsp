<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.Car" %>
<%@ page import="SimiAlex.com.github.AutoStoreJavaEE.entities.FavouriteCar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  	<head>
    	<title>AutoDealer</title>		
  	</head>
   
  	<body>    
        
        <%  
            // recover car object using id
            int carId = Integer.parseInt(req.getParameter("id"));
            CarRepository cr = new CarRepositoryImpl();
            Car car = cr.findById(carId);
	    %>    
		   
        <ul>    
		    <li>Year: ${car.year}</li>
            <li>Price: ${car.price}</li>
            <li>Fuel Type: ${car.fuelType}</li>
            <li>Body Type: ${car.bodyType}</li>
            <li>Mileage: ${car.mileage}</li>
        </ul>
        

        <form action="addToFavourites" method="POST">
            <input type="hidden" name="carId" value="${car.id}">
            <input type="submit" value="Add to favorites">
        </form>

        <!-- update and delete options -->        
		<br>
        <a href="update-car.jsp?id=${car.id}">Update car</a>

        <form action="delete-car" method="POST">
            <input type="hidden" name="carId" value="${car.id}">
            <input type="submit" value="Delete car">
        </form>

        <!-- link to homepage -->
        <br>
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>