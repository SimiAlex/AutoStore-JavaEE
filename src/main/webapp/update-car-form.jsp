<!DOCTYPE html>
<html>
    <head>
        <title>Car Dealer</title>
    </head>
<body>
    <jsp:include page="header.jsp"/>    
    <h1>Update car</h1>


    <form action="update-car-database" method="POST">
        
        <input type="hidden" name="id" value="${myCar.id}">

        <table>
            <tr>
                <td>Make</td>
                <td>
                <input type="text" name="make" value="${myCar.make}"/>
                </td>
            </tr>
            <tr>
                <td>Model</td>
                <td>
                    <input type="text" name="model" value="${myCar.model}"/>
                </td>
            </tr>
            <tr>
                <td>Year</td>
                <td>
                    <input type="text" name="year" value="${myCar.year}"/>
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <input type="text" name="price" value="${myCar.price}"/>
                </td>
            </tr>
            <tr>
                <td>Fuel Type</td>
                <td>
                    <input type="text" name="fuelType" value="${myCar.fuelType}"/>
                </td>
            </tr>
            <tr>
                <td>Body Type</td>
                <td>
                    <input type="text" name="bodyType" value="${myCar.bodyType}"/>
                </td>
            </tr>
            <tr>
                <td>Milage</td>
                <td>
                    <input type="text" name="mileage" value="${myCar.mileage}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update car"/>
                </td>
            </tr>
    </table>
    </form>
</body>
</html>
