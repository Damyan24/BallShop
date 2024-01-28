package Ballshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Ballshop.services.ItemService;


@Controller
public class MainController {

	@Autowired
	ItemService itemservice;
	
	
	@GetMapping("/")
	public String index(Model model){
		
		for(int i = 1 ; i <= 4; i++) {
			model.addAttribute("item" + i, itemservice.findById(i));
		}
		
		
		return "index";
	}
}
