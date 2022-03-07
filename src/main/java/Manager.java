import jakarta.persistence.*;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;

    public Manager(){}
    public Manager(String fName,String lName,String email,String username,String password){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
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

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

}
