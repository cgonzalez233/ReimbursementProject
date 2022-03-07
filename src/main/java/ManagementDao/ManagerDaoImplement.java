package ManagementDao;

import UserDao.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManagerDaoImplement implements IManagerDao{

    @Override
    public User mLogin(String username, String pass) {
        org.hibernate.cfg.Configuration config = new Configuration();
        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create Session factory
        SessionFactory factory = config.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin transaction
        Transaction t = session.beginTransaction() ;
        // Perform Query
        User currentUser = session.createQuery("from UserDao.User where username = \"" + username + "\" AND password = \""+pass + "\"", User.class).getSingleResult();

        System.out.println(currentUser);

        t.commit();

        if((currentUser.isType())){
            return currentUser;
        }

        return null;
    }

    @Override
    public void mLogout() {

    }

    @Override
    public void approve(int id) {

    }

    @Override
    public void deny(int id) {

    }

    @Override
    public List<Reimbursement> allPending() {
        return null;
    }

    @Override
    public List<Reimbursement> allResolved() {
        return null;
    }

    @Override
    public Reimbursement getByEmp(User user) {
        return null;
    }

    @Override
    public List<User> allEmp() {
        return null;
    }
}