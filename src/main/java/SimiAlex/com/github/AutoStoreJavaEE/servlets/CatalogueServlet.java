package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl;

public class CatalogueServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html;charset=UTF-8");

        //recover Set of cars
        CarRepository carRepository = new CarRepositoryImpl();
        Set<Car> cars = carRepository.findAll();

        // show car list
        try(PrintWriter out  = resp.getWriter())
        {
            out.print("<html><body><h1>ALX Cars</h1><ul>");
            for (Car car : cars) 
            {
                out.print(String.format("<li><a href=\"car-details?id=%d\">%s</a></li>", car.getId(),car.toString()));
            }
            out.print("</ul></body></html>");

        }
        
    }

}
