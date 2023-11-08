/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

import DTO.StudentListDTO;
import dal.Class_TraineeDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Class_Trainee;
import model.User;

/**
 *
 * @author Admin
 */
public class classSearchStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int classID = Integer.parseInt(request.getParameter("code"));
        String searchTerm = request.getParameter("search");
        Class_TraineeDAO classDAO = new Class_TraineeDAO(); // Replace with your actual DAO class

        // Call the DAO method to search for students by name
        ArrayList<StudentListDTO> studentList = classDAO.searchStudentsByName(classID, searchTerm);
        ArrayList<StudentListDTO> studentList3 = classDAO.getClassTraineeDTO(classID);

        ArrayList<StudentListDTO> studentlist2 = classDAO.getTraineeDTO();
        request.setAttribute("studentList2", studentlist2);
        request.setAttribute("studentList3", studentList3);
        request.setAttribute("Classcode", classID);
        request.setAttribute("studentList", studentList);

        request.getRequestDispatcher("classdetail-studentlist.jsp").forward(request, response);

    }
}
