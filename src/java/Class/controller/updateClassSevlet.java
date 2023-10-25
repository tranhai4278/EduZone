/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Class.controller;

import dal.ClassDAO;
import model.Class;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Admin
 */
public class updateClassSevlet extends HttpServlet {
   
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
            out.println("<title>Servlet updateClassSevlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateClassSevlet at " + request.getContextPath () + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int classID = Integer.parseInt(request.getParameter("classID"));
        String classCode = request.getParameter("classCode");
        int semesterId = Integer.parseInt(request.getParameter("semester"));
        int lecturerId = Integer.parseInt(request.getParameter("lecturer"));
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        boolean status = request.getParameter("status").equals("1"); // Convert to boolean

        // Create a Class object with updated information
        Class updatedClass = new Class();
        updatedClass.setID(classID);
        updatedClass.setClassCode(classCode);
        updatedClass.setSemesterID(semesterId);
        updatedClass.setTrainerID(lecturerId);
        updatedClass.setSubjectID(subjectId);
        updatedClass.setStatus(status);

        // You should set the updateBy field with the user's ID
        // updatedClass.setUpdateBy(yourUserId);

        // Update the class details in the database using the DAO
        ClassDAO classDAO = new ClassDAO();
        boolean updated = classDAO.updateClass(updatedClass);

        if (updated) {
            // Class updated successfully
            response.sendRedirect("classdetail?Code=" + classCode);
        } else {
            // Handle the case where the update failed
            // You can redirect to an error page or show an error message
            response.sendRedirect("errorPage.jsp");
        }
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
