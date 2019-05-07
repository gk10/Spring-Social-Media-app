package main.java.fbClone.Repos;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepo extends CrudRepository<Friends, Integer>{
	
}
