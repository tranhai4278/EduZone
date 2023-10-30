package utils;

import dal.LessonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Lesson;

public class getLesson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String chapter = request.getParameter("chapter");
        int chapterId = Integer.parseInt(chapter);
        
        LessonDAO lessonDao = new LessonDAO();
        ArrayList<Lesson> listl = lessonDao.getLessonByChapterId(chapterId);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<div class=\"lesson-section\">");
        out.println("<label for=\"lesson\">Lesson:</label>");
        out.println("<div style=\"width: 50%;\">");
        out.println("<select class=\"form-control\" id=\"lesson\" name=\"lesson\" onchange=\"disableSelect(this);\">");
        out.println("<option value=\"\" disabled>Nothing selected</option>");
        for (Lesson l : listl) {
            out.println("<option value=\"" + l.getLessonId() + "\">" + l.getTitle() + "</option>");
        }
        out.println("</select>");
        out.println("</div>");
        out.println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
