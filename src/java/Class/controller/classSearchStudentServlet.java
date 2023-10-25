/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String classID = request.getParameter("code");
        String searchString = request.getParameter("search");
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getAllUser();
        Class_TraineeDAO classTDAO = new Class_TraineeDAO();

        // Get students in the designated class
        ArrayList<Class_Trainee> classStudents = classTDAO.getTraineesByClassID(Integer.parseInt(classID));

        // Initialize the data list with class students
        ArrayList<Class_Trainee> data = new ArrayList<>(classStudents);

        // Get students based on the search
        ArrayList<User> studentlist = userDAO.getUsersBySearchString(searchString);

        // Add searched students to the data list for the designated class
        for (User student : studentlist) {
            // Check if the student is already in the class
            if (!studentInClass(student.getUserId(), classStudents)) {
                data.add(new Class_Trainee(Integer.parseInt(classID), student.getUserId()));
            }
        }
        
        request.setAttribute("Classcode", classID);
        request.setAttribute("trainee", data);
        request.setAttribute("users", users);

        request.getRequestDispatcher("classdetail-studentlist.jsp").forward(request, response);
    }

    private boolean studentInClass(int userId, ArrayList<Class_Trainee> trainee) {
        for (Class_Trainee classTrainee : trainee) {
            if (classTrainee.getTraineeID() == userId) {
                return true; // The student is already in the class.
            }
        }
        return false; // The student is not in the class.
    }

}
