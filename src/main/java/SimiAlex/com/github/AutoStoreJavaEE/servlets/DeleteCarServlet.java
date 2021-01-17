package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;

@WebServlet(name = "DeleteCarServlet", urlPatterns = {"/delete-car"})
public class DeleteCarServlet extends HttpServlet 
{
    // methods
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover carId for the car to be deleted
        int carId = Integer.parseInt(req.getParameter("carId"));

        // recover a CarRepository instance from the application scope
        CarRepository cr = (CarRepository) getServletContext().getAttribute("carRepoImpl");

        // delete the car using the carId
        cr.deleteCar(carId);

        // redirect to cars-in-account page
        resp.sendRedirect("cars-in-account.jsp");
    }
}
