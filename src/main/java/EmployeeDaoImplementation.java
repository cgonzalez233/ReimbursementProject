import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDao{


    @Override
    public void createReimbursement(Reimbursement creimbusement) {
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
        // save the object
        session.persist(creimbusement);
        // commit
        t.commit();
    }

    @Override
    public List<Reimbursement> getReimbursement(String user) {
        // create a configuration object
        Configuration config = new Configuration();
        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create Session factory
        SessionFactory factory = config.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin transaction
        Transaction t = session.beginTransaction() ;
        // Perform Query
        List<Reimbursement> reimbursements = session.createQuery("from Reimbursement where requester = \"john\"" ,Reimbursement.class).list();
        t.commit();



        return reimbursements;
    }
}
