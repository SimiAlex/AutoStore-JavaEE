package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;

@WebServlet(name = "CarDetailsServlet", urlPatterns = {"/car-details-servlet"})
public class CarDetailsServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //recover car id from request
        int carId = Integer.parseInt(req.getParameter("id"));
        ServletContext application = getServletContext();
        CarRepository cr = (CarRepository) application.getAttribute("carRepoImpl");

        //recover car from database
        Car myCar = cr.findById(carId);
        
        //save to req atribute
        req.setAttribute("myCar", myCar);

        RequestDispatcher dispatcher = req.getRequestDispatcher("car-details.jsp");
        dispatcher.forward(req, resp);
    }
}
