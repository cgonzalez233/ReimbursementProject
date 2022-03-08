import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Update;

import javax.management.Query;
import java.util.List;

public class UserDaoImplementation implements UserDao{

    @Override
    public void createReimbursement(Reimbursement newReimbursement) {
        // create a configuration object
        org.hibernate.cfg.Configuration config = new Configuration();
        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create Session factory
        SessionFactory factory = config.buildSessionFactory();
        // ope the session
        Session session = factory.openSession();
        // begin transaction
        Transaction t = session.beginTransaction() ;
        // save the object
        session.persist(newReimbursement);
        // commit
        t.commit();
    }

    @Override
    public List<Reimbursement> getReimbursement(String user) {
        // create a configuration object
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
        List<Reimbursement> reimbursements = session.createQuery("from Reimbursement where requester = \"" + user + "\"" ,Reimbursement.class).list();
        t.commit();

        return reimbursements;
    }

    @Override
    public User viewProfile(String username) {
        User foundUser = new User();
        // create a configuration object
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
        List<User> users = session.createQuery("from User where username = \"" + username + "\"" ,User.class).list();
        t.commit();
        foundUser.setId(users.get(0).getId());
        foundUser.setName(users.get(0).getName());
        foundUser.setEmail(users.get(0).getEmail());
        foundUser.setUsername(username);
        foundUser.setPassword(users.get(0).getPassword());
        foundUser.setType(users.get(0).isType());

        return foundUser;
    }

    @Override
    public User Login(String username, String password){
        User foundUser = new User();
        // create a configuration object
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
        List<User> users = session.createQuery("from User where username = \"" + username + "\"AND password = \""+password+"\"" ,User.class).list();
        t.commit();
        try {
            foundUser.setId(users.get(0).getId());
            foundUser.setName(users.get(0).getName());
            foundUser.setEmail(users.get(0).getEmail());
            foundUser.setUsername(username);
            foundUser.setPassword(password);
            foundUser.setType(users.get(0).isType());
        }catch (Exception e){
            System.out.println("Bad Credentials");
        }


        return foundUser;
    }

    @Override
    public void updateProfile(User user) {
        // create a configuration object
        org.hibernate.cfg.Configuration config = new Configuration();
        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create Session factory
        SessionFactory factory = config.buildSessionFactory();
        // ope the session
        Session session = factory.openSession();
        // begin transaction
        Transaction t = session.beginTransaction();
        // create query
        String QHQL = "UPDATE User set name=\""+user.getName()+"\", email=\"" +user.getEmail()+
                "\", username=\"" +user.getUsername()+"\", password=\"" +user.getPassword()+"\" Where id=\"" + user.getId()+"\"";

        //create query
        session.createMutationQuery(QHQL).executeUpdate();

        // commit
        t.commit();
    }

}
