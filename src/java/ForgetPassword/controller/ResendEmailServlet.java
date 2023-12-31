package ForgetPassword.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.Mailtrap;

public class ResendEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resendParam = request.getParameter("resend");

        if (resendParam != null && resendParam.equals("true")) {
            // Get the user's email address from a session attribute
            HttpSession session = request.getSession();
            String userEmail = (String) session.getAttribute("userEmail");

            if (userEmail != null && !userEmail.isEmpty()) {
                try {
                    // Attempt to resend the email using Mailtrap
                    boolean emailSent = Mailtrap.sendPasswordResetEmail(userEmail);

                    if (emailSent) {
                        // Email sent successfully, redirect to a confirmation page
                        response.sendRedirect("resetpasswordconfirm.jsp");
                        return; // Exit the servlet to prevent further processing
                    }
                } catch (Exception e) {
                    // Log the exception for debugging
                    e.printStackTrace();
                }
            }

            // Email sending failed or invalid email, redirect to an error page with a message
            response.sendRedirect("error.jsp?message=Failed+to+resend+the+email.+Please+try+again.");
        } else {
            // Handle the case where the resend parameter is not set
            response.sendRedirect("error.jsp?message=Invalid+request.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
