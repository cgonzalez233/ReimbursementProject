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

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class EmpReqServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("managerNav.html").include(request, response);

        String name = request.getParameter("empName");

        out.println("<div><h3>"+ name +"</h3><table border=1px>\n" +
                "        <tr>\n" +
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

        UserDao userdao = UserDaoFactory.getUserDao();
        IManagerDao managerdao = ManagerDaoFactory.getManagerDao();
        List<Reimbursement> reqList = userdao.getReimbursement(name);

        System.out.println(reqList.size());

        Iterator itr = reqList.iterator();
        while (itr.hasNext()) {

            Reimbursement req = (Reimbursement) itr.next();
            out.println("<tr><td>" + req.getId() + "</td>");
            out.println("<td>" + req.getAmount() + "</td>");
            out.println("<td>" + req.getDate() + "</td>");
            out.println("<td>" + req.getReason() + "</td>");
            out.println("<td>" + req.getRequester() + "</td>");
            out.println("<td>" + req.getStatus() + "</td>");
            out.println("<td><form action=\"ManagementServlets.StatusServlet?a=" + req.getId() + "\" method=\"post\">" +
                    "    <input type=\"submit\" name=\"button1\" value=\"Approve\" />" +
                    "    <input type=\"submit\" name=\"button2\" value=\"Deny\" /></form></td>");

        }

        out.println("</table></div>");
        t.commit();
        session.close();


    }

}
