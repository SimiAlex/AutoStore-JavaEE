package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.entities.FavouriteCar;

@WebServlet(name = "ShowFavouriteCarsServlet", urlPatterns = { "/see-favourite-cars" })
public class ShowFavouriteCarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try(PrintWriter out  = resp.getWriter())
        {
            FavouriteCar fc = (FavouriteCar) req.getSession().getAttribute("favouriteCar");

            if(fc == null)
            {
                fc = new FavouriteCar();
                req.getSession().setAttribute("favouriteCar", fc);
            }
            
            out.print("<html><body><h1>Favourite Cars</h1><ul>");
            for (Car car : fc.getFavoriteCars()) 
            {
                out.print(String.format("<li>%s</li>",car.toString()));
            }
            out.print("</ul><a href=\"home\">Back to home page</a><br></body></html>");

        }
    }

    
}
