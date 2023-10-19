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
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import model.Subject;
import model.SubjectSetting;
import model.User;

/**
 *
 * @author Nết
 */
@WebServlet(name = "EditSubjectSetting", urlPatterns = {"/editSubjectSetting"})
public class EditSubjectSetting extends HttpServlet {

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
            out.println("<title>Servlet EditSubjectSetting</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditSubjectSetting at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(sid);
        ManagerDAO Mdao = new ManagerDAO();
        SubjectSetting s = Mdao.getSubjectSeting(id);
        request.setAttribute("detail", s);
        request.getRequestDispatcher("edit-subject-setting.jsp").forward(request, response);

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
        String sbid = request.getParameter("sid");
        String settingId = request.getParameter("settingId");
        String name = request.getParameter("name");
        String dimension = request.getParameter("type");
        String displayOrder = request.getParameter("displayOrder");
        String action = request.getParameter("on");
        String description = request.getParameter("description");
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        ManagerDAO Mdao = new ManagerDAO();
        boolean status = "on".equals(action);
        int order = Integer.parseInt(displayOrder);
        int sid = Integer.parseInt(sbid);
        int id = Integer.parseInt(settingId);
        AdminDAO dao = new AdminDAO();
        SubjectSetting ss = new SubjectSetting(id, sid, dimension, name, description, order, status, timestamp, uid);
        SubjectSetting scheck = Mdao.checkSettingEditNameinGroup(id, sid, name, dimension);
        if (scheck == null) {
            Mdao.editDimension(ss);
            List<SubjectSetting> listC = Mdao.getChapterbySubject(sid);
            List<SubjectSetting> listD = Mdao.getDimensionbySubject(sid);
            Subject s = dao.getSubjectbyId(sid);
            request.setAttribute("detail", s);
            request.setAttribute("listC", listC);
            request.setAttribute("listD", listD);
            request.setAttribute("successMessage", "Edit success");
            request.getRequestDispatcher("subjectDetail.jsp").forward(request, response);
        } else {
            List<SubjectSetting> listC = Mdao.getChapterbySubject(sid);
            List<SubjectSetting> listD = Mdao.getDimensionbySubject(sid);
            Subject s = dao.getSubjectbyId(sid);
            request.setAttribute("detail", s);
            request.setAttribute("listC", listC);
            request.setAttribute("listD", listD);
            request.setAttribute("error", "Already exist");
            request.getRequestDispatcher("subjectDetail.jsp").forward(request, response);

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
