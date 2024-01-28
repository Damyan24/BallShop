package Ballshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ballshop.models.Item;
import Ballshop.repositories.ItemRepo;
import jakarta.transaction.Transactional;


@Service
public class ItemService {

	@Autowired
	private ItemRepo itemrepo;
	
	@Transactional
	  public void updateStock(int itemId, int numberOfItems) {
	      
		  Item item = itemrepo.getReferenceById(itemId);
		  
		  
		  if(item.getStock() >= numberOfItems) {
			  itemrepo.updateStock(itemId, numberOfItems);
		  }
		  
	}
		  
		  
		  public Item findById(int ItemId) {
			  
			  return itemrepo.getReferenceById(ItemId);
		  }
		  

	        
	    
	
	  public Item findByName(String name) {
		  return itemrepo.findByItemName(name);
	  }
	
	
}

