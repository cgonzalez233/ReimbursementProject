import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServletCRE extends HttpServlet {
    UserDao userdao = UserDaoFactory.getUserDao();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String currentUser = (String)session.getAttribute("_susername");
        Reimbursement reimbursement = new Reimbursement();

        //Fill reimbursement to be passed
        reimbursement.setReason(request.getParameter("_reason"));
        reimbursement.setStatus("Pending");
        double amount = Double.parseDouble(request.getParameter("_amount"));
        reimbursement.setAmount(amount);
        reimbursement.setRequester(currentUser);
        String supportingdoc = "jimmy";
        reimbursement.setSupportingDocuments(supportingdoc);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        reimbursement.setDate(dtf.format(now));
        byte[] filebites = request.getParameter("_document").getBytes(StandardCharsets.UTF_8);
        File file = new File("ReimbursementProject/src/main/submitedDocuments/");
        FileUtils.writeByteArrayToFile(file,filebites);
        //Push to database
        userdao.createReimbursement(reimbursement);
        request.getRequestDispatcher("navbar.html").include(request, response);
        out.println("<h3>Request Submitted</h3>");
    }
}
