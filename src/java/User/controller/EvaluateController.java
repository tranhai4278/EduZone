/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package User.controller;

import dal.AssignmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PHAM NGOC
 */
public class EvaluateController extends HttpServlet {
   
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
        AssignmentDAO dao = new AssignmentDAO();
        String assignmentID = request.getParameter("assignmentID");
        String classID = request.getParameter("classID");
        String traineeID = request.getParameter("traineeID");
        String markParam = request.getParameter("mark");
        Double mark = null;
        String comment = request.getParameter("comment");

        String mess = null;
        if (mark == null || comment == null) {
            mess = "You have left an empty field!";
        } else if (comment.length() > 100) {
            mess = "Your input is too long!";
        } else {
            try {
                mark = Double.parseDouble(markParam);
                if (mark > 10 || mark < 0) {
                    mess = "Mark must be between 0 and 10!";
                } else {
                    dao.evaluateAssignment( mark, comment, assignmentID, classID, traineeID);
                    response.sendRedirect("assignment");
                    return; 
                }
            } catch (NumberFormatException e) {
                mess = "Mark must be a valid number!";
            }
        }

        request.setAttribute("mess", mess);
        request.getRequestDispatcher("assignment").forward(request, response);
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
