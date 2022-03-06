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

public class ServletELN extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Employee employee = new Employee();
        employee.setUsername((request.getParameter("_username")));
        employee.setPassword(request.getParameter("_password"));

        out.println(employee.getUsername() + employee.getPassword());

        // create a configuration object
        Configuration config = new Configuration();
        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create Session factory
        SessionFactory factory = config.buildSessionFactory();
        // ope the session
        Session session = factory.openSession();
        // begin transaction
        Transaction t = session.beginTransaction() ;
        // Perform Query
        List<Employee> employees = session.createQuery("from Reimbursement where requester=" + employee.getUsername(),Employee.class).list();
        t.commit();

    }
}
