/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package OnlineLearn;

import dal.AdminDAO;
import dal.ManagerDAO;
import dal.OnlineLearningDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Lesson;
import model.Subject;
import model.SubjectSetting;
import model.User;

/**
 *
 * @author Nết
 */
public class ExtraLesson extends HttpServlet {

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
            out.println("<title>Servlet ExtraLesson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExtraLesson at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int sid = Integer.parseInt(request.getParameter("sid"));
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        int cid = Integer.parseInt(request.getParameter("cid"));
        int lid = Integer.parseInt(request.getParameter("lid"));
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(sid);
        Subject s = dao.getSubjectbyId(sid);
        List<model.Class> listClass = Odao.getClassbyUser(uid);
        List<model.Quiz> listQuizzes = Odao.getQuizbySubject(sid);
        Odao.deleteExtraLesson(lid);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        request.setAttribute("classid", cid);
        request.setAttribute("successMessage", "Delete success");
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        String title = request.getParameter("title");
        int cid = Integer.parseInt(request.getParameter("cid"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        int chapter = Integer.parseInt(request.getParameter("chapter"));
        String type = request.getParameter("type");
        String video = request.getParameter("video");
        int quiz = Integer.parseInt(request.getParameter("quiz"));
        String file = request.getParameter("file");
        String des = request.getParameter("des");
        String action = request.getParameter("on");
        boolean status = "on".equals(action);
        System.out.println(video);
        int order = Integer.parseInt(request.getParameter("displayOrder"));
        Date uDate = new Date();
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        Lesson l = new Lesson(title, chapter, cid, type, quiz, video, file, status, des, null, null, order, timestamp, uid, timestamp, uid);
        Odao.extraLesson(l);
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(sid);
        Subject s = dao.getSubjectbyId(sid);
        List<model.Class> listClass = Odao.getClassbyUser(uid);
        List<model.Quiz> listQuizzes = Odao.getQuizbySubject(sid);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        request.setAttribute("classid", cid);
        request.setAttribute("successMessage", "Add success");
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
