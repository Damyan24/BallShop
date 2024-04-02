package Ballshop.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ballshop.Project.models.BasketItem;
import Ballshop.Project.models.Item;
import Ballshop.Project.models.User;
import Ballshop.Project.repositories.BasketItemRepo;
import jakarta.transaction.Transactional;

@Service
public class BasketItemService {
	
	
	@Autowired
	BasketItemRepo basketitemrepo;
	
	
	public BasketItem findBasketItem(String user_id , int item_id) {
		
		return basketitemrepo.findByUserAndItem(user_id, item_id);
		
	}
	
	public List<BasketItem> findAllByUserId(String user_id){
		return basketitemrepo.findAllByUserId(user_id);
	}
	
	
	@Transactional
	public void addItem(String user_id , int item_id) {
		
		BasketItem basketItem =  new BasketItem();
			basketItem.setUser_id(user_id);
			basketItem.setItem_id(item_id);
			
			basketitemrepo.save(basketItem);
			
			
		
		
	}
	
	
	@Transactional
	public void deleteItem(BasketItem item) {
		basketitemrepo.delete(item);
	}
	
	@Transactional
	public void deleteAll(String userId) {
	
		List<BasketItem> items = basketitemrepo.findAllByUserId(userId);
		
		for(BasketItem b : items) {
			basketitemrepo.delete(b);
		}
	

}
}