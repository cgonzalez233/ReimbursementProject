import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    private String type;

    public User(){}
    public User(String name, String email, String username, String password, String type){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getType(){return type;}
    public void setType(String type){this.type = type;}
}
