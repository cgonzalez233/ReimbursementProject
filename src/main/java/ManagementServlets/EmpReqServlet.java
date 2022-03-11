package ManagementServlets;

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

public class EmpReqServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<head><link rel=\"stylesheet\" href=\"style.css\"></head>\n");

        request.getRequestDispatcher("managerNav.html").include(request, response);

        String name = request.getParameter("empName");

        out.println("<div class=\"tableDiv\"><h3>"+ name +"</h3><table border=1px>\n" +
                "        <tr class=\"tableHead\">\n" +
                "            <th>Id</th>\n" +
                "            <th>Amount</th>\n" +
                "            <th>Date</th>\n" +
                "            <th>Reason</th>\n" +
                "            <th>Requester</th>\n" +
                "            <th>Status</th>\n" +
                "            <th>Approve/Deny</th>\n" +
                "        </tr>\n");

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        UserDao userdao = UserDaoFactory.getUserDao();
        List<Reimbursement> reqList = userdao.getReimbursement(name);

        System.out.println(reqList.size());

        for (Reimbursement req : reqList) {

            out.println("<tr><td>" + req.getId() + "</td>");
            out.println("<td>" + req.getAmount() + "</td>");
            out.println("<td>" + req.getDate() + "</td>");
            out.println("<td>" + req.getReason() + "</td>");
            out.println("<td>" + req.getRequester() + "</td>");
            out.println("<td>" + req.getStatus() + "</td>");
            if(req.getStatus().equals("")){
                out.println("<td><form action=\"ManagementServlets.StatusServlet?a=" + req.getId() + "\" method=\"post\">");
                out.println("    <input type=\"submit\" name=\"button1\" value=\"Approve\" />" +
                        "    <input type=\"submit\" name=\"button2\" value=\"Deny\" /></form></td>");
            }


        }

        out.println("</table></div>");
        t.commit();


    }

}