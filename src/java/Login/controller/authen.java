<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
=======
>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
package Login.controller;

import dal.UserDAO;
import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
=======
>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.MyUtil;

<<<<<<< HEAD
/**
 *
 * @author MinhDQ
 */
public class authen extends HttpServlet {

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
            out.println("<title>Servlet authen</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet authen at " + request.getContextPath() + "</h1>");
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
=======
public class authen extends HttpServlet {

>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recive Email
        MyUtil util = new MyUtil();
        String captcha = util.getCaptcha();
<<<<<<< HEAD
        
        HttpSession session = request.getSession();
        session.setAttribute("captcha_rgt", captcha);
        
        User user = (User) session.getAttribute("user_rgt");
=======

        HttpSession session = request.getSession();
        session.setAttribute("captcha_rgt", captcha);

        User user = (User) session.getAttribute("user_rgt");

>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
        String reciveEmail = user.getEmail();
        String title = "recive Email";
        String content = "resend the otp code " + captcha;
        try {
            util.sendMail(reciveEmail, title, content);
        } catch (Exception ex) {
            Logger.getLogger(authen.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("checkauthen.jsp").forward(request, response);
    }

<<<<<<< HEAD
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
=======
>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get parameter form checkauthe.jsp
        String code_fe = request.getParameter("code");
        //Get session of OTP code, user account
        HttpSession session = request.getSession();
        String code_be = session.getAttribute("captcha_rgt").toString();
<<<<<<< HEAD
        User user=(User)session.getAttribute("user_rgt");
        //check confim OTP, notification error exists
        if(code_fe.trim().equals(code_be.trim())){
            UserDAO udao = new UserDAO();
            udao.addUser(user);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            request.setAttribute("message", "OTP code does not exist");
            request.getRequestDispatcher("checkauthen.jsp").forward(request, response);
        }
      //  processRequest(request, response);
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

=======
        User user = (User) session.getAttribute("user_rgt");
        //check confim OTP, notification error exists
        if (code_fe.trim().equals(code_be.trim())) {
            UserDAO udao = new UserDAO();
            udao.addUser(user);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "OTP code does not exist");
            request.getRequestDispatcher("checkauthen.jsp").forward(request, response);
        }
    }
>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
}
