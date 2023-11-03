/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

import dal.AdminDAO;
import dal.ClassDAO;
import dal.SubjectDAO;
import dal.UserDAO;
import model.Class;
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

/**
 *
 * @author Admin
 */
public class updateClassSevlet extends HttpServlet {

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
            classListLoader(request, response);
            request.setAttribute("classAddSuccess", "Class updated successfully");
            request.getRequestDispatcher("classlist.jsp").forward(request, response);
        } else {
            classDetailLoader(request, response);
            request.setAttribute("classAddFailed", "Failed to edit the class. The class's data you inputted was found to be similar to another class");
            request.getRequestDispatcher("classdetail.jsp").forward(request, response);
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
    
    public void classDetailLoader(HttpServletRequest request, HttpServletResponse response) {
            User user = (User) request.getSession().getAttribute("user");
            String classCode = request.getParameter("classCode");
            System.out.println(classCode);
            UserDAO userDAO = new UserDAO();
            SubjectDAO subjectDAO = new SubjectDAO();
            AdminDAO adminDAO = new AdminDAO();
            ClassDAO classDAO = new ClassDAO();

            Class c = classDAO.getClassByCode(classCode);
            ArrayList<Subject> s = subjectDAO.getSubjectsByManagerId(user.getUserId());
            ArrayList<User> u = userDAO.getUsersWithRoleId3();
            ArrayList<Setting> setting = adminDAO.getSemesters();

            request.setAttribute("classObj", c);
            request.setAttribute("subjects", s);
            request.setAttribute("users", u);
            request.setAttribute("semesters", setting);
    }
}
