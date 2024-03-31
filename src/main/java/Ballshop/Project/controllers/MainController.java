package Ballshop.Project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Ballshop.Project.models.BasketItem;
import Ballshop.Project.models.Item;
import Ballshop.Project.models.User;
import Ballshop.Project.services.BasketItemService;
import Ballshop.Project.services.ItemService;
import Ballshop.Project.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping()
public class MainController {
  
    @Autowired
    ItemService itemService;
    @Autowired
    UserService userService;
    @Autowired
    BasketItemService BIS;
    
    final static Logger logger = LoggerFactory.getLogger(MainController.class);
    
    @GetMapping("/")
    public String index(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        
        Cookie[] cookies = request.getCookies();
        
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        
        boolean cookieExists = false;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_id")) {
                    cookieExists = true;
                    User existingUser = userService.findBySession(cookie.getValue());
                    int itemCount = BIS.findAllByUserId(existingUser.getSessionId()).size();
                    model.addAttribute("itemCount",itemCount);
                    model.addAttribute("user", existingUser);
                    break;
                }
            }
        }

        if (!cookieExists) {
        	User user = new User();
        	String session_id = session.getId();
            user.setSessionId(session_id);
            userService.saveUser(user);
            Cookie newCookie = new Cookie("session_id", user.getSessionId());
            newCookie.setMaxAge(7*24*60*60);
            newCookie.setPath("/"); 
            response.addCookie(newCookie);
            model.addAttribute("itemCount",0);
            logger.warn("The size of the item array is " + BIS.findAllByUserId(session_id).size());
            model.addAttribute("user",user);
        }

        return "index";
    }
    
    
    
    
    @GetMapping("/basket")
    public String basket(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
    	
    	for (Cookie c : request.getCookies()) {
    	    if (c.getName().equals("session_id")) {
    	        User user = userService.findBySession(c.getValue());
    	        List<BasketItem> bi = BIS.findAllByUserId(user.getSessionId());
    	        List<Item> items = new ArrayList<>();
    	        for (BasketItem b : bi) {
    	            Item item = itemService.findById(b.getItem_id());
    	            if (item != null) {
    	                items.add(item);
    	            }
    	        }
    	        model.addAttribute("user", user);
    	        if (!items.isEmpty()) {
    	            model.addAttribute("itemList", items);
    	        } else {
    	            model.addAttribute("emptyBasket", true);
    	        }
    	    }
    	}
    	return "basket";

    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
