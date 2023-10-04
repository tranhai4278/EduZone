/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Admin.controller;

import dal.UserDAO;
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PHAM NGOC
 */
public class UserEditController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserEditController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserEditController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        // Lấy giá trị mới của vai trò từ request
        int newRole = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");
        // Thực hiện các thao tác cần thiết, chẳng hạn như cập nhật vai trò trong cơ sở dữ liệu
        // Sử dụng DAO để thực hiện các thao tác liên quan đến cơ sở dữ liệu
        UserDAO userDao = new UserDAO(); // Thay UserDao bằng tên của lớp DAO thực tế
        String userIdStr = request.getParameter("userId");
        int userId = Integer.parseInt(userIdStr);
        userDao.updateUserRole(userId, newRole); // userId là ID của người dùng

        // Redirect hoặc hiển thị trang phản hồi tùy theo logic ứng dụng của bạn
        response.sendRedirect("userDetail?email=" + email ); // Ví dụ: chuyển hướng đến trang hồi đáp sau khi cập nhật vai trò
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
