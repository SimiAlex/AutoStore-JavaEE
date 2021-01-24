package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.ItemRepository;
import SimiAlex.com.github.AutoStoreJavaEE.utilities.DIRepositories;

@WebServlet(name = "UpdateCarDatabaseServlet", urlPatterns = {"/update-car-database"})
public class UpdateCarDatabaseServlet extends HttpServlet
{
    // methods    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover car id from request params    
        int id = Integer.parseInt(req.getParameter("id"));

        // recover ItemRepository<Car> from application
        ServletContext application = getServletContext();
        ItemRepository<Car> carRepo = DIRepositories.getCarRepository(application);
        
        // update a Car object retrieved from database using form fields
        Car myCar = carRepo.findById(id); 

        String model = req.getParameter("model");
        String make = req.getParameter("make");
        int year = Integer.parseInt(req.getParameter("year"));
        int price = Integer.parseInt(req.getParameter("price"));
        String fuelType = req.getParameter("fuelType");
        String bodyType = req.getParameter("bodyType");
        int mileage = Integer.parseInt(req.getParameter("mileage"));

        myCar.setModel(model);
        myCar.setMake(make);
        myCar.setYear(year);
        myCar.setPrice(price);
        myCar.setFuelType(fuelType);
        myCar.setBodyType(bodyType);
        myCar.setMileage(mileage);

        // update Car object in database
        carRepo.updateItem(myCar);

        // redirect to cars-in-account.jsp
        resp.sendRedirect("getCarList");
    }
}
