/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Admin.controller;

import dal.SubjectDAO;
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
public class AddSubjectController extends HttpServlet {

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
            out.println("<title>Servlet AddSubjectController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSubjectController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        SubjectDAO dao = new SubjectDAO();

        String mIDStr = request.getParameter("mID");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String des = request.getParameter("des");
        String image = request.getParameter("image");

        String mess = ""; //Initialize the error message as null

        // Check for empty or null fields
        if (mIDStr == null || name == null || code == null) {
            mess = "You have left an empty field!";
            // check the length subject name
        } else {
            if (name.length() > 50) {
                mess = "Your input subject name is too long!";
                // check the length and format of subject code
            } else {
                if ((code.length() != 6) && (code.length() != 7) && (!code.matches("[A-Z]{3}\\d{3}[a-zA-Z]*"))) {
                    mess = "Subject code is not valid!";
                    // check if subject code is fomatted right
                } else if ((dao.getSubjectByCode(code)) != null) {
                    mess = "The subject has already existed!";
                    // if all are checked, a new subject is added in the database
                } else {
                    int mID = Integer.parseInt(mIDStr);
                    dao.addSubject(mID, name, code, des, image);
                    response.sendRedirect("settingSubject");
                    return; // early exit
                }
            }

            //return the error message to the jsp form
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("addSubject.jsp?code=" + code).forward(request, response);
        }
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
