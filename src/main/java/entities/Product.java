package entities;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String designation;
	private double price;
	private long quantity;
	
	public Product() {};
	
	public Product(String designation, double price, long quantity) {
		this.designation=designation;
		this.price=price;
		this.quantity=quantity;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", designation=" + designation + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	

}
