package Manager.controller;

import dal.QuestionDAO;
import dal.SubjectSettingDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteQuestionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        
        QuestionDAO qDao = new QuestionDAO();
        SubjectSettingDAO ssDao = new SubjectSettingDAO();
        
        qDao.deleteAnswerWithQuestionId(questionId);
        ssDao.deleteDimensionWithQuestionId(questionId);
        qDao.deleteQuestionById(questionId);
        
        response.sendRedirect("QuestionsList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
