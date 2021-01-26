package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.repository.ItemRepository;
import SimiAlex.com.github.AutoStoreJavaEE.utilities.DIRepositories;

@WebServlet(name =  "CarsInAccountServlet", urlPatterns = {"/getCarList"})
public class CarsInAccountServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover the ItemRepository<Car> instance from the application scope
        ServletContext application = getServletContext();
        ItemRepository<Car, Integer> carRepo = DIRepositories.getCarRepository(application);

        // put car set in Session object      
        Set<Car> cars = carRepo.findAll();
        req.getSession().setAttribute("carList", cars);
        
        // redirect to cars-in-account.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/cars-in-account.jsp");
        dispatcher.forward(req, resp);
    }
}
