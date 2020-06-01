package com.hcl.redhat.soe.customer.model;

import java.util.List;

public class CustomerModel {
	private String customerId;
	private String customerName;
	private String customerNumber;
	private String customerEmail;
	private String customerAddress;
	private List<ProductModel> products;

	public CustomerModel() {
		super();
	}

	public CustomerModel(String customerId, String customerName, String customerNumber, String customerEmail, String customerAddress, List<ProductModel> products) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.products = products;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

}