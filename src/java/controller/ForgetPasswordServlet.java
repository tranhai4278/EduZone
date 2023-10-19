package controller;

import utils.Mailtrap;
import utils.EmailChecker;
import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ForgetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the user's email from the form
        String userEmail = request.getParameter("dzName");

        EmailChecker emailChecker = new EmailChecker();
        if (!emailChecker.isValidEmail(userEmail)) {
            // Handle the case where the email is not in the correct format
            System.out.println("Email is not in the correct format");
            request.setAttribute("error", "Email is not in the correct format");
            request.getRequestDispatcher("/forgetpassword.jsp").forward(request, response);
            return; // Stop processing
        }

        UserDAO userDAO = new UserDAO();

        // Check if the email exists in the database
        if (userDAO.doesEmailExist(userEmail)) {

            HttpSession session = request.getSession();
            session.setAttribute("userEmail", userEmail);

            // Send the password reset email using Mailtrap
            Mailtrap.sendPasswordResetEmail(userEmail);

            // Forward to a confirmation page
            request.getRequestDispatcher("/resetpasswordconfirm.jsp").forward(request, response);
        } else {
            // Email doesn't exist, show an error message
            request.setAttribute("error", "Email does not exist");
            request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
        }
    }
}
