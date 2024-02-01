package Ballshop.Project.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Ballshop.Project.models.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {
	
	Item findByItemName(String name);

	List<Item> findAll();

	@Modifying
	@Query("UPDATE Item i SET i.stock = i.stock - :numberOfItems WHERE i.id = :itemId")
	void updateStock(@Param("itemId") int itemId, @Param("numberOfItems") int numberOfItems);
}
