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
import model.Setting;
import model.User;

/**
 *
 * @author Nết
 */
@WebServlet(name = "AddSetting", urlPatterns = {"/addsetting"})
public class AddSetting extends HttpServlet {

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
        String gid = request.getParameter("gid");
        int group = Integer.parseInt(gid);
        request.setAttribute("gid", group);
        request.getRequestDispatcher("add-setting.jsp").forward(request, response);
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
        String gid = request.getParameter("gid");
        String name = request.getParameter("sname");
        String sorder = request.getParameter("order");
        String note = request.getParameter("note");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int group = Integer.parseInt(gid);
        int order = Integer.parseInt(sorder);
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        Setting s =new Setting(group, name, true, order, note, uDate, uid, uDate, uid);
        AdminDAO dao = new AdminDAO();
        dao.addSetting(s);
        response.sendRedirect("setting");
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
