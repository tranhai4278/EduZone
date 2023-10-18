package Admin.controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

<<<<<<< HEAD
/**
 *
 * @author PHAM NGOC
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");

        UserDAO dao = new UserDAO();
        User u = dao.getUserByEmail(email);

        request.setAttribute("user", u);
        request.getRequestDispatcher("userDetail.jsp").forward(request, response);
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
>>>>>>> b93dfa3f040004c9bdc3230f24768151b50aa7f7
}
