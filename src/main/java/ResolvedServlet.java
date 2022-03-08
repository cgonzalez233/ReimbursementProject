import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ResolvedServlet extends HttpServlet {
    IManagerDao managerdao = ManagerDaoFactory.getManagerDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("navbar.html").include(request, response);
        out.println("<table><tr><th>RequestID | </th>"+
                "<th>Requester | </th>"+
                "<th>Date | </th><th>Reason | </th>"+
                "<th>Amount | </th><th>Document | </th><th>Status</th></tr>");
        List<Reimbursement> reimbursements = managerdao.allResolved();
        for (Reimbursement re: reimbursements) {
            out.println("<tr><td>"+re.getId()+"</td><td>"+
                    re.getRequester() + "</td><td>" +
                    re.getDate() + "</td><td>"
                    + re.getReason() + "</td><td>"
                    + re.getAmount() + "</td><td><a href=\""
                    + re.getSupportingDocuments() + "\">Image</a></td><td>"
                    + re.getStatus() + "</td></tr>"
            );
        }
        out.println("</table>");
        out.println("<a href=\"managerPage.html\">Home</a>");
    }
}
