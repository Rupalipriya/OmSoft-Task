package com.customer.mangmnt.entity;


public class Revenue {
	
	
	private Integer customerId;
	private String customerName;
	private Double totalRevenue;
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
	public Double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	@Override
	public String toString() {
		return "Revenue [customerId=" + customerId + ", customerName=" + customerName + ", totalRevenue=" + totalRevenue
				+ "]";
	}
	
	
	

}
