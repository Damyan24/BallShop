package Ballshop.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Ballshop.Project.models.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	
	
	@Query("SELECT u FROM User u WHERE u.sessionId = :ses_id")
	User findBySessionId(@Param("ses_id")String sessionId);

	
	
	
}
