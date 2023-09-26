package controller;

import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Subject;

public class SubjectDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectDAO subjectDao = new SubjectDAO();
        ArrayList<Subject> list = new ArrayList<>();

        int subjectId = Integer.parseInt(request.getParameter("subject_id"));

        Subject subject = subjectDao.getSubjectAndManagerWithId(subjectId);
        list.add(subject);

        request.setAttribute("list", list);
        request.getRequestDispatcher("subject-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
