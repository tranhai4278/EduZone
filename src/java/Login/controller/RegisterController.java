/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Login.controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.MyUtil;

/**
 *
 * @author MinhDQ
 */
public class RegisterController extends HttpServlet {

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
        UserDAO userDAO = new UserDAO();
        String name = request.getParameter("rgt_Name");
        String pass = request.getParameter("rgt_Pass");
        String email = request.getParameter("rgt_Email");
        String avatar = request.getParameter("rgt_Ava");
        String phone = request.getParameter("rgt_Phone");
        String gender = request.getParameter("rgt_gender");

        MyUtil util = new MyUtil();
        String captcha = util.getCaptcha();
        String md5 = util.toSHA1(pass);

        HttpSession session = request.getSession();
//        session.setAttribute("name_rgt", name);
//        session.setAttribute("pass_rgt", md5);
//        session.setAttribute("email_rgt", email);
        session.setAttribute("captcha_rgt", captcha);

        Date d = new Date();
        User user = new User(md5, name, true, avatar, phone, email, 1, true, d, 1, d, 1);
        if (userDAO.getUserByEmail(email) != null) {
            request.setAttribute("message_email", "Email already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else if(userDAO.getUserByPhone(phone) != null){
            request.setAttribute("message_phone", "Phone number already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else {
            session.setAttribute("user_rgt", user);
            String link = "ma otp cua ban la:  " + captcha;
            try {
                util.sendMail("minhdqhe163046@fpt.edu.vn", "test1", link);

            } catch (Exception ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.getRequestDispatcher("checkauthen.jsp").forward(request, response);
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
