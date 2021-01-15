<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title>AutoDealer</title>
    
	
  </head>
  
  <body>
        
    <h1>Home Page (${sessionScope.siteUser})</h1>
        <a href="cars-in-account.jsp">View list of cars</a><br>
        <a href="add-car.jsp">Add car</a><br>
        <a href="show-favourite-cars.jsp">See favourite cars</a><br>
        <a href="logout">Logout</a>

        <jsp:include page="footer.jsp"/>

  </body>
</html>