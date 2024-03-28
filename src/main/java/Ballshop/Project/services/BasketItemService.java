package Ballshop.Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ballshop.Project.models.BasketItem;
import Ballshop.Project.models.Item;
import Ballshop.Project.models.User;
import Ballshop.Project.repositories.BasketItemRepo;

@Service
public class BasketItemService {
	
	
	@Autowired
	BasketItemRepo basketitemrepo;
	
	
	public BasketItem findBasketItem(Item item , User user) {
		
		return basketitemrepo.findByUserAndItem(user, item);
		
	}
	
	public void addItem(Item item , User user) {
		
		BasketItem basketItem = basketitemrepo.findByUserAndItem(user, item);
		
		if(basketItem == null) {
			basketItem = new BasketItem();
			basketItem.setItem(item);
			basketItem.setUser(user);
			
			basketitemrepo.save(basketItem);
			
		}
		
		
	}
	
	

}
