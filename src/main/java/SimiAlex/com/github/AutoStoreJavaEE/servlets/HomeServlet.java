package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        String siteUser = (String) req.getSession().getAttribute( "siteUser");

        try(PrintWriter out = resp.getWriter())
        {
            out.print("<html><body>");
            out.print("<h1>Home Page (" + siteUser + ")</h1>");
            out.print("<a href=\"catalogue\">View list of cars</a><br>");
            out.print("<a href=\"add-car-form.html\">Add car</a>");
            out.print("</body></html>");
        }
    }
}
