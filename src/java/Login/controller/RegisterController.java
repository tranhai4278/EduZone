/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Login.controller;

import dal.AdminDAO;
import dal.UserDAO;
import java.io.IOException;
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
        AdminDAO adminDAO = new AdminDAO();
        //get parameter form Register.jsp
        String name = request.getParameter("rgt_Name");
        String pass = request.getParameter("rgt_Pass");
        String email = request.getParameter("rgt_Email");
        String phone = request.getParameter("rgt_Phone");
        String gd = request.getParameter("rgt_gender");
        boolean gender = Boolean.parseBoolean(gd);

        MyUtil util = new MyUtil();
        String captcha = util.getCaptcha();   //Create random OTP 
        String md5 = util.toSHA1(pass);       //Encrypt passwords to SHA-1
        String dm = util.extractDomain(email);//Get domain from user email

        HttpSession session = request.getSession();
        session.setAttribute("captcha_rgt", captcha);//Save session OTP

        //New user
        Date d = new Date();
        User user = new User(md5, name, gender, phone, email, 1, true, d, 1, d, 1);
        
        //Check the domain exists and is active
        if (adminDAO.getDomainBySetting(dm,true)!= null) {
            //Check email, phone exists, send email
            if (userDAO.getUserByEmail(email) != null) {
                request.setAttribute("message_email", "Email already exists");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (userDAO.getUserByPhone(phone) != null) { 
                request.setAttribute("message_phone", "Phone number already exists");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                session.setAttribute("user_rgt", user);
                String link = "Your otp:  " + captcha;
                try {
                    util.sendMail(email, "Email confirm", link);

                } catch (Exception ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getRequestDispatcher("checkauthen.jsp").forward(request, response);
            }
        }else {
            //Notification error exists
            request.setAttribute("message_domain", "Your email is not allowed to register an account");
            request.getRequestDispatcher("register.jsp").forward(request, response);
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
