package main.java.fbClone.Repos;

//database follows https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "friends")
public class Friends {
    @Id
    private int userid;

    private int friendid;
    
    public int getFriends() {
    	return friendid;
    }
    
    public int getUser() {
    	return userid;
    }
    
    public void setUser(int i) {
    	userid = i;
    }
    
    public void setFriend(int i) {
    	friendid = i;
    }
    


}