package SimiAlex.com.github.AutoStoreJavaEE.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        // recover request params
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        // validate login params
        if(userName.equals("Alex") && password.equals("Siminea"))
        {
            HttpSession session = req.getSession();
            session.setAttribute("siteUser", userName);

            // RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/home-page.html");
            // dispatcher.forward(req, resp);
            resp.sendRedirect("home.jsp");
        }
        else
        {
            RequestDispatcher dispatcherLogin = req.getRequestDispatcher("index.html");
            dispatcherLogin.forward(req, resp);
        }
    }
    
}
