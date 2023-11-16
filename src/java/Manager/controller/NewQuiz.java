/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Manager.controller;

import dal.ManagerDAO;
import dal.QuestionDAO;
import dal.QuizDAO;
import dal.SubjectDAO;
import dal.SubjectSettingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Question;
import model.Quiz;
import model.QuizConfig;
import model.Subject;
import model.SubjectSetting;
import model.User;

/**
 *
 * @author MinhDQ
 */
public class NewQuiz extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SubjectDAO sd = new SubjectDAO();
        String quizID = request.getParameter("quizID");
        int quizId = Integer.parseInt(quizID);
        int numQues = Integer.parseInt(request.getParameter("quizNum"));
        int settingId = Integer.parseInt(request.getParameter("settingID"));
        QuizConfig quizcf = new QuizConfig(quizId, settingId, numQues);
        QuizDAO qd = new QuizDAO();
        qd.addQuizConfig(quizcf);
        Quiz quiz = qd.getQuiz("quiz_id", quizID);
        ArrayList<Question> questionList = qd.getQuestionsByQuiz(quizID);
        ArrayList<Question> questionListToAdd = qd.getQuestionToAdd(quiz);
        ManagerDAO Sdao = new ManagerDAO();
        SubjectSettingDAO ssdao = new SubjectSettingDAO();
        System.out.println(quiz.getSubjectId());
        List<SubjectSetting> listC = Sdao.getChapterbySubject(quiz.getS().getSubjectId());
        List<SubjectSetting> listss = ssdao.getDimentionBySubjectId(quiz.getS().getSubjectId());
        request.setAttribute("listss", listss);
        request.setAttribute("listC", listC);
        request.setAttribute("quiz", quiz);
        request.setAttribute("creater", sd.getManagerName(quiz.getCreateBy() + ""));
        request.setAttribute("updater", sd.getManagerName(quiz.getUpdateBy() + ""));
        request.setAttribute("subjectname", qd.getSubjectName(quiz.getS().getSubjectId() + ""));
        request.setAttribute("chaptername", qd.getChapterName(quiz.getSs().getSettingId() + ""));
        request.setAttribute("questionList", questionList);
        request.setAttribute("questionListToAdd", questionListToAdd);
        request.getRequestDispatcher("quizDetail.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
