/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Admin.controller;

import dal.AdminDAO;
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
import model.Setting;
import model.Subject;
import model.User;

/**
 *
 * @author Nết
 */
@WebServlet(name = "EditSetting", urlPatterns = {"/editsetting"})
public class EditSetting extends HttpServlet {

    private String errorMessage = null;

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
        String sid = request.getParameter("sid");
        String gid = request.getParameter("gid");
        int group = Integer.parseInt(gid);
        int setting = Integer.parseInt(sid);
        AdminDAO dao = new AdminDAO();
        Setting s = dao.getSetting(group, setting);
        request.setAttribute("detail", s);
        request.getRequestDispatcher("edit-setting.jsp").forward(request, response);
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

        String sid = request.getParameter("id");
        String name = request.getParameter("sname");
        String sorder = request.getParameter("order");
        String action = request.getParameter("on");
        String note = request.getParameter("note");
        String groupid = request.getParameter("gid");
        boolean status = "on".equals(action);
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int gid = Integer.parseInt(groupid);
        int id = Integer.parseInt(sid);
        int order = Integer.parseInt(sorder);
        AdminDAO dao = new AdminDAO();
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        Setting scheck = dao.checkSettingName(name);
        if (scheck == null) {
            Setting s = new Setting(id, gid, name, status, order, note, timestamp, uid);
            dao.editSetting(s);
            response.sendRedirect("setting");
        } else {
            request.setAttribute("error", "Already exist");
            Setting s = dao.getSetting(gid, id);
            request.setAttribute("detail", s);
            request.getRequestDispatcher("edit-setting.jsp").forward(request, response);
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
