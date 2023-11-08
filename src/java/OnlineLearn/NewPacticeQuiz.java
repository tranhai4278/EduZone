/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package OnlineLearn;

import dal.AdminDAO;
import dal.ManagerDAO;
import dal.QuizDAO;
import dal.SubjectSettingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import model.Quiz;
import java.util.Date;
import java.util.List;
import model.QuizConfig;
import model.QuizResult;
import model.Subject;
import model.SubjectSetting;
import model.User;

/**
 *
 * @author MinhDQ
 */
public class NewPacticeQuiz extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewPacticeQuiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewPacticeQuiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        int sid = Integer.parseInt(request.getParameter("sid"));
        String quizName = request.getParameter("quiz_name");
        boolean type = Boolean.parseBoolean(request.getParameter("type"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        int numOfQues = Integer.parseInt(request.getParameter("numOfQues"));
        String dimname = request.getParameter("dimName");
        String chapname = request.getParameter("chapName");
        int dimId = 0;
        int chapId = 0;
        if (dimname != null && !dimname.isEmpty()) {
            dimId = Integer.parseInt(dimname);
        }

        if (chapname != null && !chapname.isEmpty()) {
            chapId = Integer.parseInt(chapname);
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        QuizDAO qd = new QuizDAO();
        if (type == true) {
            Quiz quiz = new Quiz(quizName, sid, 0, false, numOfQues, true, duration, timestamp, userId, timestamp, userId);
            qd.addPracticeQuiz(quiz);
            Quiz q = qd.getQuiz("quiz_name", quizName);
            System.out.println(q);
            QuizConfig quizcf = new QuizConfig(q.getQuizId(),chapId, numOfQues);
            qd.addQuizConfig(quizcf);
            List<Quiz> listq = qd.getAllQuizPractice(userId, sid);
            AdminDAO dao = new AdminDAO();
            ManagerDAO Sdao = new ManagerDAO();
            SubjectSettingDAO ssdao = new SubjectSettingDAO();
            List<SubjectSetting> listC = Sdao.getChapterbySubject(sid);
            List<SubjectSetting> listss = ssdao.getDimentionBySubjectId(sid);
            Subject s = dao.getSubjectbyId(sid);
            request.setAttribute("listss", listss);
            request.setAttribute("quiz", listq);
            request.setAttribute("detail", s);
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("practiceQuiz.jsp").forward(request, response);
        } else {
            Quiz quiz = new Quiz(quizName, sid, 0, false, numOfQues, true, duration, timestamp, userId, timestamp, userId);
            qd.addPracticeQuiz(quiz);
            Quiz q = qd.getQuiz("quiz_name", quizName);
            QuizConfig quizcf = new QuizConfig(q.getQuizId() ,dimId, numOfQues);
            List<Quiz> listq = qd.getAllQuizPractice(userId, sid);
            AdminDAO dao = new AdminDAO();
            ManagerDAO Sdao = new ManagerDAO();
            SubjectSettingDAO ssdao = new SubjectSettingDAO();
            List<SubjectSetting> listC = Sdao.getChapterbySubject(sid);
            List<SubjectSetting> listss = ssdao.getDimentionBySubjectId(sid);
            Subject s = dao.getSubjectbyId(sid);
            request.setAttribute("listss", listss);
            request.setAttribute("quiz", listq);
            request.setAttribute("detail", s);
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("practiceQuiz.jsp").forward(request, response);
        }

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
