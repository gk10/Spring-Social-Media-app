package main.java.fbClone.Repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepo extends CrudRepository<Groups, Integer>{
	@Query(value = "select name from groups", nativeQuery = true)
	ArrayList<String> groups();
	
	//select id from groups where name="Greg's group"
	
	@Query(value = "select id from groups where name=?1", nativeQuery = true)
	Integer id(String name);
	
}
