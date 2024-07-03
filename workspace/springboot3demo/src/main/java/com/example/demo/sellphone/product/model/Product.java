package com.example.demo.sellphone.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "p0001_products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	@Column(name = "PRODUCTNAME")
	private String productName;
	@Column(name = "PRICE")
	private String price;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "STOCKQUANTITY")
	private String stockQuantity;

	public Product(String productName, String price, String description, String stockQuantity) {
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.stockQuantity = stockQuantity;

	}

	public Product() {

	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}
