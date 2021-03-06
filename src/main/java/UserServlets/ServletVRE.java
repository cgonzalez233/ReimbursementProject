package UserServlets;

import UserDao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ServletVRE extends HttpServlet {
    UserDao userdao = UserDaoFactory.getUserDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        out.println("<head><link rel=\"stylesheet\" href=\"style.css\"></head>\n");

        String currentUser = (String)session.getAttribute("_susername");
        request.getRequestDispatcher("managerNav.html").include(request, response);
        String document ="https://www.shutterstock.com/search/catfish";
        out.println("<div class=\"tableDiv\"><table border=\"1px\"><tr class=\"tableHead\"><th>RequestID</th>"+
                "<th>Date</th><th>Reason</th>"+
                "<th>Amount</th><th>Document</th><th>Status</th></tr>");
        List<Reimbursement> reimbursements = userdao.getReimbursement(currentUser);
        for (Reimbursement re: reimbursements) {
            out.println("<tr><td>"+re.getId()+"</td><td>"+
                    re.getDate() + "</td><td>"
                    + re.getReason() + "</td><td>"
                    + re.getAmount() + "</td><td><a href=\""
                    + /*re.getSupportingDocuments()*/document + "\" target=\"_blank\">Image</a></td><td>"
                    + re.getStatus() + "</td></tr>"
            );
        }
        out.println("</table></div>");
    }
}