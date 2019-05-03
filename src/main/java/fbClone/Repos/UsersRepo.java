package main.java.fbClone.Repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends CrudRepository<Users, Integer>{
	@Query(value = "select id from users where username like %:name%", nativeQuery = true)
	Integer recentSearch(String name);
	
	@Query(value = "select username from users", nativeQuery = true)
	ArrayList<String> users();
	
	@Query(value = "select username from users join friends on users.id = friends.friendid where userid = ?1", nativeQuery = true)
	ArrayList<String> friends(int userid);
	
}
