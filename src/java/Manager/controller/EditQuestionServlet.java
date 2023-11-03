package Manager.controller;

import dal.LessonDAO;
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
import model.Lesson;
import model.Question;
import model.QuestionChoise;
import model.Subject;
import model.SubjectSetting;
import model.User;

public class EditQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        
        SubjectDAO subjectDao = new SubjectDAO();
        QuestionDAO qDao = new QuestionDAO();
        
        ArrayList<Subject> subjectList = subjectDao.getAllSubjects();
        ArrayList<SubjectSetting> subjectSettingList = subjectDao.getAllSubjectSetting();
        ArrayList<SubjectSetting> ssqList = qDao.getSubjectSettingWithQuestionId(questionId);
        
        Question q = qDao.getQuestionById(questionId);
        int subjectId = q.getSubjectId();
        String qContent = q.getQuestion();
        ArrayList<QuestionChoise> answerList = qDao.getAllAnswerByQuestionId(questionId);
        
        int chapterId = q.getChapterId();
        int lessonId = q.getLessonId();
        
        SubjectSettingDAO ssDao = new SubjectSettingDAO();
        List<SubjectSetting> listc = ssDao.getAllChapterBySubjectId(subjectId);
        
        LessonDAO lessonDao = new LessonDAO();
        ArrayList<Lesson> listl = lessonDao.getLessonByChapterId(chapterId);
        
        request.setAttribute("ssqList", ssqList);
        request.setAttribute("listc", listc);
        request.setAttribute("listl", listl);
        request.setAttribute("chapterId", chapterId);
        request.setAttribute("lessonId", lessonId);
        request.setAttribute("questionId", questionId);
        request.setAttribute("answerList", answerList);
        request.setAttribute("qContent", qContent);
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("subjectSettingList", subjectSettingList);
        request.getRequestDispatcher("editQuestion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
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
            SubjectSettingDAO ssDao = new SubjectSettingDAO();
            
            ssDao.deleteDimensionWithQuestionId(questionId);
            for (int i = 0; i < dimensionIds.length; i++) {
                for (int j = i; j < dimensionIds.length; j++) {
                    if (dimensionIds[j].equals(dimensionIds[i])) {
                        questionDao.addQuestionDimension(questionId, Integer.parseInt(dimensionIds[j]));
                    }
                }
            }
            
            questionDao.updateQuestionWithId(questionId, questionString, lessonId, chapterId, subjectId, user.getUserId());
            
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
        } catch (Exception e) {
            String message = "Must fill out all information.";
            response.sendRedirect("QuestionDetail?message=" + message);
        }
    }
}
