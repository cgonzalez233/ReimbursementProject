package ManagementServlets;

import ManagementDao.IManagerDao;
import ManagementDao.ManagerDaoFactory;
import UserDao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ResolvedServlet extends HttpServlet {

    public static int i;
    public static int[] idList = new int[40];
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<head><link rel=\"stylesheet\" href=\"style.css\"></head>\n");

        request.getRequestDispatcher("managerNav.html").include(request, response);

        out.println("<div class=\"tableDiv\" style='width: fit-content; padding: 10px;'><h3>Resolved Reimbursements</h3><table border=1px>\n" +
                "        <tr class=\"tableHead\">\n" +
                "            <th>Id</th>\n" +
                "            <th>Amount</th>\n" +
                "            <th>Date</th>\n" +
                "            <th>Reason</th>\n" +
                "            <th>Requester</th>\n" +
                "            <th>Status</th>\n" +
                "        </tr>\n");

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        IManagerDao managerdao = ManagerDaoFactory.getManagerDao();
        List<Reimbursement> reqList = managerdao.allResolved();

        System.out.println(reqList.size());
        for (Reimbursement req: reqList) {
            out.println("<tr><td>" + req.getId() + "</td>");
            out.println("<td>" + req.getAmount() + "</td>");
            out.println("<td>" + req.getDate() + "</td>");
            out.println("<td>" + req.getReason() + "</td>");
            out.println("<td>" + req.getRequester() + "</td>");
            out.println("<td>" + req.getStatus() + "</td>");
        }
        out.println("</table></div>");

        t.commit();
        session.close();


    }

}