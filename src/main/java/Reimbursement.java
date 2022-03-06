import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.File;

@Entity
public class Reimbursement {


    @Id@GeneratedValue
    private int id;
    private String requester;
    private double amount;
    private String reason;
    private String status;
    private File supportingDocuments;

    public Reimbursement(){}
    public Reimbursement(double amount, String reason, File supportingDocuments){
        this.amount = amount;
        this.reason = reason;
        this.supportingDocuments = supportingDocuments;
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public double getAmount() {return amount;}
    public void setAmount(double amount){this.amount = amount;}

    public String getRequester(){return requester;}
    public void setRequester(String requester) {this.requester = requester;}

    public String getReason(){return reason;}
    public void setReason(String reason) {this.reason = reason;}

    public String getStatus(){return status;}
    public void setStatus(String status) {this.status = status;}

    public File getSupportingDocuments() {return supportingDocuments;}
    public void setSupportingDocuments(File supportingDocuments) {this.supportingDocuments = supportingDocuments;}
}
