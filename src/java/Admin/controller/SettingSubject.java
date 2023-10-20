package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Subject;

public class SettingSubject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO d = new AdminDAO();
        List<Subject> listS = d.getAllSubject();
        request.setAttribute("listS", listS);
        request.getRequestDispatcher("setting-subject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        String name = request.getParameter("txt");
        List<Subject> list = dao.searchBySubjectName(name);
        request.setAttribute("listS", list);
        request.getRequestDispatcher("setting-subject.jsp").forward(request, response);
    }
}
