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
	    <jsp:include page="header.jsp"/>    
	    <h1>List of cars in your account</h1>

		<table id="customerTable">
			<thead>
				<tr>
					<th>ID</th>
					<th>Make</th>
					<th>Model</th>
					<th>Year</th>
					<th>Price</th>
					<th>Seller</th>
     				<th>Details</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach var="car" items="${sessionScope.carList}" >
				<tr>
					<td>${car.id}</td>
					<td>${car.make}</td>
					<td>${car.model}</td>
					<td>${car.year}</td>
					<td>${car.price}</td>
					<td>${car.seller.name}</td>
					<td>
						<a href="car-details-servlet?id=${car.id}">Details</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
		<a href="home.jsp">Back to home page</a>	
		
  	</body>
</html>