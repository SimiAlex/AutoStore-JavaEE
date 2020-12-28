package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.Catalogue;
import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;

public class CatalogueServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html;charset=UTF-8");

        // populate cars
        if(Catalogue.cars.isEmpty())
        {
            loadCars();
        }
        // show car list
        try(PrintWriter out  = resp.getWriter())
        {
            out.print("<html><body><h1>ALX Cars</h1><ul>");
            for (Car car : Catalogue.cars) 
            {
                // out.print("<li><a href=\"car-details?id=" + car.getId()+"\">" + car.toString() +"</a></li>");
                out.print(String.format("<li><a href=\"car-details?id=%d\">%s</a></li>", car.getId(),car.toString()));
            }
            out.print("</ul></body></html>");

        }
        
    }

    private void loadCars()
    {
        Car skoda = new Car();
        skoda.setMake("Skoda");
        skoda.setModel("Fabia");
        skoda.setYear(2006);
        skoda.setBodyType("hatchback");
        skoda.setFuelType("petrol");
        skoda.setMilage(150000);
        skoda.setPrice(2500);
        Catalogue.cars.add(skoda);

        Car seat = new Car();
        seat.setMake("Seat");
        seat.setModel("Leon");
        seat.setYear(2003);
        seat.setBodyType("hatchback");
        seat.setFuelType("diesel");
        seat.setMilage(240000);
        seat.setPrice(1600);
        Catalogue.cars.add(seat);

        Car mini = new Car();
        mini.setMake("Mini");
        mini.setModel("One");
        mini.setYear(2010);
        mini.setBodyType("coupe");
        mini.setFuelType("petrol");
        mini.setMilage(400000);
        mini.setPrice(3000);
        Catalogue.cars.add(mini);
    }

}
