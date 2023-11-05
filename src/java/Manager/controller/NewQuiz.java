///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//
//package Manager.controller;
//
//import dal.QuestionDAO;
//import dal.QuizDAO;
//import dal.SubjectDAO;
//import dal.SubjectSettingDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import model.Question;
//import model.Quiz;
//import model.Subject;
//import model.SubjectSetting;
//import model.User;
//
///**
// *
// * @author MinhDQ
// */
//public class NewQuiz extends HttpServlet {
//   
//    /** 
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//    } 
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /** 
//     * Handles the HTTP <code>GET</code> method.
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        QuizDAO qd = new QuizDAO();
//         int subjectId = Integer.parseInt(request.getParameter("subject"));
//        int chapterId = Integer.parseInt(request.getParameter("chapter"));
//        String name = request.getParameter("name");
//        boolean status = Boolean.parseBoolean(request.getParameter("status"));
//        boolean type = Boolean.parseBoolean(request.getParameter("type"));
//        int numberOfQuestion = Integer.parseInt(request.getParameter("total"));
//        int quizTime = Integer.parseInt(request.getParameter("time"));
//        Date uDate = new Date();
//        Timestamp timestamp = new Timestamp(uDate.getTime());
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        int userID = user.getUserId();
//        Quiz quiz = new Quiz(name, subjectId, chapterId, type, numberOfQuestion, status, quizTime, timestamp, userID, timestamp, userID);
//        System.out.println(quiz);
//        qd.addQuiz(quiz);
//        request.setAttribute("txt", "Success");
//        request.getRequestDispatcher("quizs?action=list").forward(request, response);
//    } 
//
//    /** 
//     * Handles the HTTP <code>POST</code> method.
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//
//        processRequest(request, response);
//    }
//
//    /** 
//     * Returns a short description of the servlet.
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
