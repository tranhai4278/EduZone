/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

import DTO.StudentListDTO;
import dal.Class_TraineeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class classAddStudentServlet extends HttpServlet {

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
            out.println("<title>Servlet classAddStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classAddStudentServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        int classID = Integer.parseInt(request.getParameter("Classcode"));
        String getTrainee = request.getParameter("selectedStudent");

        Class_TraineeDAO classTraineeDAO = new Class_TraineeDAO(); // Replace with your actual DAO class

        if (getTrainee == null || getTrainee.isEmpty()) {
            ArrayList<StudentListDTO> studentList = classTraineeDAO.getClassTraineeDTO(classID);
            ArrayList<StudentListDTO> studentlist2 = classTraineeDAO.getTraineeDTO();
            request.setAttribute("studentList2", studentlist2);
            request.setAttribute("Classcode", classID);
            request.setAttribute("studentList", studentList);

            request.getRequestDispatcher("classdetail-studentlist.jsp").forward(request, response);
        } else {
            int traineeID = Integer.parseInt(getTrainee);
            classTraineeDAO.addTrainees(classID, traineeID);

            ArrayList<StudentListDTO> studentList = classTraineeDAO.getClassTraineeDTO(classID);
            ArrayList<StudentListDTO> studentlist2 = classTraineeDAO.getTraineeDTO();
            request.setAttribute("studentList2", studentlist2);
            request.setAttribute("Classcode", classID);
            request.setAttribute("studentList", studentList);

            request.getRequestDispatcher("classdetail-studentlist.jsp").forward(request, response);
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
