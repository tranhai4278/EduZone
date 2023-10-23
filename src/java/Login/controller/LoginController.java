
package Login.controller;

import dal.UserDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utils.MyUtil;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get parameter from login.jsp
        String email = request.getParameter("lg_email");
        String pass = request.getParameter("lg_pass");

        //Encrypt passwords to SHA-1
        MyUtil util = new MyUtil();
        String md5 = util.toSHA1(pass);
        UserDAO userDAO = new UserDAO();
        //Check email, user active
        User user = userDAO.getUserByEmail(email);

        if (user == null || !user.getPassword().equals(md5)) {
            request.setAttribute("message", "Email or password is wrong");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (user.isStatus() == true) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (user.getRoleId() == 1 || user.getRoleId() == 2) {
                response.sendRedirect("setting");
            } else {
                response.sendRedirect("home");
            }

        } else {
            //Notification error exists
            request.setAttribute("message1", "Your account or domain email has been blocked");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
