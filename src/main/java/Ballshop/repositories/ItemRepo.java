package Ballshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Ballshop.models.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
	
	Item findByItemName(String name);
	
	@Modifying
	@Query("UPDATE Item i SET i.stock = i.stock - :numberOfItems WHERE i.item_id = :itemId")
	void updateStock(@Param("itemId") int itemId, @Param("numberOfItems") int numberOfItems);
}


