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
		<% 
			//recover Set of cars
            CarRepository carRepository = new CarRepositoryImpl();
            Set<Car> cars = carRepository.findAll();


		%> 

		<ul>
			<% 
                for (Car car : cars) 
                {
                    out.print(String.format("<li><a href=\"car-details?id=%d\">%s</a></li>", car.getId(), car.toString()));
                }
			%>
		</ul>
		<br>
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>