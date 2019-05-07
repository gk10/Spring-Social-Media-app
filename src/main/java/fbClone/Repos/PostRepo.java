package main.java.fbClone.Repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepo extends CrudRepository<Posts, Integer>{
	@Query(value = "select name, post from posts", nativeQuery = true)
	ArrayList<PostService> recentPosts();
	
	@Query(value = "select name, post from posts where post like %:search%", nativeQuery = true)
	ArrayList<PostService> recentSearch(String search);
	
	@Query(value = "select name, post from posts where name= ?1", nativeQuery = true)
	ArrayList<PostService> userSearch(String search);
	
	@Query(value = "select posts.id, name, post, media, likes from posts join users on posts.name = users.username join friends on users.id = friends.friendid where userid = ?1", nativeQuery = true)
	ArrayList<PostService> friendPosts(Integer search);
	
	@Query(value = "select name, post from posts join users on posts.name = users.username join friends on users.id = friends.userid where userid = ?1", nativeQuery = true)
	ArrayList<PostService> myPosts(Integer search);
	
	@Query(value = "select posts.id, name, post, media, likes from posts join users on posts.name = users.username join member on users.id=member.userid where member.groupid = ?1", nativeQuery = true)
	ArrayList<PostService> groupPosts(Integer search);
	
	@Transactional
	@Modifying
	@Query(value = "update posts set posts.likes = posts.likes+1 where posts.id=?1", nativeQuery = true)
	void like(Integer postID);
	
	//update posts set likes = likes+1 where id = 3
	
	
}
