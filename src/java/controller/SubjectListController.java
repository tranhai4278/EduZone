package controller;

import dal.SubjectDAO;
import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Subject;
import model.User;

public class SubjectListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectDAO subjectDao = new SubjectDAO();
        UserDAO userDAO = new UserDAO();

        String subjectString = request.getParameter("search");

        ArrayList<Subject> subjectList = new ArrayList<>();

        if (subjectString.isEmpty()) {
            subjectList = subjectDao.getAllSubjects();
        } else {
            subjectList = subjectDao.getSubjectListByNameAndCode(subjectString);
        }

        ArrayList<User> ManagerFromSubjectList = new ArrayList<>();
        for (Subject ManagerId : subjectList) {
            User Manager = userDAO.getUserById(ManagerId.getManagerId());
            ManagerFromSubjectList.add(Manager);
        }

        request.setAttribute("subjectList", subjectList);
        request.setAttribute("userList", ManagerFromSubjectList);
        request.getRequestDispatcher("subjects.jsp").forward(request, response);
    }
}
