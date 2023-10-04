/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Admin.controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author PHAM NGOC
 */
public class AddUserController extends HttpServlet {

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
            out.println("<title>Servlet addUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUser at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        UserDAO dao = new UserDAO();

        String name = request.getParameter("name");
        String genderStr = request.getParameter("gender");
        String avatar = request.getParameter("avatar");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String roleStr = request.getParameter("role");

        String mess = null; // Initialize the error message as null
        
        if (avatar == null){
            avatar = "https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg";
        }

        // Check for empty or null fields
        if ( name == null || phone == null || email == null || roleStr == null) {
            mess = "You have left an empty field!";
        } else if (name.length() > 100) {
            mess = "Your input name is too long!";
        } else {
            // Check phone number length and existence
            if (phone.length() != 9 && phone.length() != 10) {
                mess = "Phone number is not valid!";
            } else if (dao.doesPhoneNumberExist(phone)) {
                mess = "Phone number has already existed!";
            } else if (!phone.matches("\\d+")) {
                mess = "Phone number can only contain digits 0-9!";
            } else {
                // Check email format and existence
                if (!email.contains("@") || !email.contains(".") || email.length() > 100) {
                    mess = "Email is not valid!";
                } else if (dao.doesEmailExist(email)) {
                    mess = "Email has already existed!";
                } else {
                    // Validation passed, parse data and add user
                    int role = Integer.parseInt(roleStr);
                    boolean gender = Boolean.parseBoolean(genderStr);
                    dao.addUser( name, gender, avatar, phone, email, role);
                    response.sendRedirect("userList");
                    return; // Exit early since we successfully added the user
                }
            }
        }

        request.setAttribute("mess", mess);
        request.getRequestDispatcher("addUser.jsp?email=" + email).forward(request, response);

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
