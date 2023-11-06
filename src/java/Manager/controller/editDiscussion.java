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
import model.Discussion;
import model.Subject;
import model.User;

public class editDiscussion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");

        String discussionIdStr = request.getParameter("discussionId");
        int discussionId = Integer.parseInt(discussionIdStr);

        DiscussionDAO dDao = new DiscussionDAO();
        Discussion discussion = dDao.getDiscussionById(discussionId);

        int subjectId = discussion.getSubjectId();
        int classId = discussion.getClassId();

        SubjectDAO subjectDao = new SubjectDAO();
        ClassDAO classDao = new ClassDAO();

        ArrayList<Subject> subjectList = subjectDao.getAllSubjects();
        ArrayList<model.Class> classList = classDao.getClassBySubjectId(subjectId);

        String title = discussion.getTitle();
        String description = discussion.getDescription();

        String startTime = discussion.getFormattedStartTime();
        String endTime = discussion.getFormattedEndTime();

        request.setAttribute("message", message);
        request.setAttribute("discussionId", discussionId);
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("classId", classId);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("classList", classList);
        request.setAttribute("title", title);
        request.setAttribute("description", description);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);

        request.getRequestDispatcher("editDiscussion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String discussionIdStr = request.getParameter("discussionId");
        int discussionId = Integer.parseInt(discussionIdStr);

        DiscussionDAO discussionDao = new DiscussionDAO();
        Discussion discussion = discussionDao.getDiscussionById(discussionId);

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
            
            String startDateTimeStr = discussion.getFormattedStartTime();
            String endDateTimeStr = request.getParameter("endDateTime");
            LocalDateTime currentDateTime = LocalDateTime.now();

            if (endDateTimeStr != null && !endDateTimeStr.isEmpty()) {
                DateTimeFormatter originalFormatterStart = DateTimeFormatter.ofPattern("dd-MM-uuuu | HH:mm");
                DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

                LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr, originalFormatterStart);
                LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr, desiredFormatter);

                Timestamp endTimestamp = Timestamp.valueOf(endDateTime);
                if (endDateTime.isBefore(startDateTime) || endDateTime.isBefore(currentDateTime)) {
                    throw new Exception("End Time cannot set before Start Time or Today.");
                } else {
                    discussionDao.updateDiscussion(discussionId, subjectId, classId, title, description, userId, endTimestamp, true);
                }
            } else {
                discussionDao.updateDiscussion(discussionId, subjectId, classId, title, description, userId, true);
            }

            response.sendRedirect("discussionList?subjectId=" + subjectId);
        } catch (Exception e) {
            String message = e.getLocalizedMessage();
            response.sendRedirect("editDiscussion?discussionId=" + discussionId + "&message=" + message);
        }
    }
}
