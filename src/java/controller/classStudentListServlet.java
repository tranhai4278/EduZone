/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Class;
import model.User;
import dal.ClassDAO;
import dal.Class_TraineeDAO;
import dal.UserDAO;
import java.util.ArrayList;
import model.Class_Trainee;

/**
 *
 * @author Admin
 */
public class classStudentListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet classStudentListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classStudentListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         User user = (User) request.getSession().getAttribute("user");
        int ID = Integer.parseInt(request.getParameter("code"));
        System.out.println(ID);
        Class_TraineeDAO ClassTDAO = new Class_TraineeDAO();
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getAllUser();
        ArrayList<Class_Trainee> data = ClassTDAO.getTraineesByClassID(ID);
        for (Class_Trainee c : data) {
            System.out.println(c.getClassID() + ", " + c.getTraineeID());
        }

        request.setAttribute("users", users);
        request.setAttribute("trainee", data);

        request.getRequestDispatcher("classdetail-studentlist.jsp").forward(request, response);
    }

    private boolean studentInClass(int userId, ArrayList<Class_Trainee> trainee) {
        for (Class_Trainee classTrainee : trainee) {
            if (classTrainee.getTraineeID() == userId) {
                return true; // The student is already in the class.
            }
        }
        return false; // The student is not in the class.
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
