package Login.controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.MyUtil;

public class authen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recive Email
        MyUtil util = new MyUtil();
        String captcha = util.getCaptcha();


        HttpSession session = request.getSession();
        session.setAttribute("captcha_rgt", captcha);

        User user = (User) session.getAttribute("user_rgt");


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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get parameter form checkauthe.jsp
        String code_fe = request.getParameter("code");
        //Get session of OTP code, user account
        HttpSession session = request.getSession();
        String code_be = session.getAttribute("captcha_rgt").toString();

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

}
