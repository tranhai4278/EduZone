package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import model.Setting;
import model.User;

@WebServlet(name = "AddSetting", urlPatterns = {"/addsetting"})
public class AddSetting extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        }
    }
}
