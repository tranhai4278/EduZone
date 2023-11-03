/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

import dal.AdminDAO;
import dal.ClassDAO;
import dal.SubjectDAO;
import dal.UserDAO;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.User;
import model.Class;
import model.Setting;
import model.Subject;

/**
 *
 * @author Admin
 */
public class classListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        request.getRequestDispatcher("classlist.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("activate".equals(action) || "deactivate".equals(action)) {
            String[] selectedClassIds = request.getParameterValues("selectedClasses");
            if (selectedClassIds != null) {
                List<Integer> classIds = new ArrayList<>();
                for (String classId : selectedClassIds) {
                    classIds.add(Integer.parseInt(classId));
                }
                if ("activate".equals(action)) {
                    activateClasses(classIds);
                } else if ("deactivate".equals(action)) {
                    deactivateClasses(classIds);
                }
            }

            // Redirect back to the class list page or perform any other necessary actions.
        } else if ("other_action".equals(action)) {
            // Handle other actions here
        }

        response.sendRedirect(request.getContextPath() + "/classlist");
    }

    private void activateClasses(List<Integer> classIds) {
        ClassDAO classDAO = new ClassDAO();
        for (Integer classId : classIds) {
            classDAO.activateClassByID(classId);
        }
    }

    private void deactivateClasses(List<Integer> classIds) {
        ClassDAO classDAO = new ClassDAO();
        for (Integer classId : classIds) {
            classDAO.deactivateClassByID(classId);
        }
    }
}
