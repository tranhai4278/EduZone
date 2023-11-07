package Manager.controller;

import dal.LessonDAO;
import dal.QuizDAO;
import dal.SubjectDAO;
import dal.SubjectSettingDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Quiz;
import model.Subject;
import model.SubjectSetting;

/**
 *
 * @author PHAM NGOC
 */
public class AddLessonController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addLessonController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addLessonController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        SubjectDAO sdao = new SubjectDAO();
        ArrayList<Subject> listS = sdao.getAllSubjects();
        
        SubjectSettingDAO ssdao = new SubjectSettingDAO();
        ArrayList<SubjectSetting> listSS = ssdao.getAllChapters();       
        
        QuizDAO qdao = new QuizDAO();
        ArrayList<Quiz> listQ = new ArrayList<>();
        listQ = qdao.getAllQuizzes();
        
        request.setAttribute("listSubjects", listS);
        request.setAttribute("listChapters", listSS);
        request.setAttribute("listQuizzes", listQ);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/newLesson.jsp");
        dispatcher.forward(request, response);

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        LessonDAO dao = new LessonDAO();
        String title = request.getParameter("title");
        int subject = Integer.parseInt(request.getParameter("subject"));
        int chapter = Integer.parseInt(request.getParameter("chapter"));
        String type = request.getParameter("type");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String video = request.getParameter("video");
        int quiz = Integer.parseInt(request.getParameter("quiz"));
        String file = request.getParameter("file");
        String des = request.getParameter("des");

        String mess = null; // Initialize the error message as null
        if (title.length() > 100) {
            mess = "Your input title is too long!";
        }
        dao.addLesson(title, subject, chapter, type, quiz, video, file, status, des);
        response.sendRedirect("lessonList");
    }

        /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
