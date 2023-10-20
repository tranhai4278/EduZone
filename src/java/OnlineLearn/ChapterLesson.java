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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Lesson;
import model.Subject;
import model.SubjectSetting;

/**
 *
 * @author Nết
 */
@WebServlet(name = "ChapterLesson", urlPatterns = {"/chapterLesson"})
public class ChapterLesson extends HttpServlet {

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
            out.println("<title>Servlet ChapterLesson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChapterLesson at " + request.getContextPath() + "</h1>");
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
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        String id = request.getParameter("cid");
        int cid = Integer.parseInt(id);
        String sbid = request.getParameter("sid");
        int sid = Integer.parseInt(sbid);
        List<Lesson> listL = Odao.getLessonbyChapter(cid);
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listC = Sdao.getChapterbySubject(sid);
        Subject s = dao.getSubjectbyId(sid);
        request.setAttribute("detail", s);
        request.setAttribute("listC", listC);
        request.setAttribute("listL", listL);
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
