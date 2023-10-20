package Manager.controller;

import dal.QuestionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;
import model.User;

public class AddQuestionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("QuestionDetail");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            int settingId = Integer.parseInt(request.getParameter("dimension"));
            String questionString = request.getParameter("questionString");
            String[] answers = request.getParameterValues("answer");
            String[] trueAnswer = request.getParameterValues("true-answer");
            int NOtrueAnswer = trueAnswer.length;
            QuestionDAO questionDao = new QuestionDAO();
            questionDao.addQuestion(user.getUserId(), questionString, settingId, settingId, subjectId, user.getUserId(), user.getUserId());
            int questionId = questionDao.getQuestionIdByQuestion(questionString);
            questionDao.addQuestionDimension(questionId, settingId);
            for (String answer : answers) {
                if (NOtrueAnswer > 0) {
                    Logger.getLogger(answer);
                    questionDao.addAnswer(answer, questionId, 1);
                    NOtrueAnswer--;
                } else {
                    questionDao.addAnswer(answer, questionId, 0);
                }
            }
            response.sendRedirect("QuestionList");
        } catch (Exception e) {
            String message = "Must fill out all information.";
            response.sendRedirect("QuestionDetail?message=" + message);
        }

    }
}
