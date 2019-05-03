package main.java.fbClone.Repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity 
public class Posts {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    
    private String post;

    
    private Integer groupLocal;
    private Integer userLocal;

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setGroup(Integer id) {
		this.groupLocal = id;
	}
	
	public void setUser(Integer id) {
		this.userLocal = id;
	}
	
	public int getGroup() {
		return groupLocal;
	}
	
	public int getUserLocal() {
		return userLocal;
	}

	public String getName() {
		return name;
	}
	
	public String getPost() {
		return post;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPost(String tweet) {
		this.post = tweet;
	}

}
