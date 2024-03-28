package Ballshop.Project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ballshop.Project.models.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
	
	Item findByItemName(String name);

	List<Item> findAll();

	
}
