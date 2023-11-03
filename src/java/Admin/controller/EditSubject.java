package Admin.controller;

import dal.AdminDAO;
import dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

import java.util.List;
import model.Subject;
import model.SubjectSetting;
import model.User;

@WebServlet(name = "EditSubject", urlPatterns = {"/editsubject"})
public class EditSubject extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String code = request.getParameter("scode");
        String name = request.getParameter("sname");
        String mid = request.getParameter("mid");
        String description = request.getParameter("description");
        String action = request.getParameter("on");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        ManagerDAO Sdao = new ManagerDAO();
        AdminDAO dao = new AdminDAO();

        boolean status = "on".equals(action); // Kiểm tra nếu action là "on" thì isChecked là true, ngược lại là false

        try {
            Date uDate = new Date();
            int uid = u.getUserId();
            int id = Integer.parseInt(sid);
            int managerid = Integer.parseInt(mid);
            Timestamp timestamp = new Timestamp(uDate.getTime());
            Subject scheck = dao.checkSubjectCode(code, id);
            if (scheck == null) {
                Subject s = new Subject(id, managerid, name, code, description, status, timestamp, uid);
                System.out.println(id +" " +managerid +" " + name+" " + code+" " + description+" " + status+" " + timestamp+" " + uid);
                dao.editSubject(s);
                List<SubjectSetting> listC = Sdao.getChapterbySubject(id);
                List<SubjectSetting> listD = Sdao.getDimensionbySubject(id);
                Subject ss = dao.getSubjectbyId(id);
                List<User> listSM = dao.getAllSubManager();
                request.setAttribute("successMessage", "Edit success");
                request.setAttribute("listSM", listSM);
                request.setAttribute("detail", ss);
                request.setAttribute("listC", listC);
                request.setAttribute("listD", listD);
                request.getRequestDispatcher("subjectDetail.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Already exist");
                List<SubjectSetting> listC = Sdao.getChapterbySubject(id);
                List<SubjectSetting> listD = Sdao.getDimensionbySubject(id);
                Subject s = dao.getSubjectbyId(id);
                List<User> listSM = dao.getAllSubManager();
                request.setAttribute("listSM", listSM);
                request.setAttribute("detail", s);
                request.setAttribute("listC", listC);
                request.setAttribute("listD", listD);
                request.getRequestDispatcher("subjectDetail.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace(); // Xử lý nếu có lỗi chuyển đổi
        }

    }
}
