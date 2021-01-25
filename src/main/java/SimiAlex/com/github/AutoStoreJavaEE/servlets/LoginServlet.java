package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Seller;
import SimiAlex.com.github.AutoStoreJavaEE.utilities.DIUtilities;

@WebServlet(name = "LoginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet 
{
    // fields
    private static final String SELLER_ATTRIBUTE = "seller";

    // methods
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover request params
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // validate user and take approriate action
        Seller seller = validateUser(username, password);
        if(Objects.nonNull(seller))
        {
            // save Seller object in session attributes
            HttpSession session = req.getSession();
            session.setAttribute(SELLER_ATTRIBUTE, seller);

            // redirect to homepage
            // TODO security in WEB-INF, needs changing
            resp.sendRedirect("home.jsp");
        }
        else
        {
            // if incorrect login credentials
            // TODO setup this page
            resp.sendRedirect("index.html");
        }
    }

    private Seller validateUser(String username, String password)
    {
        // query the database for the username & password
        EntityManager em = DIUtilities.getEntityManager(getServletContext());
        TypedQuery<Seller> query = em.createQuery("SELECT s FROM Seller s WHERE name = :username AND password = :password", Seller.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Seller seller = query.getSingleResult();
        
        return seller;        
    }
}
