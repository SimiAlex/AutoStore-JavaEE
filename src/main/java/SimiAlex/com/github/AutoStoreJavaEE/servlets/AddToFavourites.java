package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.entities.FavouriteCar;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepository;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl;

@WebServlet(name = "AddToFavourites", urlPatterns = "/addToFavourites")
public class AddToFavourites extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover Car object
        int carId = Integer.parseInt(req.getParameter("carId"));
        CarRepository cr = new CarRepositoryImpl();
        Car aCar = cr.findById(carId);

        // add car to favourites
        HttpSession session = req.getSession();

        FavouriteCar fc = (FavouriteCar) session.getAttribute("favouriteCar");

        if(fc == null)
        {
            fc = new FavouriteCar();
            session.setAttribute("favouriteCar", fc);
        }
        
        fc.getFavoriteCars().add(aCar);

        //confirmation page
        try(PrintWriter out = resp.getWriter())
        {
            out.print("<html><body>");
            out.print("Your car was added.<br>");
            for (Car car : fc.getFavoriteCars()) 
            {
                out.print(String.format("<li>%s</li>", car.toString()));
            }
            out.print("</ul>");
            out.print("<a href=\"home\">Back to home page</a><br>");
            out.print("</body></html>");
        }
    }
    
}
