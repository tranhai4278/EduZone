package controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import utils.MyUtil;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/changepassword"})
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        User user = (User) request.getSession().getAttribute("user");

        //User user = userDAO.getUserTest();
        // Set the user object as an attribute in the request
        request.setAttribute("user", user);

        // Forward the request to the JSP file for rendering
        request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyUtil passencoder = new MyUtil();
        // Get parameters from the request
        int userId = Integer.parseInt(request.getParameter("id"));
        String currentPassword = request.getParameter("current_password");
        String hashedPassword = passencoder.toSHA1(currentPassword);
        //System.out.println(hashedPassword);
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

        // Hash the new password using the toSHA1 method
        String hashedNewPassword = passencoder.toSHA1(newPassword);

        if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            UserDAO userDao = new UserDAO();
            request.setAttribute("error", "Cannot be empty");
            User user = userDao.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/changepassword.jsp").forward(request, response); // Forward to the profile page
            return;
        }

        //check if the new password length is 8 characters at least 
        if (newPassword.length() < 8) {
            UserDAO userDao = new UserDAO();
            request.setAttribute("error", "New password must be at least 8 characters");
            User user = userDao.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/changepassword.jsp").forward(request, response); // Forward to the profile page
            return;
        }

        // Check if new password and confirm password match and have at least 8 characters
        if (!newPassword.equals(confirmPassword)) {
            UserDAO userDao = new UserDAO();
            request.setAttribute("error", "Confirmed Password doesn't match with New Password");
            User user = userDao.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/changepassword.jsp").forward(request, response); // Forward to the profile page
            return;
        }

        // Check if new password meets complexity requirements
        if (!newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[!@#$%^&*()/].*")) {
            UserDAO userDao = new UserDAO();
            request.setAttribute("error", "New password must have at least one uppercase letter, one lowercase letter, and one special character");
            User user = userDao.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/changepassword.jsp").forward(request, response); // Forward to the profile page
            return;
        }

        // Initialize UserDAO and perform password change
        UserDAO userDAO = new UserDAO();
        boolean passwordChangeSuccess = userDAO.changePassword(userId, hashedPassword, hashedNewPassword);

        if (passwordChangeSuccess) {
            UserDAO userDao = new UserDAO();
            request.setAttribute("success", "Password updated successfully");
            User user = userDao.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response); // Forward to the profile page
        } else {
            UserDAO userDao = new UserDAO();
            request.setAttribute("error", "Password isn't correct");
            User user = userDao.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/changepassword.jsp").forward(request, response); // Forward to the profile page
        }
    }
}
