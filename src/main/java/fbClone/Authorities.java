package main.java.fbClone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity 
public class Authorities {
    @Id
    private String username;
    
    private String authority;


	public String getName() {
		return username;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setName(String name) {
		this.username = name;
	}
	
	public void setAuthority(String auth) {
		this.authority = auth;
	}

}
