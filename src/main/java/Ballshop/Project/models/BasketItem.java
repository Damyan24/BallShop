package Ballshop.Project.models;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "basketitems", schema = "ballshop")
public class BasketItem {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "item_id")
	    private Item item;
	    
	    
	   


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Item getItem() {
			return item;
		}


		public void setItem(Item item) {
			this.item = item;
		}


		
}
