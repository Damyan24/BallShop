package Ballshop.models;


import jakarta.persistence.*;

@Entity
@Table(name = "item" , schema="ballshop")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="item_name")
    private String itemName;

    @Column(name = "item_price")
    private Double itemPrice;


    @Column(name="user_id")
    private int userId;

    @Column(name = "image_identifier")
    private String imageIdentifier;
    
    @Column(name = "quantity")
    private int stock;

    public int getId() {
        return id;
    }



    public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageIdentifier() {
        return imageIdentifier;
    }

    public void setImageIdentifier(String imageIdentifier) {
        this.imageIdentifier = imageIdentifier;
    }
}
