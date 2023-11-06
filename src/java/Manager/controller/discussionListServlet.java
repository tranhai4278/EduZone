package Manager.controller;

import dal.ClassDAO;
import dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Discussion;
import model.Class;

public class discussionListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        ManagerDAO managerDao = new ManagerDAO();
        ClassDAO classDao = new ClassDAO();

        int totalPage = managerDao.totalPageDiscussion();
        List<Discussion> discussionList = managerDao.filterDiscussion(subjectId, "", -1, -1, null, 1);
        ArrayList<Class> classList = classDao.getClassBySubjectId(subjectId);
        
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("discussionList", discussionList);
        request.setAttribute("classList", classList);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageNo", 1);
        request.getRequestDispatcher("discussionList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        ManagerDAO managerDao = new ManagerDAO();
        ClassDAO classDao = new ClassDAO();

        String search = request.getParameter("search");
        
        String action = request.getParameter("status");
        int status = Integer.parseInt(action);
        
        String classCode = request.getParameter("classCode");
        int classId = Integer.parseInt(classCode);
        
        String order = request.getParameter("orders");
        
        String spage = request.getParameter("pageNo");
        int page = Integer.parseInt(spage);

        List<Discussion> discussionList = managerDao.filterDiscussion(subjectId, search, classId, status, order, page);
        ArrayList<Class> classList = classDao.getClassBySubjectId(subjectId);
        
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("search", search);
        request.setAttribute("status", status);
        request.setAttribute("classCode", classCode);
        request.setAttribute("orders", order);
        request.setAttribute("pageNo", page);
        request.setAttribute("totalPage", managerDao.totalPageDiscussion(subjectId, search, classId, status, order, page));
        request.setAttribute("discussionList", discussionList);
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("discussionList.jsp").forward(request, response);
    }
}
