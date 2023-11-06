package Manager.controller;

import dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class updateDiscussionStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        int discussionId = Integer.parseInt(request.getParameter("discussionId"));

        String action = request.getParameter("status");
        boolean status = "true".equals(action);

        ManagerDAO managerDao = new ManagerDAO();

        try {
            managerDao.updateStatusDiscussion(discussionId, status);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        request.setAttribute("subjectId", subjectId);
        response.sendRedirect("discussionList?subjectId=" + subjectId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
