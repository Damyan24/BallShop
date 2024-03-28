package Ballshop.Project.models;


import jakarta.persistence.*;

@Entity
@Table(name = "item" , schema="ballshop")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="item_name")
    private String itemName;

    @Column(name = "item_price")
    private Double itemPrice;


    

    @Column(name = "image_identifier")
    private String imageIdentifier;
    
   
    public int getId() {
        return id;
    }








	public void setId(int id) {
		this.id = id;
	}



	public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

  

    public String getImageIdentifier() {
        return imageIdentifier;
    }

    public void setImageIdentifier(String imageIdentifier) {
        this.imageIdentifier = imageIdentifier;
    }
}