package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl;

@WebServlet(name = "CarDetailsServlet", urlPatterns = "/car-details")
public class CarDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int carId = Integer.parseInt(req.getParameter("id"));


        //recover car object using id
        CarRepository cr = new CarRepositoryImpl();
        Car car = cr.findById(carId);        

        // show car details
        try(PrintWriter out  = resp.getWriter())
        {
            out.print("<html><body><h1>" +car.getMake() + " " + car.getModel()  + " details</h1><ul>");
            out.print(String.format("<li>Year: %d</li>", car.getYear()));
            out.print(String.format("<li>Price: %d</li>", car.getPrice()));
            out.print(String.format("<li>Fuel Type: %s</li>", car.getFuelType()));
            out.print(String.format("<li>Body Type: %s</li>", car.getBodyType()));
            out.print(String.format("<li>Mileage: %d</li></ul>", car.getMileage()));
            out.print(String.format("<form action=\"addToFavourites\" method=\"POST\"><input type=\"hidden\" name=\"carId\" value=\"%d\"><input type=\"submit\" value=\"Add to favorites\"></form>",car.getId()));
            out.print("</body></html>");

        }
    }
    
}
