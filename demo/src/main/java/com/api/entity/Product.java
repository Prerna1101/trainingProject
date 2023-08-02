package com.api.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	private int productId;
	private String productName;
	private String productDescription;
	private Date expiryDate;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String productDescription, Date expiryDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.expiryDate = expiryDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", expiryDate=" + expiryDate + "]";
	}

}
