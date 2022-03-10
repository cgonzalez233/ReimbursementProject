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

        IManagerDao mdao = ManagerDaoFactory.getManagerDao();
        String stringI = "";
        for (int comb = 0; comb != EmpReqServlet.i; comb++){
            stringI = Integer.toString(comb);
            mdao.updateRequest(request.getParameter("approveDeny"+stringI),EmpReqServlet.idList[comb]);
        }
        out.println("<p>All selected reimbursement request resolved</p>");
        request.getRequestDispatcher("managerNav.html").include(request, response);
    }

}
