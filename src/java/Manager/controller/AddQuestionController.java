package Manager.controller;

import dal.QuestionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
            int subjectId = 0;
            subjectId = Integer.parseInt(request.getParameter("subject"));
            int chapterId = Integer.parseInt(request.getParameter("chapter"));
            int lessonId = Integer.parseInt(request.getParameter("lesson"));
            
            String[] dimensionIds = request.getParameterValues("dimension");
            
            String questionString = request.getParameter("questionString");
            String[] answers = request.getParameterValues("answer");
            String[] trueAnswers = request.getParameterValues("true-answer");

            if (subjectId == 0 || dimensionIds == null || questionString == null || answers == null || answers.length == 0 || trueAnswers == null || trueAnswers.length == 0) {
                String message = "Must fill out all information.";
                response.sendRedirect("QuestionDetail?message=" + message);
            }

            QuestionDAO questionDao = new QuestionDAO();
            questionDao.addQuestion(user.getUserId(), questionString, lessonId, chapterId, subjectId, user.getUserId(), user.getUserId());
            int questionId = questionDao.getQuestionIdByQuestion(questionString);
            
            for (int i = 0; i < dimensionIds.length; i++) {
                for (int j = i; j < dimensionIds.length; j++) {
                    if (dimensionIds[j].equals(dimensionIds[i])) {
                        questionDao.addQuestionDimension(questionId, Integer.parseInt(dimensionIds[j]));
                    }
                }
            }
            
            for (int i = 0; i < answers.length; i++) {
                int isTrue = 0;
                for (int j = i; j < trueAnswers.length; j++) {
                    if (trueAnswers[j].equals("on")) {
                        isTrue = 1;
                    }
                }
                questionDao.addAnswer(answers[i], questionId, isTrue);
            }
            response.sendRedirect("QuestionsList");
        } catch (Exception e) {
            String message = "Must fill out all information.";
            response.sendRedirect("QuestionDetail?message=" + message);
        }

    }
}
