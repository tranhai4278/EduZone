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

public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

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
        User user = new User(md5, name, gender, phone, email, 4, true, d, 0, d, 1);

        //Check the domain exists and is active
        if (adminDAO.getDomainBySetting(dm, true) != null) {
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
        } else {
            //Notification error exists
            request.setAttribute("message_domain", "Your email is not allowed to register an account");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }
}
