/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package OnlineLearn;

import dal.AdminDAO;
import dal.ManagerDAO;
import dal.OnlineLearningDAO;
import dal.QuizDAO;
import dal.SubjectSettingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Subject;
import model.SubjectSetting;
import model.User;
import model.Quiz;

/**
 *
 * @author MinhDQ
 */
public class PracticeQuiz extends HttpServlet {

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
            out.println("<title>Servlet PracticeQuiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PracticeQuiz at " + request.getContextPath() + "</h1>");
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
        int sid = Integer.parseInt(request.getParameter("sid"));
        System.out.println(sid);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        QuizDAO qd = new QuizDAO();
        List<Quiz> listq = qd.getAllQuizPractice(userId, sid);
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        SubjectSettingDAO ssdao = new SubjectSettingDAO();
        List<SubjectSetting> listC = Sdao.getChapterbySubject(sid);
        List<SubjectSetting> listss = ssdao.getDimentionBySubjectId(sid);
        List<model.Class> listClass = Odao.getClassbyUser(userId);
        model.Class c = Odao.getClassbyUser(userId).get(0);
        int classid = c.getID();
        Subject s = dao.getSubjectbyId(sid);
        List<Quiz> listQuizzes = Odao.getQuizbySubject(sid);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("listss", listss);
        request.setAttribute("quiz", listq);
        request.setAttribute("detail", s);
        request.setAttribute("listClass", listClass);
        request.setAttribute("classid", classid);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("practiceQuiz.jsp").forward(request, response);
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
        processRequest(request, response);
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
