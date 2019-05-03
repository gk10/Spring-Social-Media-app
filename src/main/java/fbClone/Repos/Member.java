package main.java.fbClone.Repos;

//database follows https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Member {
	@Id
	private Integer groupid;
	
	private Integer userid;

	public int getuserid() {
		return userid;
	}


	public int getgroupid() {
		return groupid;
	}
	
	public void setuid(int id) {
		this.userid = id;
	}
	
	public void setgroupid(int id) {
		this.groupid = id;
	}

}