package Ballshop.Project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Ballshop.Project.models.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
	
	Item findByItemName(String name);
	
	@Query("SELECT i FROM Item i WHERE i.id = :id")
	Item findById(@Param("id")int id);

	List<Item> findAll();

	
}
