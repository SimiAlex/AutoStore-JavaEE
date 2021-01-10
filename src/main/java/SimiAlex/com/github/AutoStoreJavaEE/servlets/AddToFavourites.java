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

@WebServlet(name = "AddToFavourites", urlPatterns = "/addToFavourites")
public class AddToFavourites extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {

        // recover Car object
        Car car = null;
        int carId = Integer.parseInt(req.getParameter("carId"));
        //recover car object using id
        // for (Car myCar : Catalogue.cars) 
        // {
        //     if(carId == myCar.getId())
        //     {
        //         car = myCar;
        //         break;
        //     }
        // }

        // add car to favourites
        HttpSession session = req.getSession();

        FavouriteCar fc = (FavouriteCar) session.getAttribute("favouriteCar");

        if(fc == null)
        {
            fc = new FavouriteCar();
            session.setAttribute("favouriteCar", fc);
        }
        
        fc.getFavoriteCars().add(car);



        //confirmation page
        try(PrintWriter out = resp.getWriter())
        {
            out.print("<html><body>");
            out.print("Your car was added.<br>");
            for (Car aCar : fc.getFavoriteCars()) 
            {
                out.print(String.format("<li>%s</li>",aCar.toString()));
            }
            out.print("</ul>");
            out.print("<a href=\"home\">Back to home page</a><br>");
            out.print("</body></html>");
        }
    }
    
}
