import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletCRE extends HttpServlet {
    EmployeeDao edao = EmployeeDaoFactory.getEmployeeDao();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setReason(request.getParameter("_reason"));
        reimbursement.setStatus("Pending");
        double amount = Double.parseDouble(request.getParameter("_amount"));
        reimbursement.setAmount(amount);
        reimbursement.setRequester("jim");
        File supportingdoc = new File(request.getParameter("_document"));
        reimbursement.setSupportingDocuments(supportingdoc);
        edao.createReimbursement(reimbursement);
        request.getRequestDispatcher("index.html").include(request, response);
        out.println("<h3>Request Submitted</h3>");


    }
}
