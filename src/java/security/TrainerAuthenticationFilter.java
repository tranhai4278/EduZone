package security;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

public class TrainerAuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            // User is logged in, check their RoleId
            User user = (User) session.getAttribute("user");
            if (user.getRoleId() == 1 || user.getRoleId() == 3) {
                // User is a trainer, allow access to the requested trainer resource
                chain.doFilter(request, response);
            } else {
                // User is not a trainer, redirect to the 404 error page
                request.getRequestDispatcher("error-404.jsp").forward(request, response); // Sends a 404 error
            }
        } else {
            // User is not logged in, redirect to the login page
            httpResponse.sendRedirect("login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
