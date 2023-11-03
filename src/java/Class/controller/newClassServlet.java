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
import model.Setting;
import model.Subject;
import model.User;
import model.Class;

/**
 *
 * @author Admin
 */
public class newClassServlet extends HttpServlet {



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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          User user = (User) request.getSession().getAttribute("user");
        String classCode = request.getParameter("class_code");
        ClassDAO classDAO = new ClassDAO();
        if (classCode == null || classCode.trim().isEmpty()) {
            SubjectDAO subjectDAO = new SubjectDAO();
            UserDAO userDAO = new UserDAO();
            AdminDAO adminDAO = new AdminDAO();

            classListLoader(request, response);
            request.setAttribute("classAddFailed", "Class name cannot be empty.");
            request.getRequestDispatcher("classlist.jsp").forward(request, response);
            return; // Exit the method
        }

        // Check if a class with the same class code already exists
        Class existingClass = classDAO.getClassByCode(classCode);

        if (existingClass != null) {
            SubjectDAO subjectDAO = new SubjectDAO();
            UserDAO userDAO = new UserDAO();
            AdminDAO adminDAO = new AdminDAO();


            classListLoader(request, response);
            request.setAttribute("classAddFailed", "A class with the same class code already exists.");
            request.getRequestDispatcher("classlist.jsp").forward(request, response);
        } else {
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            int semesterId = Integer.parseInt(request.getParameter("semester"));
            int trainerId = Integer.parseInt(request.getParameter("trainer"));
            boolean status = true;

            String statusParam = request.getParameter("status");
            if (statusParam != null) {
                status = Boolean.parseBoolean(statusParam);
            }

            int createBy = user.getUserId();
            Class newClass = new Class(classCode, subjectId, semesterId, trainerId, status, createBy);
            boolean classAdded = classDAO.addClass(newClass);

            if (classAdded) {
                SubjectDAO subjectDAO = new SubjectDAO();
                UserDAO userDAO = new UserDAO();
                AdminDAO adminDAO = new AdminDAO();

                classListLoader(request, response);
                request.setAttribute("classAddSuccess", "Class added successfully.");
                request.getRequestDispatcher("classlist.jsp").forward(request, response);
            } else {
                SubjectDAO subjectDAO = new SubjectDAO();
                UserDAO userDAO = new UserDAO();
                AdminDAO adminDAO = new AdminDAO();

                classListLoader(request, response);
                request.setAttribute("classAddFailed", "Failed to add the class. Duplicate inputs were found in the class you're trying to create.");
                request.getRequestDispatcher("classlist.jsp").forward(request, response);
            }
        }
    }

    public void classListLoader(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        ClassDAO classDAO = new ClassDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        UserDAO userDAO = new UserDAO();
        AdminDAO adminDAO = new AdminDAO();

        ArrayList<Class> c = classDAO.getAllClass();
        ArrayList<Subject> s = subjectDAO.getSubjectsByManagerId(user.getUserId());
        ArrayList<User> u = userDAO.getAllUser();
        ArrayList<User> t = userDAO.getUsersWithRoleId3();
        ArrayList<Setting> setting = adminDAO.getSemesters();
        System.out.println("Number of classes retrieved: " + c.size());

        request.setAttribute("trainers", t);
        request.setAttribute("users", u);
        request.setAttribute("semesters", setting);
        request.setAttribute("subjects", s);
        request.setAttribute("classes", c);
    }
}
