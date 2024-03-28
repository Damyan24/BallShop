package Ballshop.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Ballshop.Project.models.BasketItem;
import Ballshop.Project.models.Item;
import Ballshop.Project.models.User;


@Repository
public interface BasketItemRepo extends JpaRepository<BasketItem,Integer> {

	@Query("SELECT bi FROM BasketItem bi WHERE bi.user = :user and bi.item = :item")
	BasketItem findByUserAndItem(@Param("user")User user, @Param("item")Item item);
	
	
	
	
}
