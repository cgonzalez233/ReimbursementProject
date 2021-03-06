package UserDao;

import java.util.List;

public interface UserDao {
    void createReimbursement(Reimbursement newReimbursement);
    List<Reimbursement> getReimbursement(String name);
    Reimbursement getReimbursementById(int id);
    List<Reimbursement> getAllReimbursement();
    //This is for testing purposes only delete when finished
    User viewProfile(String username);
    User Login(String username, String password);
    void updateProfile(User user);

}

