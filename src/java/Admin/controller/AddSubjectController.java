package Admin.controller;

import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

public class AddSubjectController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("securityController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectDAO dao = new SubjectDAO();

        String mIDStr = request.getParameter("mID");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String des = request.getParameter("des");
        String image = request.getParameter("image");

        String mess = ""; //Initialize the error message as null

        // Check for empty or null fields
        if (mIDStr == null || name == null || code == null) {
            mess = "You have left an empty field!";
            // check the length subject name
        } else {
            if (name.length() > 50) {
                mess = "Your input subject name is too long!";
                // check the length and format of subject code
            } else {
                if ((code.length() != 6) && (code.length() != 7) && (!code.matches("[A-Z]{3}\\d{3}[a-zA-Z]*"))) {
                    mess = "Subject code is not valid!";
                    // check if subject code is fomatted right
                } else if ((dao.getSubjectByCode(code)) != null) {
                    mess = "The subject has already existed!";
                    // if all are checked, a new subject is added in the database
                } else {
                    int mID = Integer.parseInt(mIDStr);
                    dao.addSubject(mID, name, code, des, image);
                    response.sendRedirect("settingSubject");
                    return; // early exit
                }
            }

            //return the error message to the jsp form
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("addSubject.jsp?code=" + code).forward(request, response);
        }
    }
}
