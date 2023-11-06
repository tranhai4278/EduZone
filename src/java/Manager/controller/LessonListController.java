/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Manager.controller;

import dal.LessonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Lesson;

/**
 *
 * @author PHAM NGOC
 */
public class LessonListController extends HttpServlet {
   
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
        LessonDAO dao = new LessonDAO();
        ArrayList<Lesson> list = dao.getAllLessons();
        request.setAttribute("list", list);
        request.getRequestDispatcher("lessonList.jsp").forward(request, response);
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
        processRequest(request, response);
        
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
        processRequest(request, response);
//        response.setContentType("text/html;charset=UTF-8");
//        String search = request.getParameter("criteria");
//        String key = request.getParameter("key");
//        String criteria = null;
//        switch (search) {
//            case "subject_name":
//                criteria = "s.subject_name";
//                break;
//            case "chapter_name":
//                criteria = "ss.setting_name";
//                break;
//            case "title":
//                criteria = "l.title";
//                break;
//            case "lesson_type":
//                criteria = "l.lesson_type";
//                break;
//            default:
//                break;
//        }
//        LessonDAO dao = new LessonDAO();
//        ArrayList<Lesson> list = dao.searchLesson(criteria, key);
//        request.setAttribute("searchList", list);
//        request.getRequestDispatcher("lessonList.jsp").forward(request, response);
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
