package UserServlets;

import UserDao.User;
import UserDao.UserDao;
import UserDao.UserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletVEI extends HttpServlet {
    UserDao userdao = UserDaoFactory.getUserDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String sessionId = (String)session.getAttribute("_susername");
        User user = userdao.viewProfile(sessionId);
        String type;
        if(user.getType() == 1){
            request.getRequestDispatcher("managerNav.html").include(request, response);
            type = "Manager";
        }
        else{
            request.getRequestDispatcher("navbar.html").include(request, response);
            type = "Employee";
        }
        out.println("<div><p>name: " + user.getName()+ "</p>" +
                "<p>username: " + user.getUsername()+ "</p>" +
                "<p>email: " + user.getEmail()+ "</p>" +
                "<p>password: " + user.getPassword()+ "</p>" +
                "<p>Status: " + type+ "</p> " +
                " <a href=\"updateUser.html\">Update information</a></div>");

    }
}
