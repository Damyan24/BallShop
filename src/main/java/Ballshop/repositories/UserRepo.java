package Ballshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Ballshop.models.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
