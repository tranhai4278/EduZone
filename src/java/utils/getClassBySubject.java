package utils;

import dal.ClassDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Class;

public class getClassBySubject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subject = request.getParameter("subject");
        int subjectId = Integer.parseInt(subject);
        
        ClassDAO classDao = new ClassDAO();
        ArrayList<Class> classList = classDao.getClassBySubjectId(subjectId);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<div class=\"class-section\">");
        out.println("<label >Class:</label>");
        out.println("<div style=\"width: 90%;\">");
        out.println("<select class=\"form-control\" name=\"class\" style=\"height: 40px;\">");
        out.println("<option value=\"\" disabled selected>Nothing to choose</option>");
        for (Class c : classList) {
            out.println("<option value=\"" + c.getID() + "\">" + c.getClassCode() + "</option>");
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
