package ManagementServlets;

import ManagementDao.IManagerDao;
import ManagementDao.ManagerDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class StatusServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<head><link rel=\"stylesheet\" href=\"style.css\"></head>\n");

        IManagerDao managerdao = ManagerDaoFactory.getManagerDao();

        String reqStr = request.getParameter("a");
        int reqId = Integer.parseInt(reqStr);

        if (request.getParameter("button1") != null) {
            managerdao.approve(reqId);
            request.getRequestDispatcher("managerPage.html").include(request, response);
            out.println("<h3>Request Approved</h3>");
        } else if (request.getParameter("button2") != null){
            managerdao.deny(reqId);
            request.getRequestDispatcher("managerPage.html").include(request, response);
            out.println("<h3>Request Denied</h3>");
        }
    }

}