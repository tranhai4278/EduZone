package Manager.controller;

import static Manager.controller.addQuestion.hasDuplicates;
import dal.SubjectDAO;
import dal.QuestionDAO;
import dal.SubjectSettingDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Question;
import model.QuestionChoise;
import model.Subject;
import model.SubjectSetting;
import model.User;

public class editQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        
        SubjectDAO subjectDao = new SubjectDAO();
        QuestionDAO qDao = new QuestionDAO();
        SubjectSettingDAO ssDao = new SubjectSettingDAO();
        
        ArrayList<Subject> subjectList = subjectDao.getAllSubjects();
        ArrayList<SubjectSetting> ssList = subjectDao.getAllSubjectSetting();
        ArrayList<SubjectSetting> ssqList = qDao.getSubjectSettingWithQuestionId(questionId);

        Question q = qDao.getQuestionById(questionId);
        int flag = q.getFlag();
        int subjectId = q.getSubjectId();
        int chapterId = q.getChapterId();
        String qContent = q.getQuestion();
        
        List<SubjectSetting> cList = ssDao.getAllChapterBySubjectId(subjectId);
        ArrayList<QuestionChoise> answerList = qDao.getAllAnswerByQuestionId(questionId);
        
        request.setAttribute("questionId", q.getQuestionId());
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("flag", flag);
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("cList", cList);
        request.setAttribute("chapterId", chapterId);
        request.setAttribute("ssqList", ssqList);
        request.setAttribute("ssList", ssList);
        request.setAttribute("qContent", qContent);
        request.setAttribute("answerList", answerList);
        request.setAttribute("listc", cList);
        request.setAttribute("message", message);
        request.getRequestDispatcher("editQuestion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        
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
            questionDao.updateQuestionWithId(questionId, questionString, flag, chapterId, subjectId, user.getUserId());
            
            SubjectSettingDAO ssDao = new SubjectSettingDAO();
            ssDao.deleteDimensionWithQuestionId(questionId);
            for (int i = 0; i < dimensionIds.length; i++) {
                for (int j = i; j < dimensionIds.length; j++) {
                    if (dimensionIds[j].equals(dimensionIds[i])) {
                        questionDao.addQuestionDimension(questionId, Integer.parseInt(dimensionIds[j]));
                    }
                }
            }
            
            questionDao.deleteAnswerWithQuestionId(questionId);
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
        } catch(Exception e) {
            String message = e.getLocalizedMessage();
            response.sendRedirect("editQuestion?questionId=" + questionId + "&message=" + message);
        }
    }
}
