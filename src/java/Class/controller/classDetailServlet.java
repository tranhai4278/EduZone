

package Class.controller;

import dal.AdminDAO;
import model.Class;
        
import dal.ClassDAO;
import dal.SubjectDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Setting;
import model.Subject;
import model.User;

/**
 *
 * @author Admin
 */
public class classDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        User user = (User) request.getSession().getAttribute("user");
        String code = request.getParameter("Code");
        ClassDAO classDAO = new ClassDAO();
        UserDAO userDAO = new UserDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        AdminDAO adminDAO = new AdminDAO();
        
        Class c = classDAO.getClassByCode(code);
        ArrayList<Subject> s = subjectDAO.getSubjectsByManagerId(user.getUserId());
        ArrayList<User> u = userDAO.getUsersWithRoleId3();
        ArrayList<Setting> setting = adminDAO.getSemesters();
        
        request.setAttribute("classObj", c);
        request.setAttribute("subjects", s);
        request.setAttribute("users", u);
        request.setAttribute("semesters", setting);
        
        request.getRequestDispatcher("classdetail.jsp").forward(request, response);
    } 

}
