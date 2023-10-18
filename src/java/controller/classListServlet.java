/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ClassDAO;
import dal.SubjectDAO;
import dal.UserDAO;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.User;
import model.Class;
import model.Subject;

/**
 *
 * @author Admin
 */
public class classListServlet extends HttpServlet {

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
            out.println("<title>Servlet classListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classListServlet at " + request.getContextPath() + "</h1>");
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
        ClassDAO classDAO = new ClassDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        UserDAO userDAO = new UserDAO();
        ArrayList<Class> c = classDAO.getAllClass();
        ArrayList<Subject> s = subjectDAO.getSubjectsByManagerId(user.getUserId());
        ArrayList<User> u = userDAO.getAllUser();
        System.out.println("Number of classes retrieved: " + c.size());

        request.setAttribute("users", u);
        request.setAttribute("subjects", s);
        request.setAttribute("classes", c);
        request.getRequestDispatcher("classlist.jsp").forward(request, response);

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("activate".equals(action) || "deactivate".equals(action)) {
            String[] selectedClassIds = request.getParameterValues("selectedClasses");
            if (selectedClassIds != null) {
                List<Integer> classIds = new ArrayList<>();
                for (String classId : selectedClassIds) {
                    classIds.add(Integer.parseInt(classId));
                }
                if ("activate".equals(action)) {
                    activateClasses(classIds);
                } else if ("deactivate".equals(action)) {
                    deactivateClasses(classIds);
                }
            }

            // Redirect back to the class list page or perform any other necessary actions.
        } else if ("other_action".equals(action)) {
            // Handle other actions here
        }

        response.sendRedirect(request.getContextPath() + "/classlist");
    }

    private void activateClasses(List<Integer> classIds) {
        ClassDAO classDAO = new ClassDAO();
        for (Integer classId : classIds) {
            classDAO.activateClassByID(classId);
        }
    }

    private void deactivateClasses(List<Integer> classIds) {
        ClassDAO classDAO = new ClassDAO();
        for (Integer classId : classIds) {
            classDAO.deactivateClassByID(classId);
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
