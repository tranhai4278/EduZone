package Admin.controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        int stt;
        if (status.matches("1")) {
            stt = 1;
        } else {
            stt = 0;
        }
        UserDAO userDao = new UserDAO();
        String userId = request.getParameter("userId");
        userDao.updateUserByAdmin(role, stt, userId);
        // Redirect 
        response.sendRedirect("userDetail?email=" + email);
    }
}
