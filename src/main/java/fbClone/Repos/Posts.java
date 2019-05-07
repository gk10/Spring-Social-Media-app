package main.java.fbClone.Repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
@Entity 
public class Posts {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    
    private String post;
    
    private String media;

    
    private Integer groupLocal;
    private Integer userLocal;
    
    private Integer likes =0;

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLikes(Integer like) {
		this.likes = id;
	}
	
	public int getLikes() {
		return likes;
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
	
	public void setMedia(String media) {
		this.media = media;
	}
	
	public String getMedia() {
		return media;
	}

}
