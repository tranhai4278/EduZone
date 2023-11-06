package User.controller;

import dal.DiscussionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

public class postComment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int discussionId = Integer.parseInt(request.getParameter("discussionId"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        String comment = request.getParameter("comment");

        DiscussionDAO dDao = new DiscussionDAO();
        dDao.postCommentWithDiscussionId(discussionId, comment, userId);

        response.sendRedirect("discussionDetail?discussionId=" + discussionId);
    }
}
