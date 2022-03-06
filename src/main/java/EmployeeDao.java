import java.util.List;

public interface EmployeeDao {
void createReimbursement(Reimbursement creimbusement);
List<Reimbursement> getReimbursement(String user);
}
