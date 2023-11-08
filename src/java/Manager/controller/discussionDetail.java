package Manager.controller;

import dal.AdminDAO;
import dal.DiscussionDAO;
import dal.ManagerDAO;
import dal.OnlineLearningDAO;
import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Comment;
import model.Discussion;
import model.Quiz;
import model.Subject;
import model.SubjectSetting;
import model.User;

public class discussionDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int discussionId = Integer.parseInt(request.getParameter("discussionId"));
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        
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
        ArrayList<Comment> reversedCommentList = reverseArr(commentList);
        
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(subjectId);
        Subject s = dao.getSubjectbyId(subjectId);
        List<model.Class> listClass = Odao.getClassbyUser(userId);
        List<Quiz> listQuizzes = Odao.getQuizbySubject(subjectId);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        
        request.setAttribute("discussionId", discussionId);
        request.setAttribute("subjectName", subjectName);
        request.setAttribute("subjectCode", subjectCode);
        request.setAttribute("title", title);
        request.setAttribute("description", description);
        request.setAttribute("time", time);
        request.setAttribute("status", status);
        request.setAttribute("commentList", reversedCommentList);
        request.getRequestDispatcher("discussionDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    public ArrayList<Comment> reverseArr(ArrayList<Comment> list) {
    ArrayList<Comment> reversedList = new ArrayList<>(list.size());

    for (int i = list.size() - 1; i >= 0; i--) {
        reversedList.add(list.get(i));
    }

    return reversedList;
}
}
