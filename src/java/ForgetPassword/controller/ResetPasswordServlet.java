package ForgetPassword.controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.PasswordEncoder;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the email, new password, and confirm password from the request
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Create an instance of the UserDAO class
        UserDAO userDAO = new UserDAO();

        // Create an instance of the PasswordEncoder class
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        // Initialize a message to display
        String message = "";

        // Check if the email and passwords are not null or empty
        if (email != null && !email.isEmpty() && newPassword != null && !newPassword.isEmpty() && confirmPassword != null && !confirmPassword.isEmpty()) {
            // Check if the new password matches the confirm password
            if (newPassword.equals(confirmPassword)) {
                // Hash the new password before storing it
                String hashedPassword = passwordEncoder.toSHA1(newPassword);

                // Attempt to reset the password
                boolean resetSuccess = userDAO.resetPassword(email, hashedPassword);

                if (resetSuccess) {
                    // Password reset successful
                    // Redirect to the login page with a success message
                    response.sendRedirect("login.jsp");
                    return;
                } else {
                    // Password reset failed (email not found)
                    message = "Password reset failed. Email not found.";
                }
            } else {
                // Password and confirm password do not match
                message = "Password and confirm password do not match.";
            }
        } else {
            // Invalid email or password provided
            message = "Invalid email or password provided.";
        }

        // Set the message as an attribute to be displayed in the resetpasswordfinal.jsp
        request.setAttribute("message", message);

        // Forward to the resetpasswordfinal.jsp page
        request.getRequestDispatcher("resetpasswordfinal.jsp?email=" + email).forward(request, response);
    }
}
