package Ballshop.Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ballshop.Project.models.User;
import Ballshop.Project.repositories.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo ;
	
	
	public User findBySession(String sessionId) {
		
		return userRepo.findBySessionId(sessionId);	
		}
	@Transactional
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	
}
