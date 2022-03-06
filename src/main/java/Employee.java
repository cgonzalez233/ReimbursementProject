import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String address;
    private String username;
    private String password;

    public Employee(){}
    public Employee(String fName,String lName,String email,String address,String username,String password){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getfName(){return fName;}
    public void setfName(String fName){this.fName = fName;}

    public String getlName(){return lName;}
    public void setlName(String lName){this.lName = lName;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

}
