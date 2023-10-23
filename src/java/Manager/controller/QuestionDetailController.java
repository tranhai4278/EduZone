package Manager.controller;

import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Subject;
import model.SubjectSetting;

public class QuestionDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");
        
        SubjectDAO subjectDao = new SubjectDAO();
        
        ArrayList<Subject> subjectList = subjectDao.getAllSubjects();
        ArrayList<SubjectSetting> subjectSettingList = subjectDao.getAllSubjectSetting();
        
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("subjectSettingList", subjectSettingList);
        request.setAttribute("message", message);
        request.getRequestDispatcher("questionDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
