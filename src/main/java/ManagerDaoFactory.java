import java.util.List;

public class ManagerDaoFactory implements IManagerDao{


    @Override
    public Manager mLogin() {
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
    public Reimbursement getByEmp(Employee emp) {
        return null;
    }

    @Override
    public List<Employee> allEmp() {
        return null;
    }
}
