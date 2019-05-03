package main.java.fbClone.Repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends CrudRepository<Member, Integer>{
	@Query(value = "select name from groups", nativeQuery = true)
	ArrayList<String> groups();
	
}
