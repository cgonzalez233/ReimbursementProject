package ManagementServlets;

import ManagementDao.IManagerDao;
import ManagementDao.ManagerDaoFactory;
import UserDao.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class NewEmpServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        User newUser = new User();
        newUser.setName(request.getParameter("_name"));
        newUser.setEmail(request.getParameter("_email"));
        newUser.setUsername(request.getParameter("_username"));
        newUser.setPassword(request.getParameter("_password"));
        Boolean type = Boolean.parseBoolean(request.getParameter("_type"));
        newUser.setType(type);

        IManagerDao mdao = ManagerDaoFactory.getManagerDao();

        mdao.createUser(newUser);
        out.println("<p>User "+ newUser.getName() +"has been added to the system</p>");
        request.getRequestDispatcher("managerNav.html").include(request, response);
    }
}
