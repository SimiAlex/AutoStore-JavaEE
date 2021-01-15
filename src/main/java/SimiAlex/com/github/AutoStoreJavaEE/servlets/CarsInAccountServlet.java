package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl;

@WebServlet(name =  "CarsInAccountServlet", urlPatterns = {"/getCarList"})
public class CarsInAccountServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover CarRepositoryImpl instance from application
        ServletContext application = getServletContext();

        CarRepository cr = (CarRepository) application.getAttribute("carRepoImpl");
        if(cr == null)
        {
            application.setAttribute("carRepoImpl" , new CarRepositoryImpl());
            cr = (CarRepository) application.getAttribute("carRepoImpl");
        }

        // put car set in Session object      
        Set<Car> cars = cr.findAll();
        req.getSession().setAttribute("carList", cars);
        
        // redirect to cars-in-account.jsp
        resp.sendRedirect("cars-in-account.jsp");
    }
}
