package UserDao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Reimbursement {


    @Id
    @GeneratedValue
    private int id;
    private String requester;
    private String date;
    private double amount;
    private String reason;
    private String status;
    private String supportingDocuments;

    public Reimbursement(){}
    public Reimbursement(double amount, String requester,String reason, String supportingDocuments){
        this.amount = amount;
        this.requester = requester;
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

    public String getSupportingDocuments() {return supportingDocuments;}
    public void setSupportingDocuments(String supportingDocuments) {this.supportingDocuments = supportingDocuments;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
}
