package main.java.fbClone.Repos;

import org.springframework.stereotype.Service;

@Service
public interface PostService {
	int getId();
	String getName();
	String getTime();
	String getPost();
	String getMedia();
	String getEverything();
	int getLikes();
}
