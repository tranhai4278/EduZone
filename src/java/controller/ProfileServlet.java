package controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        User user = (User) request.getSession().getAttribute("user");
        //test case with an existing user in the database 
        if (user != null) {
            // User is logged in, you can access their information
            // Set the user object as an attribute in the request
            request.setAttribute("user", user);

            // Forward the request to the JSP file for rendering
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // Replace with your login page URL
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
