/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package OnlineLearn;

import dal.AdminDAO;
import dal.ManagerDAO;
import dal.OnlineLearningDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Class;
import model.Subject;
import model.SubjectSetting;
import model.User;
import model.Quiz;

/**
 *
 * @author Nết
 */
public class OnlineLearning extends HttpServlet {

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
            out.println("<title>Servlet OnlineLearning</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OnlineLearning at " + request.getContextPath() + "</h1>");
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
        String sid = request.getParameter("sid");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int id = Integer.parseInt(sid);
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(id);
        Subject s = dao.getSubjectbyId(id);
        List<Class> listClass = Odao.getClassbyUser(uid);
        Class c = Odao.getClassbyUser(uid).get(0);
        int classid=c.getID();
        List<Quiz> listQuizzes = Odao.getQuizbySubject(id);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("classid", classid);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        request.getRequestDispatcher("onlineLearn.jsp").forward(request, response);
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
        String sid = request.getParameter("sid");
        int classid = Integer.parseInt(request.getParameter("classid"));
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int id = Integer.parseInt(sid);
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        QuizDAO qdao = new QuizDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(id);
        Subject s = dao.getSubjectbyId(id);
        List<Class> listClass = Odao.getClassbyUser(uid);
        request.setAttribute("sid", sid);

        List<Quiz> listQuizzes = Odao.getQuizbySubject(id);

        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("classid", classid);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        request.getRequestDispatcher("onlineLearn.jsp").forward(request, response);
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
