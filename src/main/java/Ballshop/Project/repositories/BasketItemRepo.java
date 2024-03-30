package Ballshop.Project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Ballshop.Project.models.BasketItem;
import Ballshop.Project.models.Item;
import Ballshop.Project.models.User;


@Repository
public interface BasketItemRepo extends JpaRepository<BasketItem,Integer> {

	@Query("SELECT bi FROM BasketItem bi WHERE bi.user_id = :user and bi.item_id = :item")
	BasketItem findByUserAndItem(@Param("user")String user, @Param("item")int item);
	
	
	@Query("SELECT bi FROM BasketItem bi WHERE bi.user_id = :user_id")
	List<BasketItem> findAllByUserId(@Param("user_id") String user_id);

	
	
	
}
