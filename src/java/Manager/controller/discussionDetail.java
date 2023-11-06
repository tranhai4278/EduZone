package Manager.controller;

import dal.DiscussionDAO;
import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Comment;
import model.Discussion;
import model.Subject;

public class discussionDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int discussionId = Integer.parseInt(request.getParameter("discussionId"));
        
        DiscussionDAO discussionDao = new DiscussionDAO();
        SubjectDAO subjectDao = new SubjectDAO();
        Discussion discussion = discussionDao.getDiscussionById(discussionId);
        
        int subjectId = discussion.getSubjectId();
        Subject subject = subjectDao.getSubjectWithId(subjectId);
        String subjectName = subject.getSubjectName();
        String subjectCode = subject.getSubjectCode();
        
        String title = discussion.getTitle();
        String description = discussion.getDescription();
        boolean status = discussion.isStatus();
        
        String time = "(" + discussion.getFormattedStartTime() + ") - (" + discussion.getFormattedEndTime() + ")";
        
        ArrayList<Comment> commentList = discussionDao.getCommentByDiscussionId(discussionId);
        
        request.setAttribute("discussionId", discussionId);
        request.setAttribute("subjectName", subjectName);
        request.setAttribute("subjectCode", subjectCode);
        request.setAttribute("title", title);
        request.setAttribute("description", description);
        request.setAttribute("time", time);
        request.setAttribute("status", status);
        request.setAttribute("commentList", commentList);
        request.getRequestDispatcher("discussionDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
