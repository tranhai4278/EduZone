package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Subject;
import model.User;

public class SettingSubject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO d = new AdminDAO();
        int totalPage = d.totalPageSubject();
        List<Subject> listS = d.searchAndFilterSubjects("", -1, -1, null, 1);
        List<User> listU = d.getAllSubManager();
        request.setAttribute("listU", listU);
        request.setAttribute("listS", listS);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageNo", 1);
        request.getRequestDispatcher("setting-subject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        String action = request.getParameter("status");
        int status = Integer.parseInt(action);
        String mid = request.getParameter("manager");
        int manager = Integer.parseInt(mid);
        String order = request.getParameter("orders");
        String spage = request.getParameter("pageNo");
        int page = Integer.parseInt(spage);
        AdminDAO d = new AdminDAO();
        List<Subject> listS = d.searchAndFilterSubjects(search, manager, status, order, page);
        List<User> listU = d.getAllSubManager();
        request.setAttribute("search", search);
        request.setAttribute("status", status);
        request.setAttribute("manager", manager);
        request.setAttribute("orders", order);
        request.setAttribute("pageNo", page);
        request.setAttribute("totalPage", d.totalPageSubject(search, manager, status, order, page));
        request.setAttribute("listU", listU);
        request.setAttribute("listS", listS);
        request.getRequestDispatcher("setting-subject.jsp").forward(request, response);

    }
}
