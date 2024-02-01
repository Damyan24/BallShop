package Ballshop.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Ballshop.Project.models.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
