package utils;

import dal.SubjectSettingDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import model.SubjectSetting;

public class getChapter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subject = request.getParameter("subject");
        int subjectId = Integer.parseInt(subject);
        
        SubjectSettingDAO ssDao = new SubjectSettingDAO();
        List<SubjectSetting> listc = ssDao.getAllChapterBySubjectId(subjectId);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<div class=\"chapter-section\">");
        out.println("<label >Chapter:</label>");
        out.println("<div style=\"width: 90%;\">");
        out.println("<select class=\"form-control\" name=\"chapter\" style=\"height: 40px;\">");
        for (SubjectSetting c : listc) {
            out.println("<option value=\"" + c.getSettingId() + "\">" + c.getSettingName() + "</option>");
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
