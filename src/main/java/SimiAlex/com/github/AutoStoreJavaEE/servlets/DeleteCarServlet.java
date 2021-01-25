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

@WebServlet(name = "DeleteCarServlet", urlPatterns = {"/delete-car"})
public class DeleteCarServlet extends HttpServlet 
{
    // methods
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover carId for the car to be deleted
        int carId = Integer.parseInt(req.getParameter("carId"));

        // recover an ItemRepository<Car> instance from the application scope
        ServletContext application = getServletContext();
        ItemRepository<Car, Integer> carRepo = DIRepositories.getCarRepository(application);

        // delete the car using the carId
        carRepo.deleteItem(carId);

        // redirect to cars-in-account page
        resp.sendRedirect("getCarList");
    }
}
