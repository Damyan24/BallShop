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

	    
	    @Column(name = "user_id")
	    private String user_id;

	    
	    @Column(name = "item_id")
	    private int item_id;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getUser_id() {
			return user_id;
		}


		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}


		public int getItem_id() {
			return item_id;
		}


		public void setItem_id(int item_id) {
			this.item_id = item_id;
		}
	    
	    
	   


		


		
}
