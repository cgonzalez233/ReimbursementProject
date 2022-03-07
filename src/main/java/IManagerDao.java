import java.util.List;

public interface IManagerDao {

    public Manager mLogin();
    public void mLogout();

    public void approve(int id);
    public void deny(int id);
    public List<Reimbursement> allPending();
    public List<Reimbursement> allResolved();
    public Reimbursement getByEmp(Employee emp);
    public List<Employee> allEmp();

}
