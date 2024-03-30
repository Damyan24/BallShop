package Ballshop.Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ballshop.Project.CartItemDTO;
import Ballshop.Project.models.BasketItem;
import Ballshop.Project.models.Item;
import Ballshop.Project.models.User;
import Ballshop.Project.services.BasketItemService;
import Ballshop.Project.services.ItemService;
import Ballshop.Project.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	BasketItemService BIS;
	
	@Autowired
	UserService US;
	
	@Autowired
	ItemService IS;

	@GetMapping("/getUserId")
	public String getUserId(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		Cookie sessionCookie = null;
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("session_id"))
				sessionCookie = cookie;
		}
		
		return sessionCookie.getValue();

	}
	
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody CartItemDTO cartItem) {
	    String userId = cartItem.getUserId();
	    int itemId = cartItem.getItemId();
	    
	
	    
	    BasketItem basketItem = BIS.findBasketItem(userId, itemId);
	    
	    if(basketItem == null){
	    	basketItem = new BasketItem();
	    	basketItem.setItem_id(itemId);
	    	basketItem.setUser_id(userId);
	    	BIS.addItem(userId, itemId);
	    	return "success";
	    }
	    
	    return "failure";
	    

	  
	}

	
	
}
