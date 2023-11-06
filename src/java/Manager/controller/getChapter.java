/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Manager.controller;

import dal.LessonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.SubjectSetting;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author PHAM NGOC
 */
@WebServlet(name = "getChapter", urlPatterns = {"/getChapter"})
public class getChapter extends HttpServlet {

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
            out.println("<title>Servlet getChapter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getChapter at " + request.getContextPath() + "</h1>");
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
        String subject = request.getParameter("subject");
        LessonDAO dao = new LessonDAO();
        List<SubjectSetting> listc = dao.getAllChapterNamesBySubjectName(subject);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<label class=\"col-form-label\">Chapter* </label>\n"
                + "                                            <div>\n"
                + "                                                <select name=\"chapter\" required=\"true\">\n");
        for (SubjectSetting c : listc) {
            out.println("<option value=\"" + c.getSettingId() + "\">" + c.getSettingName() + "</option>\n");
        }

        out.println("</select>\n"
                + " </div>");
  } 
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String subject = request.getParameter("subject");
//        LessonDAO dao = new LessonDAO();
//        List<SubjectSetting> listc = dao.getAllChapterNamesBySubjectName(subject);
//
//        // Tạo một đối tượng JsonObject để lưu trữ dữ liệu JSON
//        JsonObject jsonResponse = new JsonObject();
//
//        // Tạo một đối tượng JsonArray để lưu trữ danh sách chapter
//        JsonArray chapterArray = new JsonArray();
//
//        for (SubjectSetting c : listc) {
//            // Tạo một đối tượng JsonObject cho mỗi chapter
//            JsonObject chapterObject = new JsonObject();
//            chapterObject.addProperty("id", c.getSettingId());
//            chapterObject.addProperty("name", c.getSettingName());
//
//            // Thêm đối tượng chapter vào mảng
//            chapterArray.add(chapterObject);
//        }
//
//        // Thêm mảng chapter vào đối tượng JSON chính
//        jsonResponse.add("chapters", chapterArray);
//
//        // Thiết lập kiểu dữ liệu và kích thước ký tự cho phản hồi
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        // Ghi dữ liệu JSON vào phản hồi
//        PrintWriter out = response.getWriter();
//        out.print(jsonResponse.toString());
//    }

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
