package Ballshop.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ballshop.Project.models.Item;
import Ballshop.Project.repositories.ItemRepo;
import jakarta.transaction.Transactional;

@Service
public class ItemService {

	@Autowired
	private ItemRepo itemrepo;
	
	@Transactional
	  public void updateStock(int itemId, int numberOfItems) {
	      
		  Optional<Item> opt = itemrepo.findById(itemId);
		  
		  Item item = opt.get();
		  
		  
		  
		  if(item.getStock() >= numberOfItems) {
			  itemrepo.updateStock(itemId, numberOfItems);
		  }
		  
	}
		  
		  
		  public Optional<Item> findById(int ItemId) {
			  
			  return itemrepo.findById(ItemId);
		  }
		  

	        
	    
	
	  public Item findByName(String name) {
		  return itemrepo.findByItemName(name);
	  }


	  public List<Item> findAll() {
	        return itemrepo.findAll();
	    }
	
	
}

