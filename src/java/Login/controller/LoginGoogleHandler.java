/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Login.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dal.AdminDAO;
import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Constants;
import model.Constants;
import model.Setting;
import model.User;
import model.UserGoogle;
import model.UserGoogle;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import utils.MyUtil;

/**
 *
 * @author Admin
 */
public class LoginGoogleHandler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        UserDAO udao = new UserDAO();
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogle usergg = getUserInfo(accessToken);
        System.out.println(usergg);
        String pass = "123456789";
        MyUtil util = new MyUtil();
        String md5 = util.toSHA1(pass);       //Encrypt passwords to SHA-1
        User rol = new User();
        rol.setRoleId(4);
        String[] regex = {"^[a-zA-Z0-9._%+-]+@fpt.edu.vn$", "^[a-zA-Z0-9._%+-]+@fe.edu.vn$"};
//         Invalid:         
        if (!isValidEmail(usergg.getEmail(), regex)) {
            request.setAttribute("err", "Email is invalid! Example: abc@fpt.edu.vn");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        User u = userDAO.getUserByEmail(usergg.getEmail());
        if(usergg.getEmail().equals(u.getEmail())){
            User user = userDAO.getUserByEmail(usergg.getEmail());
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }else if(u.getEmail() == null){
            Date d = new Date();
            User user1 = new User(md5, usergg.getId(), true, usergg.getPicture(), "0123456789", usergg.getEmail(), 4, true, d, 0, d, 1);
            udao.addUser(user1);
            User user = userDAO.getUserByEmail(usergg.getEmail());
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogle getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        UserGoogle googlePojo = new Gson().fromJson(response, UserGoogle.class);

        return googlePojo;
    }

    public boolean isValidEmail(String email, String[] regex) {
        for (String patternStr : regex) {
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
