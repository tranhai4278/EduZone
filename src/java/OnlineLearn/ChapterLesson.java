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
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        String id = request.getParameter("cid");
        ManagerDAO dao = new ManagerDAO();
        int cid = Integer.parseInt(id);
        SubjectSetting ss = dao.getSubjectSeting(cid);
        List<Lesson> listL = Odao.getLessonbyChapter(cid);
        PrintWriter out = response.getWriter();
        out.println("<div class=\"row\">\n"
                + "                                <div class=\"col-12\">\n"
                + "                                    <div class=\"ml-auto\">\n"
                + "                                        <h1>"+ss.getSettingName()+"</h1>\n"
                + "                                          <p> "+ss.getDescription()+"   </p> "
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"row\">\n"
                + "                                <div class=\"col-10 offset-2 \">\n");
        for (Lesson s : listL) {
            out.println(" <div>\n"
                    + "                                            <h4>" + s.getTitle() + "</h4>\n"
                    + "                                            <p>Type:" + s.getLessonType() + "</p>\n"
                    + "                                            <p>Description:" + s.getDescription() + "</p>\n");
            if ("Video".equals(s.getLessonType())) {
                out.println(" <iframe width=\"560\" height=\"315\" src=\"" + s.getVideoLink() + "\" title=\"" + s.getTitle() + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>\n");
            }
            if ("Quiz".equals(s.getLessonType())) {
                out.println("Quiz\n");
            }
            if ("Assignment".equals(s.getLessonType())) {
                out.println("Assignment\n");
            }
            out.println("                                      </div>\n"
                    
                    + "                                        <div class=\"seperator\"></div>\n");
        }

        out.println("                                </div>\n"
                + "                            </div>");

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
