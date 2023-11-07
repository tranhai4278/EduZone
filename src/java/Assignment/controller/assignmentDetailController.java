/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Assignment.controller;

import DTO.AssignmentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Assignment;
import dal.AssignmentDAO;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Admin
 */
public class assignmentDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));

        AssignmentDAO assDAO = new AssignmentDAO();
        AssignmentDTO ass = assDAO.getAssignmentDetail(assignmentId, courseId, userId);
        request.setAttribute("data", ass);
        request.getRequestDispatcher("assignmentDetail.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int userId = Integer.parseInt(request.getParameter("traineeID"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int assignmentId = Integer.parseInt(request.getParameter("assignmentTitle"));
        String fileSubmit = request.getParameter("submitFile");
        System.out.println(fileSubmit);

        AssignmentDAO assDAO = new AssignmentDAO();

        // Update the database
        assDAO.submitAssignment(assignmentId, userId, classId, fileSubmit);

//        // Create JavaScript code to upload the file to Firebase
//        String javascriptCode = "document.getElementById('fileInput').files[0] = new File(['" + fileSubmit + "'], '" + fileSubmit + "');"
//                + "document.getElementById('fileUploadForm').submit();";
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><head><script>" + javascriptCode + "</script></head><body></body></html>");
        // Forward the request to the assignmentlist.jsp page
        ArrayList<AssignmentDTO> data = assDAO.getAssignmentsWithDetails();
        request.setAttribute("data", data);
        request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
    }
}
