package main.java.fbClone.Repos;

//database follows https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String username;

    private String password;

    private Boolean enabled;
    
    public String getName() {
        return username;
    }
    
    public Boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(Boolean bool) {
    	this.enabled=bool;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = new BCryptPasswordEncoder().encode(pass);
    }
    


}