package main.java.fbClone.Repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends CrudRepository<Users, Integer>{
	@Query(value = "select id from users where username=?1", nativeQuery = true)
	Integer recentSearch(String name);
	
	@Query(value = "select username from users", nativeQuery = true)
	ArrayList<String> users();
	
	@Query(value = "select username from users join friends on users.id = friends.friendid where userid = ?1", nativeQuery = true)
	ArrayList<String> friends(int userid);
	
	//select id from users left outer join friends on users.id =friends.userid where friends.userid<3 or friends.userid>3
	
	@Query(value = "select username from users left outer join friends on users.id =friends.userid where friends.userid<?1 or friends.userid>?1", nativeQuery = true)
	ArrayList<String> others(int userid);
}
