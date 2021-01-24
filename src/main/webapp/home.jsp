<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title>AutoDealer</title>
    <link rel="stylesheet" type="text/css" media="screen" href="css/page-general.css"/>
	
  </head>
  
  <body>
        
    <jsp:include page="header.jsp"/>    
    <h1>Home Page</h1>
    
        <a href="getCarList">View list of cars</a><br>
        <a href="add-car-form.jsp">Add car</a><br>
        <a href="show-favourite-cars.jsp">See favourite cars</a><br><br>
        <jsp:include page="footer.jsp"/>

  </body>
</html>