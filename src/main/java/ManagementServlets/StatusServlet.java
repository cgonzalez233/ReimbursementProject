package ManagementServlets;

import ManagementDao.IManagerDao;
import ManagementDao.ManagerDaoFactory;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class StatusServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        IManagerDao managerdao = ManagerDaoFactory.getManagerDao();

        String reqStr = request.getParameter("a");
        int reqId = Integer.parseInt(reqStr);

        if (request.getParameter("button1") != null) {
            out.println("<h1>Approve " + reqId + "</h1>");
            managerdao.approve(reqId);
        } else if (request.getParameter("button2") != null){
            managerdao.deny(reqId);
            out.println("<h1> Deny " + reqId + "</h1>");
        }
    }

}
