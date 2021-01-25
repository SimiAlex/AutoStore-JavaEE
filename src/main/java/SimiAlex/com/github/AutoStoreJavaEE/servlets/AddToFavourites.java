package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.entities.FavouriteCar;
import SimiAlex.com.github.AutoStoreJavaEE.repository.ItemRepository;
import SimiAlex.com.github.AutoStoreJavaEE.utilities.DIRepositories;

@WebServlet(name = "AddToFavourites", urlPatterns = "/addToFavourites")
public class AddToFavourites extends HttpServlet 
{
    // methods
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover Car object using CarId
        int carId = Integer.parseInt(req.getParameter("carId"));
        ServletContext application = getServletContext();
        ItemRepository<Car, Integer> carRepo = DIRepositories.getCarRepository(application);
        Car aCar = carRepo.findById(carId);

        // add car to favourites
        HttpSession session = req.getSession();

        FavouriteCar fc = (FavouriteCar) session.getAttribute("favouriteCar");

        // handle null case
        if(fc == null)
        {
            fc = new FavouriteCar();
            session.setAttribute("favouriteCar", fc);
        }
        
        // add car to favourites
        fc.getFavoriteCars().add(aCar);

        // TODO replace this with a jsp
        // confirmation page
        try(PrintWriter out = resp.getWriter())
        {
            out.print("<html><body>");
            out.print("Your car was added.<br>");
            for (Car car : fc.getFavoriteCars()) 
            {
                out.print(String.format("<li>%s</li>", car.toString()));
            }
            out.print("</ul>");
            out.print("<a href=\"home.jsp\">Back to home page</a><br>");
            out.print("</body></html>");
        }
    }
}
