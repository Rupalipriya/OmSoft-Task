package com.customer.mangmnt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	private Integer customerId;
	@Column
	private String customerName;
	@Column
	private String productName;
	@Column
	private Double productPrice;
	@Column
	private Double qtySold;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getQtySold() {
		return qtySold;
	}

	public void setQtySold(Double qtySold) {
		this.qtySold = qtySold;
	}

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerName, String productName, Double productPrice, Double qtySold) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.qtySold = qtySold;
	}

}
