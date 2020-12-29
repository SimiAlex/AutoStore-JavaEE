package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.Catalogue;
import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;

@WebServlet(name = "AddCarServlet", urlPatterns = { "/add-car" })
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String model = req.getParameter("model");
        String make = req.getParameter("make");
        int year = Integer.parseInt(req.getParameter("year"));
        int price = Integer.parseInt(req.getParameter("price"));
        String fuelType = req.getParameter("fuelType");
        String bodyType = req.getParameter("bodyType");
        int mileage = Integer.parseInt(req.getParameter("mileage"));

        Car myCar = new Car();
        myCar.setModel(model);
        myCar.setMake(make);
        myCar.setYear(year);
        myCar.setPrice(price);
        myCar.setFuelType(fuelType);
        myCar.setBodyType(bodyType);
        myCar.setMileage(mileage);

        Catalogue.cars.add(myCar);
        try(PrintWriter out = resp.getWriter())
        {
            out.print("<html><body>");

            out.print("Your car was added.<br>");
            out.print("<a href=\"home\">Back to home page</a><br>");
            out.print("</body></html>");
        }
    }
    
}
