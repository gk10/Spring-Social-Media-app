package main.java.fbClone.Repos;

//database follows https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer userid;
	
	private Integer friendid;

	public int getuserid() {
		return userid;
	}
	
	public int getFriend() {
		return friendid;
	}


	public void setUser(int i) {
		this.userid = i;
	}
	
	public void setFriend(int i) {
		this.friendid = i;
	}
	
	public int getID() {
		return this.id;
	}

}

/*
package main.java.fbClone.Repos;

//database follows https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Groups {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer userid;
	
	private Integer friendid;

	public int getuserid() {
		return userid;
	}
	
	public int getFriend() {
		return friendid;
	}


	public void setUser(int i) {
		this.userid = i;
	}
	
	public void setFriend(int i) {
		this.friendid = i;
	}
	
	public int getID() {
		return this.id;
	}

}
*/