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

@WebServlet(name = "EditSetting", urlPatterns = {"/editsetting"})
public class EditSetting extends HttpServlet {

    private String errorMessage = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("sid");
        String gid = request.getParameter("gid");
        int group = Integer.parseInt(gid);
        int setting = Integer.parseInt(sid);
        AdminDAO dao = new AdminDAO();
        Setting s = dao.getSetting(group, setting);
        request.setAttribute("detail", s);
        request.getRequestDispatcher("edit-setting.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid = request.getParameter("id");
        String name = request.getParameter("sname");
        String sorder = request.getParameter("order");
        String action = request.getParameter("on");
        String note = request.getParameter("note");
        String groupid = request.getParameter("gid");
        boolean status = "on".equals(action);
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        int gid = Integer.parseInt(groupid);
        int id = Integer.parseInt(sid);
        int order = Integer.parseInt(sorder);
        AdminDAO dao = new AdminDAO();
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        Setting scheck = dao.checkSettingName(name, id);
        if (scheck == null) {
            Setting s = new Setting(id, gid, name, status, order, note, timestamp, uid);
            dao.editSetting(s);
            response.sendRedirect("setting");
        } else {
            request.setAttribute("error", "Already exist");
            Setting s = dao.getSetting(gid, id);
            request.setAttribute("detail", s);
            request.getRequestDispatcher("edit-setting.jsp").forward(request, response);
        }

    }
}
