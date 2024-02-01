package Ballshop.Project.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import Ballshop.Project.models.Item;
import Ballshop.Project.services.ItemService;

@Controller
@RequestMapping()
public class MainController { 
  
	@Autowired
	ItemService itemService;
	
	 final static Logger logger = LoggerFactory.getLogger(MainController.class);
	
 
	  @GetMapping("/")
	    public String index(Model model) {
	        
	        List<Item> items = itemService.findAll();
	       
	        model.addAttribute("items", items);
	        
	        

	        
	        

	        return "index";
	    }
	 
	 
  
}