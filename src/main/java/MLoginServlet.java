import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class MLoginServlet extends HttpServlet {

    IManagerDao managerDao = ManagerDaoFactory.getManagerDao();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        User manager;
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

        manager = managerDao.mLogin(uname, pass);

        if (manager == null){
            out.println("<p style=\"color: red\">You're Not a Manager</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else {
            HttpSession session = request.getSession(true);
            session.setAttribute("_susername",manager.getUsername());

            request.getRequestDispatcher("navbar.html").include(request, response);
            out.println("<h1>Welcome "+ manager.getName() +"</h1>");
            request.getRequestDispatcher("managerPage.html").include(request, response);
        }
    }

}
