/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.PasswordEncoder;

/**
 *
 * @author admin
 */
public class ResetPasswordServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPasswordServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
