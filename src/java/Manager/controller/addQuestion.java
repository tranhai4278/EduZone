package Manager.controller;

import dal.SubjectDAO;
import dal.SubjectSettingDAO;
import dal.QuestionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Subject;
import model.SubjectSetting;
import model.User;

public class addQuestion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");

        SubjectDAO subjectDao = new SubjectDAO();
        ArrayList<Subject> subjectList = subjectDao.getAllSubjects();

        SubjectSettingDAO ssDao = new SubjectSettingDAO();
        ArrayList<SubjectSetting> ssList = ssDao.getSubjectSetting();
        List<SubjectSetting> cList = ssDao.getAllChapterBySubjectId(1);
        
        request.setAttribute("cList", cList);
        request.setAttribute("message", message);
        request.setAttribute("ssList", ssList);
        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            int flag = Integer.parseInt(request.getParameter("flag"));
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            int chapterId = Integer.parseInt(request.getParameter("chapter"));

            String[] dimensionIds = request.getParameterValues("dimension");
            if (hasDuplicates(dimensionIds)) {
                throw new Exception("Dimension cannot have two or more of the same type.");
            }
            
            String questionString = request.getParameter("summernote");
            if (questionString.isEmpty()) {
                throw new Exception("Must fill out question content.");
            }

            String[] answers = request.getParameterValues("answer");
            if (answers.length <= 1) {
                throw new Exception("Question must have atleast 2 answers.");
            }
            String[] trueAnswers = request.getParameterValues("true-answer");
            if (trueAnswers.length == 0) {
                throw new Exception("Question must have atleast 1 true answer.");
            }
            if (answers.length == trueAnswers.length) {
                throw new Exception("All answers cannot be true answer.");
            }

            QuestionDAO questionDao = new QuestionDAO();
            questionDao.addQuestion(user.getUserId(), questionString, flag, chapterId, subjectId, user.getUserId(), user.getUserId());

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
            String message = e.getLocalizedMessage();
            response.sendRedirect("addQuestion?message=" + message);

        }
    }

    public static boolean hasDuplicates(String[] array) {
        Set<String> uniqueValues = new HashSet<>();
        for (String item : array) {
            if (!uniqueValues.add(item)) {
                return true; // Found a duplicate
            }
        }
        return false;
    }
}
