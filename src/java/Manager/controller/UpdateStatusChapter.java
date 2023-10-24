/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Manager.controller;

import dal.AdminDAO;
import dal.ManagerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Subject;
import model.SubjectSetting;

/**
 *
 * @author Nết
 */
@WebServlet(name = "UpdateStatusChapter", urlPatterns = {"/updateStatusChapter"})
public class UpdateStatusChapter extends HttpServlet {

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
            out.println("<title>Servlet UpdateStatusChapter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStatusChapter at " + request.getContextPath() + "</h1>");
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
        String stid = request.getParameter("id");
        String sbid = request.getParameter("sid");
        String action = request.getParameter("status");
        int id = Integer.parseInt(stid);
        int sid = Integer.parseInt(sbid);
        boolean status = "true".equals(action); // Chuyển đổi từ kiểu String sang boolean
        ManagerDAO Mdao = new ManagerDAO();
        
        try {
            Mdao.updateSatusSubjectSetting(id, status);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Xử lý nếu có lỗi chuyển đổi
        }
        AdminDAO dao = new AdminDAO();
        Subject s = dao.getSubjectbyId(sid);
        List<SubjectSetting> listC = Mdao.getChapterbySubject(sid);
        List<SubjectSetting> listD = Mdao.getDimensionbySubject(sid);
        request.setAttribute("detail", s);
        request.setAttribute("listC", listC);
        request.setAttribute("listD", listD);
        request.setAttribute("successMessage", "Update success");
        request.getRequestDispatcher("subjectDetail.jsp").forward(request, response);
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
