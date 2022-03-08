package ManagementDao;

import UserDao.*;

import java.util.List;

public interface IManagerDao {

    public User mLogin(String username, String pass);

    public void mLogout();

    public void approve(int id);
    public void deny(int id);
    public List<Reimbursement> allPending();
    public List<Reimbursement> allResolved();
    public Reimbursement getByEmp(User user);
    public List<User> allEmp();

}