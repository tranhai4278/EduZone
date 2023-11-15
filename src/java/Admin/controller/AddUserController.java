package Admin.controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();

        String name = request.getParameter("name");
        String genderStr = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String roleStr = request.getParameter("role");

        String mess = null; // Initialize the error message as null

        

        // Check for empty or null fields
        if (name == null || phone == null || email == null || roleStr == null) {
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
                    dao.addUser(name, gender,  phone, email, role);
                    response.sendRedirect("userList");
                    return; // Exit early since we successfully added the user
                }
            }
        }

        request.setAttribute("mess", mess);
        request.getRequestDispatcher("addUser.jsp?email=" + email).forward(request, response);

    }
}
