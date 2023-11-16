/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package OnlineLearn;

import dal.OnlineLearningDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Question;
import model.QuestionChoise;

/**
 *
 * @author Nết
 */
public class Quiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("qid"));
        int qid = Integer.parseInt(request.getParameter("que"));
        OnlineLearningDAO dao = new OnlineLearningDAO();
        model.Quiz q = dao.getQuizbyId(id);
        Question que = dao.getQuestion(id).get(qid - 1);
        List<QuestionChoise> listC = dao.getChoice(que.getQuestionId());
        request.setAttribute("detail", q);
        request.setAttribute("quession", que);
        request.setAttribute("que", qid);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("qid"));
        int qid = Integer.parseInt(request.getParameter("que"));
        OnlineLearningDAO dao = new OnlineLearningDAO();
        model.Quiz q = dao.getQuizbyId(id);
        Question que = dao.getQuestion(id).get(qid - 1);
        List<QuestionChoise> listC = dao.getChoice(que.getQuestionId());
        Cookie[] arr = request.getCookies();
        String txt="";
        if (arr != null) {
            for (Cookie o : arr) {
                if(o.getName().equals("answer")){
                    txt+=o.getName();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }

        request.setAttribute("detail", q);
        request.setAttribute("quession", que);
        request.setAttribute("que", qid);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
