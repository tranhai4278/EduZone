/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import utils.PasswordEncoder;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import utils.MyUtil;

/**
 *
 * @author admin
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/changepassword"})
public class ChangePasswordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        
        // Check if new password and confirm password match and have at least 8 characters
        if (!newPassword.equals(confirmPassword) || newPassword.length() < 8) {
            UserDAO userDao = new UserDAO();
            request.setAttribute("error", "New Password doesn't match with Confirmed Password");
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


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
