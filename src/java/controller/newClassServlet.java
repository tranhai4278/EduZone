/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AdminDAO;
import dal.ClassDAO;
import dal.SubjectDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Setting;
import model.Subject;
import model.User;
import model.Class;

/**
 *
 * @author Admin
 */
public class newClassServlet extends HttpServlet {

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
            out.println("<title>Servlet newClassServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newClassServlet at " + request.getContextPath() + "</h1>");
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
        SubjectDAO subjectDAO = new SubjectDAO();
        AdminDAO adminDAO = new AdminDAO();

        ArrayList<Subject> s = subjectDAO.getAllSubjects();
        ArrayList<User> u = userDAO.getUsersWithRoleId3();
        ArrayList<Setting> setting = adminDAO.getSemesters();

        request.setAttribute("subjects", s);
        request.setAttribute("users", u);
        request.setAttribute("semesters", setting);

        request.getRequestDispatcher("newclass.jsp").forward(request, response);
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
        // Get parameters from the request
         User user = (User) request.getSession().getAttribute("user");
        String classCode = request.getParameter("class_code");
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        int semesterId = Integer.parseInt(request.getParameter("semester"));
        int trainerId = Integer.parseInt(request.getParameter("trainer"));
        boolean status = true; // Set the default value to true

// Check if the 'status' parameter is provided in the request
        String statusParam = request.getParameter("status");
        if (statusParam != null) {
            // If 'status' parameter is provided, parse it
            status = Boolean.parseBoolean(statusParam);
        }

// Rest of your code remains the same
//        int createBy = Integer.parseInt(request.getParameter("create_by"));
        int createBy = 1;

        // Create a new Class object
        Class newClass = new Class(classCode, subjectId, semesterId, trainerId, status, createBy);

        // Create a ClassDAO instance (replace this with your actual DAO initialization)
        ClassDAO classDAO = new ClassDAO();

        // Attempt to add the new class to the database
        boolean classAdded = classDAO.addClass(newClass);

        if (classAdded) {
            // Class added successfully
            // You may want to redirect or show a success message
            response.sendRedirect("success.jsp");
        } else {
            // Class addition failed
            // You may want to redirect or show an error message
            response.sendRedirect("error.jsp");
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
