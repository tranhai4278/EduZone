package Manager.controller;

import dal.AdminDAO;
import dal.ClassDAO;
import dal.ManagerDAO;
import dal.OnlineLearningDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Discussion;
import model.Class;
import model.Quiz;
import model.Subject;
import model.SubjectSetting;
import model.User;

public class discussionListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        ManagerDAO managerDao = new ManagerDAO();

        int totalPage = managerDao.totalPageDiscussion();
        List<Discussion> discussionList = managerDao.filterDiscussion(subjectId, userId, "", -1, null, 1);
        System.out.println(discussionList);
        
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(subjectId);
        Subject s = dao.getSubjectbyId(subjectId);
        List<Class> listClass = Odao.getClassbyUser(userId);
        Class c = Odao.getClassbyUser(userId).get(0);
        int classid=c.getID();
        List<Quiz> listQuizzes = Odao.getQuizbySubject(subjectId);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("classid", classid);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        
        request.setAttribute("userId", userId);
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("discussionList", discussionList);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageNo", 1);
        request.getRequestDispatcher("discussionList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        ManagerDAO managerDao = new ManagerDAO();
        ClassDAO classDao = new ClassDAO();

        String search = request.getParameter("search");
        
        String action = request.getParameter("status");
        int status = Integer.parseInt(action);
        
        String order = request.getParameter("orders");
        
        String spage = request.getParameter("pageNo");
        int page = Integer.parseInt(spage);

        List<Discussion> discussionList = managerDao.filterDiscussion(subjectId, userId, search, status, order, page);
        ArrayList<Class> classList = classDao.getClassBySubjectId(subjectId);
        
        OnlineLearningDAO Odao = new OnlineLearningDAO();
        AdminDAO dao = new AdminDAO();
        ManagerDAO Sdao = new ManagerDAO();
        List<SubjectSetting> listS = Sdao.getChapterbySubject(subjectId);
        Subject s = dao.getSubjectbyId(subjectId);
        List<Class> listClass = Odao.getClassbyUser(userId);
        List<Quiz> listQuizzes = Odao.getQuizbySubject(subjectId);
        request.setAttribute("listQuizzes", listQuizzes);
        request.setAttribute("detail", s);
        request.setAttribute("listC", listS);
        request.setAttribute("listClass", listClass);
        
        request.setAttribute("userId", userId);
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("search", search);
        request.setAttribute("status", status);
        request.setAttribute("orders", order);
        request.setAttribute("pageNo", page);
        request.setAttribute("totalPage", managerDao.totalPageDiscussion(subjectId, userId, search, status, order, page));
        request.setAttribute("discussionList", discussionList);
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("discussionList.jsp").forward(request, response);
    }
}
