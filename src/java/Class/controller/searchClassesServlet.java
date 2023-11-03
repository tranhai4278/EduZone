/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Class.controller;

import dal.*;
import model.Class;
import model.User;
import model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Setting;

/**
 *
 * @author Admin
 */
public class searchClassesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String searchKeyword = request.getParameter("search");

        ClassDAO classDAO = new ClassDAO();
        UserDAO userDAO = new UserDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        AdminDAO adminDAO = new AdminDAO();

        ArrayList<Setting> setting = adminDAO.getSemesters();
        ArrayList<Class> searchResults = classDAO.searchClasses(searchKeyword);
        ArrayList<Subject> s = subjectDAO.getSubjectsByManagerId(user.getUserId());
        ArrayList<User> u = userDAO.getAllUser();

        request.setAttribute("users", u);
        request.setAttribute("subjects", s);
        request.setAttribute("classes", searchResults);
        request.setAttribute("semesters", setting);

        request.getRequestDispatcher("classlist.jsp").forward(request, response);

    }
}
