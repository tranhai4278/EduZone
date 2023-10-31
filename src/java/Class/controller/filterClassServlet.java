/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

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
import java.util.List;
import model.Class;
import model.Setting;
import model.Subject;
import model.User;

/**
 *
 * @author Admin
 */
public class filterClassServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String selectedSubject = request.getParameter("selectedSubject");
        System.out.println(selectedSubject);
        String selectedSemester = request.getParameter("selectedSemester");
        System.out.println(selectedSemester);
        String selectedTrainer = request.getParameter("selectedTrainer");
        System.out.println(selectedTrainer);
        ClassDAO classDAO = new ClassDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
         UserDAO userDAO = new UserDAO();
          AdminDAO adminDAO = new AdminDAO();
          
        ArrayList<Setting> setting = adminDAO.getSemesters();
        ArrayList<Class> filteredClasses; 

        if (selectedSubject != null && !selectedSubject.isEmpty() || selectedSemester != null && !selectedSemester.isEmpty() || selectedTrainer != null && !selectedTrainer.isEmpty()) {
            // Filter classes based on the selected inputs
            filteredClasses = classDAO.filterClass(selectedSubject, selectedSemester, selectedTrainer);
        } else {
            // If no input is selected, return all classes
            filteredClasses = classDAO.getAllClass();
        }
        ArrayList<Subject> s = subjectDAO.getSubjectsByManagerId(user.getUserId());
        ArrayList<User> u = userDAO.getAllUser();
        ArrayList<User> t = userDAO.getUsersWithRoleId3();
        
        request.setAttribute("trainers", t);
        request.setAttribute("users", u);
        request.setAttribute("classes", filteredClasses);
        request.setAttribute("subjects", s);
        request.setAttribute("semesters", setting);
        request.getRequestDispatcher("classlist.jsp").forward(request, response);
    }
}
