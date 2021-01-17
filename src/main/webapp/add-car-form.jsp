<!DOCTYPE html>
<html>
    <head>
        <title>Car Dealer</title>
    </head>
<body>
    <jsp:include page="header.jsp"/>    
    <h1>Add car</h1>

    <form action="add-car" method="POST">
    <table>
        <tr>
            <td>Make</td>
            <td>
            <input type="text" name="make"/>
            </td>
        </tr>
        <tr>
            <td>Model</td>
            <td>
                <input type="text" name="model"/>
            </td>
        </tr>
        <tr>
            <td>Year</td>
            <td>
                <input type="text" name="year"/>
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td>
                <input type="text" name="price"/>
            </td>
        </tr>
        <tr>
            <td>Fuel Type</td>
            <td>
                <input type="text" name="fuelType"/>
            </td>
        </tr>
        <tr>
            <td>Body Type</td>
            <td>
                <input type="text" name="bodyType"/>
            </td>
        </tr>
        <tr>
            <td>Milage</td>
            <td>
                <input type="text" name="mileage"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add car"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
