package com.ust.springangularint.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Product implements Comparable<Product> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;

	public String name;
	public String category;
	public Double price;
	public Date expiryDate;
	
	
	@Version
	int version;
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<ProductDetails> productDetails;

//	mappedBy = "product", , fetch=FetchType.LAZY
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public Product() {
		super();
	}

	
	public Product(int id, String name, Double price, int version, List<ProductDetails> productDetails) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.version = version;
		this.productDetails = productDetails;
	}
	
	

	public Product(int id, String name, String category, Double price, Date expiryDate, int version,
			List<ProductDetails> productDetails) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.expiryDate = expiryDate;
		this.version = version;
		this.productDetails = productDetails;
	}

	public Product(int id, String name, Double price, Date expiryDate, int version,
			List<ProductDetails> productDetails) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.expiryDate = expiryDate;
		this.version = version;
		this.productDetails = productDetails;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcategory() {
		return category;
	}

	public void setcategory(String categoty) {
		this.category = categoty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	
	
	
	
	

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", version=" + version
//				+ ", productDetails=" + productDetails + "]";
//	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", expiryDate="
				+ expiryDate + ", version=" + version + ", productDetails=" + productDetails + "]";
	}

	// @Override
	// public int compareTo(Employee o) {
	// if(this.id > o.id) {
	// return 1;
	// }
	// else if(this.id < o.id) {
	// return -1;
	// }
	// else {
	// return 0;
	// }
	// }
	public int compareTo(Product o) {
		if (this.id > o.id) {
			return 1;
		} else if (this.id < o.id) {
			return -1;
		} else {
			return 0;
		}
	}

}
