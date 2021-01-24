/*
 * This servlet has the role to send the user to the update form and to
 * send the car object to update to the jsp form to fill in the fields.
 * 
 * It does NOT update the database. UpdateCarDatabaseServlet does that.
*/

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
import SimiAlex.com.github.AutoStoreJavaEE.repository.ItemRepository;
import SimiAlex.com.github.AutoStoreJavaEE.utilities.DIRepositories;

@WebServlet(name = "UpdateCarServlet", urlPatterns = "/update-car")
public class UpdateCarServlet extends HttpServlet 
{
    // methods    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {    
        // recover car id from request
        int carId = Integer.parseInt(req.getParameter("carId"));
       
        // recover an ItemRepository<Car> instance from the application scope
        ServletContext application = getServletContext();
        ItemRepository<Car> carRepo = DIRepositories.getCarRepository(application);

        // recover car from database
        Car myCar = carRepo.findById(carId);
        
        // save car to req atribute
        req.setAttribute("myCar", myCar);

        // dispatch the request to the corresponding jsp page
        RequestDispatcher dispatcher = req.getRequestDispatcher("update-car-form.jsp");
        dispatcher.forward(req, resp);
    }
}
