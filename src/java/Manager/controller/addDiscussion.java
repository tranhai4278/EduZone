package Manager.controller;

import dal.ClassDAO;
import dal.DiscussionDAO;
import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Subject;
import model.Class;
import model.User;

public class addDiscussion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");

        SubjectDAO subjectDao = new SubjectDAO();
        ClassDAO classDao = new ClassDAO();
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        ArrayList<Subject> subjectList = subjectDao.getSubjectWithUserId(userId);
        ArrayList<Class> classList = classDao.getClassBySubjectId(1);

        request.setAttribute("message", message);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("addDiscussion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int userId = user.getUserId();

            String subject = request.getParameter("subject");
            if (subject.isEmpty()) {
                throw new Exception("Must choose a subject.");
            }
            int subjectId = Integer.parseInt(subject);

            String classs = request.getParameter("class");
            if (classs.isEmpty()) {
                throw new Exception("Must choose a class.");
            }
            int classId = Integer.parseInt(classs);

            String title = request.getParameter("title");
            if (title.isEmpty()) {
                throw new Exception("Must fill out title.");
            }
            String description = request.getParameter("summernote");
            if (description.isEmpty()) {
                throw new Exception("Must fill out description.");
            }

            String startDateTimeStr = request.getParameter("startDateTime");
            String endDateTimeStr = request.getParameter("endDateTime");

            DiscussionDAO discussionDao = new DiscussionDAO();
            if (startDateTimeStr != null && !startDateTimeStr.isEmpty() && endDateTimeStr != null && !endDateTimeStr.isEmpty()) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr, formatter);
                LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr, formatter);
                LocalDateTime currentDateTime = LocalDateTime.now();

                if (endDateTime.isBefore(startDateTime) || endDateTime.isBefore(currentDateTime)) {
                    throw new Exception("End Time cannot set before Start Time or Today.");
                } else {
                    Timestamp startTimestamp = Timestamp.valueOf(startDateTime);
                    Timestamp endTimestamp = Timestamp.valueOf(endDateTime);

                    discussionDao.addDiscussion(subjectId, classId, title, description, userId, startTimestamp, endTimestamp, true);
                }
            }
            response.sendRedirect("discussionList?subjectId=" + subjectId);
        } catch (Exception e) {
            String message = e.getLocalizedMessage();
            response.sendRedirect("addDiscussion?message=" + message);
        }

    }
}
