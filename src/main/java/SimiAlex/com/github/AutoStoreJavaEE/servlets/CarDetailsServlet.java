package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.Catalogue;
import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;

@WebServlet(name = "CarDetailsServlet", urlPatterns = "/car-details")
public class CarDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        Car car = null;
        int carId = Integer.parseInt(req.getParameter("id"));
        //recover car object using id
        for (Car myCar : Catalogue.cars) 
        {
            if(carId == myCar.getId())
            {
                car = myCar;
                break;
            }
        }

        // show car details
        try(PrintWriter out  = resp.getWriter())
        {
            out.print("<html><body><h1>" +car.getMake() + " " + car.getModel()  + " details</h1><ul>");
            out.print(String.format("<li>Year: %d</li>", car.getYear()));
            out.print(String.format("<li>Price: %d</li>", car.getPrice()));
            out.print(String.format("<li>Fuel Type: %s</li>", car.getFuelType()));
            out.print(String.format("<li>Body Type: %s</li>", car.getBodyType()));
            out.print(String.format("<li>Mileage: %d</li>", car.getMileage()));
            out.print("</ul></body></html>");

        }
    }
    
}
