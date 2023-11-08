/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Assignment.controller;

import DTO.AssignmentDTO;
import dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Assignment;
import dal.AssignmentDAO;
import dal.OnlineLearningDAO;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.User;
import model.Class;

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
        int uid = Integer.parseInt(request.getParameter("userId"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
        int cid = Integer.parseInt(request.getParameter("classId"));
        int sid = Integer.parseInt(request.getParameter("sid"));

        AssignmentDAO assDAO = new AssignmentDAO();

        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        Subject s = dao.getSubjectbyId(sid);
        List<Class> listClass = Odao.getClassbyUser(uid);
        AssignmentDTO ass = assDAO.getAssignmentDetail(assignmentId, classId, uid);
        request.setAttribute("data", ass);
        request.setAttribute("cid", classId);
        request.setAttribute("sid", sid);
        request.setAttribute("detail", s);
        request.setAttribute("listClass", listClass);

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
        int uid = Integer.parseInt(request.getParameter("traineeID"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int assignmentId = Integer.parseInt(request.getParameter("assignmentTitle"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        String fileSubmit = request.getParameter("submitFile");

        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        AssignmentDAO assDAO = new AssignmentDAO();

        if (fileSubmit.isEmpty() || fileSubmit == null) {
            AssignmentDTO ass = assDAO.getAssignmentDetail(assignmentId, classId, uid);
            Subject s = dao.getSubjectbyId(sid);
            List<Class> listClass = Odao.getClassbyUser(uid);
            request.setAttribute("data", ass);
            request.setAttribute("cid", classId);
            request.setAttribute("sid", sid);
            request.setAttribute("detail", s);
            request.setAttribute("listClass", listClass);

            request.getRequestDispatcher("assignmentDetail.jsp").forward(request, response);
        } else {

            Subject s = dao.getSubjectbyId(sid);
            List<Class> listClass = Odao.getClassbyUser(uid);

            System.out.println(fileSubmit);

            // Update the database
            assDAO.submitAssignment(assignmentId, uid, classId, fileSubmit);

//        // Create JavaScript code to upload the file to Firebase
//        String javascriptCode = "document.getElementById('fileInput').files[0] = new File(['" + fileSubmit + "'], '" + fileSubmit + "');"
//                + "document.getElementById('fileUploadForm').submit();";
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><head><script>" + javascriptCode + "</script></head><body></body></html>");
            // Forward the request to the assignmentlist.jsp page
            ArrayList<AssignmentDTO> data = assDAO.getAssignmentsWithDetails(sid, classId, uid);

            request.setAttribute("data", data);
            request.setAttribute("cid", classId);
            request.setAttribute("sid", sid);
            request.setAttribute("detail", s);
            request.setAttribute("listClass", listClass);

            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        }
    }
}
