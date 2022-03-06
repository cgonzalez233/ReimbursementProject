import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ServletVRE extends HttpServlet {
    EmployeeDao edao = EmployeeDaoFactory.getEmployeeDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.html").include(request, response);
        out.println("<table><tr><th>RequestID | </th>"+
                "<th>Date | </th><th>Reason | </th>"+
                "<th>Amount | </th><th>Status</th></tr>");
        List<Reimbursement> reimbursements = edao.getReimbursement("john");
        for (Reimbursement re: reimbursements) {
            out.println("<tr><td>"+re.getId()+"</td><td>"+
                    re.getStatus() + "</td><td>"
                    + re.getReason() + "</td><td>"
                    + re.getAmount() + "</td><td>"
                    + re.getStatus() + "</td></tr>"
            );
        }
        out.println("</table>");
    }
}
