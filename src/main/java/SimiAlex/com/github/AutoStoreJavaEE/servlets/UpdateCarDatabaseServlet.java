package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;

@WebServlet(name = "UpdateCarDatabaseServlet", urlPatterns = {"/update-car-database"})
public class UpdateCarDatabaseServlet extends HttpServlet{
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        ServletContext application = getServletContext();

        CarRepository cr = (CarRepository)application.getAttribute("carRepoImpl");

        Car myCar = cr.findById(id); 

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

        cr.updateCar(myCar);

          // redirect to cars-in-account.jsp
          resp.sendRedirect("getCarList");

    }
}
