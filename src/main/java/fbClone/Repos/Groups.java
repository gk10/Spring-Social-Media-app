package main.java.fbClone.Repos;

//database follows https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Groups {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}

}