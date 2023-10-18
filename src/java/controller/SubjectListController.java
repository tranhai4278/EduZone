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
        SubjectDAO subjectDao = new SubjectDAO();

        ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList = subjectDao.getAllSubjectsWithUser();

        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("subjects.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectDAO subjectDao = new SubjectDAO();

        String subjectString = request.getParameter("search");

        ArrayList<Subject> subjectList = new ArrayList<>();

        if (subjectString.isEmpty()) {
            subjectList = subjectDao.getAllSubjectsWithUser();
        } else {
            subjectList = subjectDao.getSubjectListByNameAndCodeWithUser(subjectString);
        }

        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("subjects.jsp").forward(request, response);
    }
}
