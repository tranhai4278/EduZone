package Manager.controller;

import dal.DiscussionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteComment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int discussionId = Integer.parseInt(request.getParameter("discussionId"));
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        
        DiscussionDAO dDao = new DiscussionDAO();
        dDao.deleteComment(commentId);
        
        response.sendRedirect("discussionDetail?discussionId=" + discussionId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
