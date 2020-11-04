package com.ust.springangularint.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	
	int size;
	String color;
	String seller;
	public Date expiryDate;
	
	@ManyToOne
	Product product;
	
	
	
	

	public ProductDetails(int id, int size, String color, String seller, Product product) {
		super();
		this.id = id;
		this.size = size;
		this.color = color;
		this.seller = seller;
		this.product = product;
	}
	public ProductDetails(int id, int size, String color, String seller) {
		super();
		this.id = id;
		this.size = size;
		this.color = color;
		this.seller = seller;
		
	}
	
	
	

	public ProductDetails(int id, int size, String color, String seller, Date expiryDate, Product product) {
		super();
		this.id = id;
		this.size = size;
		this.color = color;
		this.seller = seller;
		this.expiryDate = expiryDate;
		this.product = product;
	}
	public ProductDetails() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", size=" + size + ", color=" + color + ", seller=" + seller
				+ ", expiryDate=" + expiryDate + ", product=" + product + "]";
	}

	
//	@Override
//	public String toString() {
//		return "ProductDetails [id=" + id + ", size=" + size + ", color=" + color + ", seller=" + seller + ", product="
//				+ product + "]";
//	}
	

	

}
