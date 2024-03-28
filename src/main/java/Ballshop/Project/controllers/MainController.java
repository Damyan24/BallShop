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
                    model.addAttribute("user", existingUser);
                    break;
                }
            }
        }

        if (!cookieExists) {
        	User user = new User();
            user.setSessionId(session.getId());
            user.setBasket(new ArrayList<BasketItem>());
            userService.saveUser(user);
            Cookie newCookie = new Cookie("session_id", user.getSessionId());
            newCookie.setMaxAge(7*24*60*60);
            newCookie.setPath("/"); 
            response.addCookie(newCookie);
            
            model.addAttribute("user",user);
        }

        return "index";
    }
}
