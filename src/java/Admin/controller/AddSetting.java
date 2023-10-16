package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import model.Setting;
import model.User;

@WebServlet(name = "AddSetting", urlPatterns = {"/addsetting"})
public class AddSetting extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gid = request.getParameter("gid");
        int group = Integer.parseInt(gid);
        request.setAttribute("gid", group);
        request.getRequestDispatcher("add-setting.jsp").forward(request, response);
    }

    private String errorMessage = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (errorMessage != null) {
            // Truyền thông báo lỗi vào thuộc tính "error" trong request
            request.setAttribute("error", errorMessage);
            // Xóa giá trị errorMessage để tránh lặp lại khi doGet được gọi lại
            errorMessage = null;
        }
        String gid = request.getParameter("gid");
        int group = Integer.parseInt(gid);
        request.setAttribute("gid", group);
        request.getRequestDispatcher("add-setting.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gid = request.getParameter("gid");
        String name = request.getParameter("sname");
        String note = request.getParameter("note");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int group = Integer.parseInt(gid);
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());

        AdminDAO dao = new AdminDAO();
        Setting scheck = dao.checkSettingNameinGroup(name, group);
        if (scheck == null) {
            Setting s = new Setting(group, name, true, 0, note, timestamp, uid, timestamp, uid);
            dao.addSetting(s);
            response.sendRedirect("setting");
        } else {
            errorMessage = "Already exist";
            doGet(request, response);
        }

    }
}
