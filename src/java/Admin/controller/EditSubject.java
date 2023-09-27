/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import model.Subject;
import model.User;

/**
 *
 * @author Nết
 */
@WebServlet(name = "EditSubject", urlPatterns = {"/editsubject"})
public class EditSubject extends HttpServlet {

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
        String id = request.getParameter("sid");
        AdminDAO dao = new AdminDAO();
        Subject s = dao.getSubjectbyId(id);
        List<User> listSM = dao.getAllSubManager();
        request.setAttribute("listSM", listSM);
        request.setAttribute("detail", s);
        request.getRequestDispatcher("edit-subject.jsp").forward(request, response);
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
        String code = request.getParameter("scode");
        String name = request.getParameter("sname");
        String mid = request.getParameter("mid");
        String description = request.getParameter("description");
        String imgUrl = request.getParameter("img");
        String action = request.getParameter("on");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        boolean status = "on".equals(action); // Kiểm tra nếu action là "on" thì isChecked là true, ngược lại là false


        try {
            Date uDate = new Date();
            int uid = u.getUserId();
            int id = Integer.parseInt(sid);
            int managerid = Integer.parseInt(mid);
            AdminDAO dao = new AdminDAO();
            Timestamp timestamp = new Timestamp(uDate.getTime());
            Subject s = new Subject(id, managerid, name, code, description, imgUrl, status, timestamp, uid);
            dao.editSubject(s);

        } catch (NumberFormatException e) {
            e.printStackTrace(); // Xử lý nếu có lỗi chuyển đổi
        }

        response.sendRedirect("settingSubject");
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
