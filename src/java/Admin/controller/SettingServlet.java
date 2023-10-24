package Admin.controller;

import dal.AdminDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Setting;

@WebServlet(name = "SettingServlet", urlPatterns = {"/setting"})
public class SettingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO d = new AdminDAO();
        int totalPage = d.totalPage();
        List<Setting> listR = d.searchAndFilterSettings("", -1, -1, null, 1);
        request.setAttribute("listR", listR);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageNo", 0);
        request.getRequestDispatcher("setting.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        String action = request.getParameter("status");
        int status = Integer.parseInt(action);
        String group = request.getParameter("type");
        int type = Integer.parseInt(group);
        String order = request.getParameter("order");
        String spage = request.getParameter("pageNo");
        int page = Integer.parseInt(spage);
        if(!search.isEmpty()|| status != -1 || type != -1 || !order.isEmpty() ){
            page =  1;
        }
        System.out.println(search+" "+status+" "+type+" "+order+" "+page);
        AdminDAO d = new AdminDAO();
        List<Setting> listR = d.searchAndFilterSettings(search, status, type, order, page);
        request.setAttribute("search", search);
        request.setAttribute("status", status);
        request.setAttribute("type", type);
        request.setAttribute("order", order);
        request.setAttribute("pageNo", page);
        request.setAttribute("totalPage", d.totalPageSetting(search, status, type, order));
        request.setAttribute("listR", listR);
        request.getRequestDispatcher("setting.jsp").forward(request, response);

    }
}
