package Ballshop.Project.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user" , schema="ballshop")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(name = "session_id")
        private String  sessionId;
        
        
        @OneToMany(mappedBy = "user")
        private List<BasketItem> basket;

  

    public int getId() {
        return id;
    }



	public String getSessionId() {
		return sessionId;
	}



	public List<BasketItem> getBasket() {
		 if (this.basket == null) {
		        this.basket = new ArrayList<>();
		    }
		    return this.basket;
	}



	public void setBasket(List<BasketItem> basket) {
		this.basket = basket;
	}



	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	

   
}
