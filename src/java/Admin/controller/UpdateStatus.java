package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;


@WebServlet(name = "UpdateStatus", urlPatterns = {"/updateStatus"})
public class UpdateStatus extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("id");
        String action = request.getParameter("status");
        int id = Integer.parseInt(sid);
        boolean status = "true".equals(action); // Chuyển đổi từ kiểu String sang boolean
        System.out.println(sid);
        System.out.println(status);
        AdminDAO dao = new AdminDAO();
        try {
            dao.updateSatus(id, status); // Gọi hàm updateStatus với tham số boolean status
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Xử lý nếu có lỗi chuyển đổi
        }
        response.sendRedirect("settingSubject");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
