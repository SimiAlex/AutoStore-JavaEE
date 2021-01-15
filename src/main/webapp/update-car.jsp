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

	    <h1>Select car to update</h1>
		<% 
			


		%> 

		<ul>
			<% 
				for (Car car : cars) 
					{ 
						out.println("<li>" + car.getDescription() + "</li>");
					}
			%>
		</ul>
		<br>
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>